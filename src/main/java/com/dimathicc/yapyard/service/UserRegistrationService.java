package com.dimathicc.yapyard.service;

import com.dimathicc.yapyard.dto.AuthDTO;
import com.dimathicc.yapyard.exception.UserAlreadyExists;
import com.dimathicc.yapyard.model.User;
import com.dimathicc.yapyard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRegistrationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public User save(User user) {
        return repository.save(user);
    }

    public User registerNewUser(AuthDTO authDTO) {

        var user = new User();
        user.setUsername(authDTO.getUsername());
        user.setPassword(passwordEncoder.encode(authDTO.getPassword()));
        user.setRole(authDTO.getRole());

        if (repository.existsByUsername(user.getUsername())) {
            throw new UserAlreadyExists("Пользователь с таким именем уже существует");
        }

        return save(user);
    }
}
