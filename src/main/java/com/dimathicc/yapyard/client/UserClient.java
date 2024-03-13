package com.dimathicc.yapyard.client;

import com.dimathicc.yapyard.dto.UserDTO;
import com.dimathicc.yapyard.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "userClient", url = "https://jsonplaceholder.typicode.com/users")
public interface UserClient {

    @GetMapping("/{userId}")
    UserDTO userById(@PathVariable Long userId);

    @GetMapping
    List<UserDTO> listUsers();

    @PostMapping
    UserDTO createNewUser(User user);

    @PutMapping("/{userId}")
    UserDTO updateUser(@PathVariable Long userId, @RequestBody User user);

    @DeleteMapping("/{userId}")
    UserDTO deleteUser(@PathVariable Long userId);
}
