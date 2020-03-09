package personal.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import personal.web_game.GameConfig;
import personal.security.SecurityConfiguration;

@SpringBootApplication
@ComponentScan({
    "personal.web_game"
})
@Import({
    SecurityConfiguration.class,
    GameConfig.class
})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
