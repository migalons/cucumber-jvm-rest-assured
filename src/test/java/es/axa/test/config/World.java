package es.axa.test.config;

import es.axa.test.data.Repository;
import es.axa.test.data.User;
import io.restassured.response.Response;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("es.axa.test")
@Getter @Setter
public class World {

    private User user;
    private Repository repository;

    private Response response;
}
