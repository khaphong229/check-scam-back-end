package java_backend.check_scammer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class CheckScammerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CheckScammerApplication.class, args);
    }

}
