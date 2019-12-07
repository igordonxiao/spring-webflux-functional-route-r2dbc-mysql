package io.github.igordonxiao.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@EnableR2dbcRepositories
public class SpringWebfluxFunctionalRouteR2dbcMysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebfluxFunctionalRouteR2dbcMysqlApplication.class, args);
    }

}
