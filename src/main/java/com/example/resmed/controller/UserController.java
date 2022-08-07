package com.example.resmed.controller;


import com.example.resmed.dto.RendV;
import com.example.resmed.entity.Rdv;
import com.example.resmed.entity.User;
import com.example.resmed.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/adduser")
    public ResponseEntity<User> postBody(@RequestBody User user) throws URISyntaxException {

        User neUser=User.builder()
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .build();
       User newUser=userRepository.save(neUser);
        if (newUser == null) {
            return ResponseEntity.notFound().build();
        } else {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(newUser.getUserId())
                    .toUri();

            return ResponseEntity.created(uri)
                    .body(newUser);
        }
    }
}
