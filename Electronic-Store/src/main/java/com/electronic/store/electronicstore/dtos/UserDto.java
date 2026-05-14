package com.electronic.store.electronicstore.dtos;

import com.electronic.store.electronicstore.enums.Gender;
import com.electronic.store.electronicstore.enums.Role;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class UserDto {
    private int userId;

    private String username;

    private String email;

    private String password;

    private Gender gender;

    private Role role;
}
