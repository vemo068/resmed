package com.example.resmed.repository;

import com.example.resmed.entity.Doctor;
import com.example.resmed.entity.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality,Long> {
    Speciality findBySpecialityId(Long id);

}
