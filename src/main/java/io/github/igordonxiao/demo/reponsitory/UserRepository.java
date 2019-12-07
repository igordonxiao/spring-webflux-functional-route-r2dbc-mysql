package io.github.igordonxiao.demo.reponsitory;

import io.github.igordonxiao.demo.domain.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepository extends ReactiveCrudRepository<User, Long> {
}