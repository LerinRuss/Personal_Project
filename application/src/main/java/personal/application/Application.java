package personal.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import personal.security.config.SecurityConfiguration;
import personal.web_game.GameConfig;


@SpringBootApplication
@ComponentScan({
        "personal.web_game",
        "personal.security"
})
@Import({
    SecurityConfiguration.class,
    GameConfig.class
})
@EnableJpaRepositories({
        "personal.security.repository"
})
@EntityScan({
        "personal.security.entity"
})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
