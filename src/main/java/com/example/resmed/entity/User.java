package com.example.resmed.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    private long userId;
    private String name;
    private String password;
    private String email;
    private String phoneNumber;


    public User(long userId) {
        this.userId = userId;
    }

}
