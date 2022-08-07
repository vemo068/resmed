package com.example.resmed.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Speciality {
    @Id
    @GeneratedValue
    private Long specialityId;
    private String imgUrl;
    private String specialityName;

//    @OneToMany(mappedBy = "speciality")
//   // @JoinColumn(name = "speciality")
//    private Set<Doctor> doctors;


    public Long getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(Long specialityId) {
        this.specialityId = specialityId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }

//    public Set<Doctor> getDoctors() {
//        return doctors;
//    }
//
//    public void setDoctors(Set<Doctor> doctors) {
//        this.doctors = doctors;
//    }
}
