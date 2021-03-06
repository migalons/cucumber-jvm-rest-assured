package digital.alonso.test.steps;

import cucumber.api.java8.En;
import digital.alonso.test.config.World;
import digital.alonso.test.data.Repository;
import digital.alonso.test.data.User;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;

@Scope("cucumber-glue")
public class Stepdefs implements En {

    @Autowired
    private RequestSpecification request;

    @Autowired
    @Qualifier("World")
    private World world;

    private Response response;

    public Stepdefs() {

        Given("a user with some repositories", () ->
                world.setUser(new User(request.get( "/users").thenReturn().getBody().jsonPath().get("login[0]"))));


        Given("some public repository", () -> {
            response = request.given().get( "/repositories");
            world.setRepository(new Repository( response.jsonPath().get("id[0]"),
                    response.jsonPath().get("name[0]"),response.jsonPath().get("full_name[0]")));
        });
    }
}
