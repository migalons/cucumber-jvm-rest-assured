package es.axa.test.steps;

import cucumber.api.java8.En;
import es.axa.test.config.World;
import es.axa.test.data.Repository;
import es.axa.test.data.User;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Stepdefs implements En {

    @Autowired
    private RequestSpecification request;

    @Autowired
    @Qualifier("World")
    private World world;

    private Response response;

    public Stepdefs() {

        Given("a user with some repositories", () -> {

            response = request.get( "/users");
            JSONArray body = new JSONArray(response.body().asString());
            world.user = new User((String)((JSONObject) body.get(0)).get("login"));
        });


        Given("some public repository", () -> {
            response = request.get( "/repositories");
            JSONArray body = new JSONArray(response.body().asString());
            world.repository = new Repository((Integer) ((JSONObject) body.get(0)).get("id"),
                    (String)((JSONObject) body.get(0)).get("name"), (String)((JSONObject) body.get(0)).get("full_name"));
        });


    }


}
