package es.axa.test.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@PropertySource("application.properties")
@ComponentScan("es.axa.test")
public class Config {
}
