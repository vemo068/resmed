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
public class Rdv {

    @Id
    @GeneratedValue
    private Long appointId;

    private String date;
    @Column(columnDefinition = "boolean default false")
    private boolean completed;
    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

    @OneToOne
    @JoinColumn(name = "doctorId")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "label_id",nullable = false)
    private HourLabel hourLabel;

    public Rdv(String date,User user, Doctor doctor, HourLabel hourLabel) {
        this.user = user;
        this.date=date;
        this.doctor = doctor;
        this.hourLabel = hourLabel;
    }

    public HourLabel getHourLabel() {
        return hourLabel;
    }

    public void setHourLabel(HourLabel hourLabel) {
        this.hourLabel = hourLabel;
    }

    public Long getAppointId() {
        return appointId;
    }

    public void setAppointId(Long appointId) {
        this.appointId = appointId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
