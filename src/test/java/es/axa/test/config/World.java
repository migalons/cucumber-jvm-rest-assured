package es.axa.test.config;

import es.axa.test.data.Repository;
import es.axa.test.data.User;
import io.restassured.response.Response;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("es.axa.test")
public class World {

    public User user;
    public Repository repository;

    public Response response;
}
