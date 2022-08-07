package com.example.resmed.entity;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue
    private long userId;
    private String name;
    private String password;
    private String email;
    private String phoneNumber;


    public User(long userId) {
        this.userId = userId;
    }

    public User( String name) {

        this.name = name;
    }


}
