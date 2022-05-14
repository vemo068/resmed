package com.example.resmed.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Doctor {
    @Id
    private Long doctorId;
    private String email;
    private String name;
    private String password;
    private String phoneNumber;

    public Doctor(Long doctorId) {
        this.doctorId = doctorId;
    }

//    @ManyToOne
//    @JoinColumn(name = "specialityId")
//    private Speciality speciality;
//
//    public Speciality getSpeciality() {
//        return speciality;
//    }
//
//    public void setSpeciality(Speciality speciality) {
//        this.speciality = speciality;
//    }
}
