package ru.netology.springbootdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.springbootdemo.exception.UnauthorizedUser;
import ru.netology.springbootdemo.model.User;
import ru.netology.springbootdemo.repository.Authorities;
import ru.netology.springbootdemo.sevice.AuthorizationService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid User user) {
        return service.getAuthorities(user);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> unauthorizedUserHandler(UnauthorizedUser e) {
        System.out.println(e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<String> unauthorizedUserHandler() {
        return new ResponseEntity<>(
                """
                        User's parsing error.
                        Invalid user's data.
                        user's conditions: @NotNull, @Size(min = 2, max = 20), @Pattern(regexp = "^[а-яА-ЯёЁa-zA-Z]+$")
                        password conditions: @NotNull, @Size(min = 8, max = 32)""",
                HttpStatus.BAD_REQUEST);
    }
}