package com.example.resmed.controller;


import com.example.resmed.dto.LoginInfo;
import com.example.resmed.entity.Doctor;
import com.example.resmed.entity.User;
import com.example.resmed.repository.DoctorRepository;
import com.example.resmed.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController
@RequestMapping
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping("/login")
    public User getCurrentUser(@RequestBody LoginInfo loginInfo) throws URISyntaxException {

        User currentUser=userRepository.findByEmailAndPassword(loginInfo.getEmail(), loginInfo.getPassword());


        return currentUser;

    }
    @PostMapping("/logindoctor")
    public Doctor getCurrentDoctor(@RequestBody LoginInfo loginInfo) throws URISyntaxException {

        Doctor currentUser=doctorRepository.findByEmailAndPassword(loginInfo.getEmail(), loginInfo.getPassword());


        return currentUser;

    }
}
