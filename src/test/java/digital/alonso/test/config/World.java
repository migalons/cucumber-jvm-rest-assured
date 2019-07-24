package digital.alonso.test.config;

import digital.alonso.test.data.Repository;
import digital.alonso.test.data.User;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("World")
@ComponentScan("digital.alonso.test")
@Getter @Setter
@Scope("cucumber-glue")
public class World {

    private User user;
    private Repository repository;

    private Response response;
}
