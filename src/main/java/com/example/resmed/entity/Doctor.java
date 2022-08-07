package com.example.resmed.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Doctor {
    @Id
    @GeneratedValue
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
    @Column(columnDefinition = "boolean default false")
    private boolean verified;
    private int price;
    private String mapUrl;

    @ManyToOne
    @JoinColumn(name = "speciality_id")
    private Speciality speciality;

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }


    public Doctor(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Doctor(String email, String name, String password, String phoneNumber, int hourLimit, boolean verified, int price, String mapUrl, Speciality speciality) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.hourLimit = hourLimit;
        this.verified = verified;
        this.price = price;
        this.mapUrl = mapUrl;
        this.speciality = speciality;
    }

    public String getMapUrl() {
        return mapUrl;
    }

    public void setMapUrl(String mapUrl) {
        this.mapUrl = mapUrl;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }
}
