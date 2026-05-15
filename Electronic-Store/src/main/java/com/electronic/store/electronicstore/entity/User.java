package com.electronic.store.electronicstore.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.electronic.store.electronicstore.enums.Gender;
import com.electronic.store.electronicstore.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    private String userId;

    @Column(name="name" )
    private String username;

    @Column(name = "email",  unique = true, length = 100)
    private String email;

    @Column(name = "password", length = 100)
    private String password;

    private Gender gender;

    private Role role;

}
