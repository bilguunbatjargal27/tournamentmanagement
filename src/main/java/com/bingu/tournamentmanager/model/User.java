package com.bingu.tournamentmanager.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    private String username;
    private String password;
    private String email;

    @ManyToOne
    private Team team;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String gmail) {
        this.email = gmail;
    }
}
