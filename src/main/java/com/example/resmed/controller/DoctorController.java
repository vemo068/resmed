package com.example.resmed.controller;


import com.example.resmed.entity.Doctor;
import com.example.resmed.entity.Speciality;
import com.example.resmed.repository.DoctorRepository;
import com.example.resmed.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private SpecialityRepository specialityRepository;

    @GetMapping("/sps")
    public List<Speciality> getAllSpecialities() {
        return specialityRepository.findAll();
    }

    @GetMapping("/doctors")
    public List<Doctor> getAllUsers() {
        return doctorRepository.findAll();
    }



}
