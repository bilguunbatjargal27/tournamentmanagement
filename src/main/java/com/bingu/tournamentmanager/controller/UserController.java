package com.bingu.tournamentmanager.controller;

import com.bingu.tournamentmanager.model.User;
import com.bingu.tournamentmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public ResponseEntity<?> getAllUsers() {
        List<User> Users = (List<User>) userService.findAll();
        return ResponseEntity.ok(Users);
    }


    @GetMapping("/{username}")
    public ResponseEntity<?> getUserById(@PathVariable("username") String username) {
        User User = userService.findUserByUsername(username);
        return ResponseEntity.ok(User);
    }


    @PostMapping("/add")
    public ResponseEntity<?> saveUser(@RequestBody final User user) {
        User responseUser = userService.saveUser(user);
        return ResponseEntity.ok(responseUser);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody final User updatedUser) {
        User responseUser = userService.saveUser(updatedUser);
        return ResponseEntity.ok(responseUser);
    }

    @DeleteMapping("/delete/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable("username") String username) {
        User user = userService.findUserByUsername(username);
        if(user == null) return ResponseEntity.badRequest().body("No user with given username = " + username);
        userService.deleteUser(username);
        return ResponseEntity.ok("Successfully deleted");
    }

}
