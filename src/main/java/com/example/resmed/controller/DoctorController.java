package com.example.resmed.controller;


import com.example.resmed.entity.Doctor;
import com.example.resmed.entity.Rdv;
import com.example.resmed.entity.Speciality;
import com.example.resmed.entity.User;
import com.example.resmed.repository.DoctorRepository;
import com.example.resmed.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
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
    public Set<Doctor> getAllDoctors() {
        return doctorRepository.findByVerified(true);
    }


    @GetMapping("/notverifieddoctors")
    public Set<Doctor> getAllNotVerifiedDoctors() {
        return doctorRepository.findByVerified(false);
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
        Set<Doctor> doctorList=  doctorRepository.findBySpecialityAndVerified(i,true);

        return doctorList;
    }


    @PostMapping("/addDoctor")
    public ResponseEntity<Doctor> postBody(@RequestBody Doctor doctor) throws URISyntaxException {

        Doctor neUser= Doctor.builder()
                .email(doctor.getEmail())
                .hourLimit(doctor.getHourLimit())
                .mapUrl(doctor.getMapUrl())
                .name(doctor.getName())
                .password(doctor.getPassword())
                .price(doctor.getPrice())
                .phoneNumber(doctor.getPhoneNumber())
                .speciality(doctor.getSpeciality())
                .build();
        Doctor newDoctor=doctorRepository.save(neUser);
        if (newDoctor == null) {
            return ResponseEntity.notFound().build();
        } else {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(newDoctor.getDoctorId())
                    .toUri();

            return ResponseEntity.created(uri)
                    .body(newDoctor);
        }
    }


    @RequestMapping(value="verifydoctor", method = RequestMethod.GET)
    public @ResponseBody
    void updateRdv(@RequestParam("id") Long dr_id){

        Doctor v=doctorRepository.findByDoctorId(dr_id);
        v.setVerified(true);
        doctorRepository.save(v);

    }
    
    @RequestMapping(value="sp", method = RequestMethod.GET)
    public @ResponseBody
    Speciality getSpeciality(@RequestParam("id") Long spId){

        Speciality sp = specialityRepository.findBySpecialityId(spId);

        return sp;
    }

    @PostMapping("/addspec")
    public ResponseEntity<Speciality> postBody(@RequestBody Speciality spec) throws URISyntaxException {

        Speciality neUser=Speciality.builder()
                .imgUrl(spec.getImgUrl())
                .specialityName(spec.getSpecialityName())
                .build();
        Speciality newUser=specialityRepository.save(neUser);
        if (newUser == null) {
            return ResponseEntity.notFound().build();
        } else {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(newUser.getSpecialityId())
                    .toUri();

            return ResponseEntity.created(uri)
                    .body(newUser);
        }
    }
}
