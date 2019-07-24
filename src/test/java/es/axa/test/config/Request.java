package es.axa.test.config;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component("Request")
@ComponentScan("es.axa.test")
public class Request {

    @Value("${baseUri:http://localhost}")
    private String baseUri;

    @Bean
    public RequestSpecification context() {
        RequestSpecification request = RestAssured.given();
        request.baseUri(baseUri);
        return request;
    }

}
