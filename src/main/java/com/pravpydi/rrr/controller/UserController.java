package com.pravpydi.rrr.controller;

import com.pravpydi.rrr.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final ConcurrentHashMap<Long, User> users = new ConcurrentHashMap<>();
    private final AtomicLong counter = new AtomicLong();
    
    @PostConstruct
    public void init() {
        // Add sample users
        createSampleUser("John Doe", "john.doe@example.com");
        createSampleUser("Jane Smith", "jane.smith@example.com");
        createSampleUser("Robert Johnson", "robert.johnson@example.com");
        createSampleUser("Emily Davis", "emily.davis@example.com");
        createSampleUser("Michael Brown", "michael.brown@example.com");
    }
    
    private void createSampleUser(String name, String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        Long id = counter.incrementAndGet();
        user.setId(id);
        users.put(id, user);
    }

    // Get all users
    @GetMapping
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    // Get a specific user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = users.get(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create a new user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        Long id = counter.incrementAndGet();
        user.setId(id);
        users.put(id, user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    // Update an existing user
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        if (users.containsKey(id)) {
            updatedUser.setId(id);
            users.put(id, updatedUser);
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        if (users.containsKey(id)) {
            users.remove(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
} 