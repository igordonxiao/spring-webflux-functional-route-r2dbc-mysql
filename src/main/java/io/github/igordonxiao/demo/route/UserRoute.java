package io.github.igordonxiao.demo.route;

import io.github.igordonxiao.demo.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class UserRoute {

    private UserHandler userHandler;

    public UserRoute(UserHandler userHandler) {
        this.userHandler = userHandler;
    }

    @Bean
    public RouterFunction<ServerResponse> userRoutes() {
        return route().nest(path("/users"), r ->
                r.GET("/", userHandler::listUsers)
                        .GET("/{id}", userHandler::findById)
                        .POST("/", userHandler::saveUser)
                        .build())
                .build();

    }

}
