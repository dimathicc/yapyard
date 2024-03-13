package com.dimathicc.yapyard.dto;

import com.dimathicc.yapyard.model.Role;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthDTO {
    @NotNull(message = "Имя пользователя или пароль не могут быть пустыми")
    @Size(min = 5, max = 30, message = "Имя пользователя должно быть в диапазоне от 5 до 30 символов")
    private String username;
    @NotNull(message = "Имя пользователя или пароль не могут быть пустыми")
    private String password;
    private Role role;
}
