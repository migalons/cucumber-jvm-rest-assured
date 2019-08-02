package es.axa.test.steps;

import cucumber.api.java8.En;
import es.axa.test.config.World;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class OtherStepdefs implements En {

    @Autowired
    public OtherStepdefs(World world, RequestSpecification request) {

        When("I ask for user's repositories", () ->
                world.setResponse(request.when().get("/users/" +  world.getUser().getLogin() + "/repos")));

        Then("I get listed all his repositories", () ->
                world.getResponse().
                    then().
                        statusCode(HttpStatus.SC_OK).
                        assertThat().body(matchesJsonSchemaInClasspath("schemas/repositories.json")));


        When("I ask for this repository contributors", () ->
                world.setResponse(request.when().get("/repos/" +  world.getRepository().getFullName() + "/contributors")));

        Then("I get listed all contributors with name and login", () ->
                world.getResponse().
                    then().
                        statusCode(HttpStatus.SC_OK).
                        assertThat().body(matchesJsonSchemaInClasspath("schemas/repository_contributors.json")));
    }
}
