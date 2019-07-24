package digital.alonso.test.config;

import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;

@Component("Request")
@ComponentScan("digital.alonso.test")
public class Request {

    @Value("${baseUri:http://localhost}")
    private String baseUri;

    @Bean
    @Scope("cucumber-glue")
    public RequestSpecification context() {
        return given().baseUri(baseUri).log().ifValidationFails();
    }

}
