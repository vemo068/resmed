package com.example.resmed.repository;

import com.example.resmed.entity.Rdv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RdvRepository extends JpaRepository<Rdv,Long> {
}
