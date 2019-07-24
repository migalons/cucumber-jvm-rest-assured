package es.axa.test.steps;

import cucumber.api.java8.En;
import es.axa.test.config.World;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class OtherStepdefs implements En {

    @Autowired
    public OtherStepdefs(World world, RequestSpecification request) {

        When("I ask for user's repositories", () -> {
            world.response = request.when().get("/users/" +  world.user.getLogin() + "/repos");
        });

        Then("I get listed all his repositories", () -> {
            ValidatableResponse response = world.response.then();
            response.log().ifError();
            response.statusCode(200);
            response.assertThat().body(matchesJsonSchemaInClasspath("schemas/repositories.json"));
        });


        When("I ask for this repository contributors", () -> {
            world.response = request.when().get("/repos/" +  world.repository.getFullName() + "/contributors");
        });

        Then("I get listed all contributors with name and login", () -> {
            ValidatableResponse response = world.response.then();
            response.log().ifError();
            response.statusCode(200);
            response.assertThat().body(matchesJsonSchemaInClasspath("schemas/repository_contributors.json"));
        });

    }


}
