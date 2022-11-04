package ru.netology.springbootdemo.repository;

import ru.netology.springbootdemo.model.User;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class UserRepository {
    private final ConcurrentHashMap<User, List<Authorities>> repository = new ConcurrentHashMap<>();

    public UserRepository() {
        repository.put(new User("Mihail", "My_PasSwOrd"), List.of(Authorities.values()));
        repository.put(new User("Sergey", "My_PasSwOrd"), List.of(Authorities.DELETE,Authorities.READ));
    }

    public List<Authorities> getUserAuthorities(User user) {
        return repository.get(user);
    }
}