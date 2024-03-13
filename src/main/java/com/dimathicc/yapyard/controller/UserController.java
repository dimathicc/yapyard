package com.dimathicc.yapyard.controller;

import com.dimathicc.yapyard.client.UserClient;
import com.dimathicc.yapyard.dto.UserDTO;
import com.dimathicc.yapyard.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserClient userClient;


    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userClient.listUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUser(@PathVariable long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(userClient.userById(userId));
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userClient.createNewUser(user));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userClient.deleteUser(userId));
    }

}
