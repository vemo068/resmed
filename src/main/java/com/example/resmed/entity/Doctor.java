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

    public int getHourLimit() {
        return hourLimit;
    }

    public void setHourLimit(int hourLimit) {
        this.hourLimit = hourLimit;
    }

    private String name;
    private String password;
    private String phoneNumber;
    private int hourLimit;

    @ManyToOne
    @JoinColumn(name = "speciality_id")
    private Speciality speciality;

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

//    @ManyToOne
//    @JoinColumn(name = "speciality_speciality_id")
//    private Speciality speciality;
//
//    public Speciality getSpeciality() {
//        return speciality;
//    }
//
//    public void setSpeciality(Speciality speciality) {
//        this.speciality = speciality;
//    }

    public Doctor(Long doctorId) {
        this.doctorId = doctorId;
    }
//
//    @ManyToOne
//    @JoinColumn(name="specialityId", nullable=false)
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
