package ru.netology.springbootdemo.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserRepository {
    private final HashMap<String, List<Authorities>> repository;

    public UserRepository() {
        repository = new HashMap<>();
        repository.put("11", new ArrayList<>());
        repository.get("11").add(Authorities.READ);
        repository.get("11").add(Authorities.WRITE);
        repository.get("11").add(Authorities.DELETE);
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        return repository.get(user + password);
    }
}