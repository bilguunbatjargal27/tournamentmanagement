package com.bingu.tournamentmanager.service.impl;

import com.bingu.tournamentmanager.model.User;
import com.bingu.tournamentmanager.repository.UserRepository;
import com.bingu.tournamentmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findById(username).orElse(null);
    }

    @Override
    public Collection<User> findAll() {
        return userRepository.findAll();
    }
}
