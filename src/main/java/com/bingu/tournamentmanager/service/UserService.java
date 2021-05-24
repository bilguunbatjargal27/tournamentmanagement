package com.bingu.tournamentmanager.service;


import com.bingu.tournamentmanager.model.User;

import java.util.Collection;

public interface UserService {

    public User saveUser(User user);
    public void deleteUser(String username);
    public User findUserByUsername(String username);
    public Collection<User> findAll();
}
