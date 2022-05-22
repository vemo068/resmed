package com.example.resmed.repository;

import com.example.resmed.entity.Doctor;
import com.example.resmed.entity.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;


@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    Doctor findByDoctorId(Long id);
    Set<Doctor> findBySpeciality(Speciality speciality);
}
