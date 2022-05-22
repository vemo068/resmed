package com.example.resmed.repository;

import com.example.resmed.entity.Doctor;
import com.example.resmed.entity.HourLabel;
import com.example.resmed.entity.Rdv;
import com.example.resmed.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RdvRepository extends JpaRepository<Rdv,Long> {
    public List<Rdv> findByHourLabelAndDoctorAndDate(HourLabel hr, Doctor dr,String Date);

}
