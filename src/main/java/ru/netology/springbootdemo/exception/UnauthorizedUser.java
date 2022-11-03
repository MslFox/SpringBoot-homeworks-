package ru.netology.springbootdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UnauthorizedUser extends RuntimeException {
    public UnauthorizedUser(String msg) {
        System.out.println(msg);
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, msg);
    }
}