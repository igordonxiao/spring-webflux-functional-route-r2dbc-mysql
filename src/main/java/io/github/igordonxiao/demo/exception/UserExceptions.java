package io.github.igordonxiao.demo.exception;

public interface UserExceptions {
    RuntimeException USER_NOT_FOUND = new RuntimeException("未找到用户");
    RuntimeException BAD_USER = new RuntimeException("用户参数不正确");
}
