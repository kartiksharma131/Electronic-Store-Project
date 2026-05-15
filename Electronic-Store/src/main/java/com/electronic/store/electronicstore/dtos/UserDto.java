package com.electronic.store.electronicstore.dtos;

import com.electronic.store.electronicstore.enums.Gender;
import com.electronic.store.electronicstore.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class UserDto {
    @NotNull(message = "User ID cannot be null")
    private String userId;

    @Size(min = 4, max = 20, message = "User ID must be between 4 and 20 characters")
    private String username;

    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    private String password;

    private Gender gender;

    private Role role;
}
