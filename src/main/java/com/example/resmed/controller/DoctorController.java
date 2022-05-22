package com.example.resmed.controller;


import com.example.resmed.entity.Doctor;
import com.example.resmed.entity.Speciality;
import com.example.resmed.repository.DoctorRepository;
import com.example.resmed.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @RequestMapping(value="doctor", method = RequestMethod.GET)
    public @ResponseBody
    Doctor getDoctor(@RequestParam("id") Long doctorId){

        Doctor dr = doctorRepository.findByDoctorId(doctorId);

        return dr;
    }
    @RequestMapping(value="specialitydoctors", method = RequestMethod.GET)
    public @ResponseBody
    Set<Doctor> getSpecialityDoctors(@RequestParam("id") Long specialityId){

        Speciality i = specialityRepository.findBySpecialityId(specialityId);
        Set<Doctor> doctorList=  doctorRepository.findBySpeciality(i);
       // List<Doctor> doctorList=doctorRepository.findBySpecialityId(specialityId);
        return doctorList;
    }

    @RequestMapping(value="sp", method = RequestMethod.GET)
    public @ResponseBody
    Speciality getSpeciality(@RequestParam("id") Long spId){

        Speciality sp = specialityRepository.findBySpecialityId(spId);

        return sp;
    }
}
