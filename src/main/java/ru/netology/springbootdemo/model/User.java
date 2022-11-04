package ru.netology.springbootdemo.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

public class User {
    @NotNull
    @Size(min = 2, max = 20)
    @Pattern(regexp = "^[а-яА-ЯёЁa-zA-Z]+$")
    private String user;
    @NotNull
    @Size(min = 8, max = 32)
    private String password;

    public User() {
    }

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(this.user, user.user) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, password);
    }

}
