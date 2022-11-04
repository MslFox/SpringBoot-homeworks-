package ru.netology.springbootdemo.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import ru.netology.springbootdemo.exception.UnauthorizedUser;
import ru.netology.springbootdemo.model.User;
import ru.netology.springbootdemo.repository.Authorities;
import ru.netology.springbootdemo.repository.UserRepository;

import java.util.List;

public class AuthorizationService {
    @Autowired
    private UserRepository userRepository;

    public List<Authorities> getAuthorities(User user) {
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user.getUser());
        }
        return userAuthorities;
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}