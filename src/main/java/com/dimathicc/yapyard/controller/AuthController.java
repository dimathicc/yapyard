package com.dimathicc.yapyard.controller;


import com.dimathicc.yapyard.model.User;
import com.dimathicc.yapyard.dto.AuthDTO;
import com.dimathicc.yapyard.service.UserRegistrationService;
import com.dimathicc.yapyard.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class AuthController {

    private final UserRegistrationService service;

    @PostMapping
    public ResponseEntity<User> registerNewUser(@RequestBody @Valid AuthDTO authDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.registerNewUser(authDTO));
    }

}