package group.modulelibrary.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"group.modulelibrary"})
@EnableJpaRepositories(basePackages = {"group.modulelibrary"})
@EntityScan(basePackages = {"group.modulelibrary"})
public class RestApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class);
    }

}
