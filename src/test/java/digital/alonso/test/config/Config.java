package digital.alonso.test.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("application.properties")
@ComponentScan("digital.alonso.test")
@Component("Config")
public class Config {
}
