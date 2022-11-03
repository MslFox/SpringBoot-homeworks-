package ru.netology.springbootdemo.repository;

import java.util.HashMap;
import java.util.List;

public class UserRepository {
    private final HashMap<String, List<Authorities>> repository;

    public UserRepository() {
        repository = new HashMap<>();
        repository.put("11", List.of(Authorities.values()));
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        return repository.get(user + password);
    }
}