package com.example.demo.entity;

import lombok.Data;

import java.util.Objects;

@Data
public class Password{
    private String website;
    private String application;
    private String account;
    private String accountPassword;
    private String owner;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Password password = (Password) o;
        return Objects.equals(website, password.website) && Objects.equals(application, password.application) && Objects.equals(owner, password.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(website, application, owner);
    }
}
