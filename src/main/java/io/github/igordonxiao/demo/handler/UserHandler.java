package io.github.igordonxiao.demo.handler;

import io.github.igordonxiao.demo.domain.User;
import io.github.igordonxiao.demo.reponsitory.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class UserHandler {
    private final Logger log = LoggerFactory.getLogger(UserHandler.class);

    private UserRepository userRepository;

    UserHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<ServerResponse> listUsers(ServerRequest request) {
        return ok().contentType(APPLICATION_JSON).body(userRepository.findAll(), User.class);
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        return ok().body(userRepository.findById(request.bodyToMono(Long.class)), User.class);
    }

    public Mono<ServerResponse> saveUser(ServerRequest request) {
        return ok().contentType(APPLICATION_JSON).body(request.bodyToMono(User.class).flatMap(user -> userRepository.save(user)), User.class);
    }
}
