package ru.netology.springbootdemo.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import ru.netology.springbootdemo.exception.InvalidCredentials;
import ru.netology.springbootdemo.exception.UnauthorizedUser;
import ru.netology.springbootdemo.repository.Authorities;
import ru.netology.springbootdemo.repository.UserRepository;

import java.util.List;

public class AuthorizationService {
    @Autowired
    private UserRepository userRepository;

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}