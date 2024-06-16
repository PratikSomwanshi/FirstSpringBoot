package com.pratik.controller;

import java.util.List;
import java.util.Optional;

import com.pratik.dto.SuccessResponse;
import com.pratik.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pratik.entity.User;
import com.pratik.services.UserService;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<SuccessResponse> getAllUsers() {

        try {
            List<User> users = userService.getAllUsers();

            SuccessResponse<User> response = new SuccessResponse<>(true, "Successfully retrieved user", users);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (NullPointerException ex){
            throw new CustomException(ex.getMessage(), HttpStatus.NOT_FOUND);
        }


    }

    @GetMapping("/{id}")
    public ResponseEntity<SuccessResponse> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);

        if(user.isEmpty()) {
            throw new CustomException("User not found", HttpStatus.NOT_FOUND);
        }
        SuccessResponse<User> response = new SuccessResponse<>(true, "Successfully retrieved user", user.get());
        return new ResponseEntity<>(response, HttpStatus.OK);


//        return user.orElseThrow(() -> new CustomException("User not found", HttpStatus.NOT_FOUND));


    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()) {
            User existingUser = user.get();
            existingUser.setName(userDetails.getName());
            existingUser.setEmail(userDetails.getEmail());
            return ResponseEntity.ok(userService.saveUser(existingUser));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()) {
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

