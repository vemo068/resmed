package com.example.resmed.repository;

import com.example.resmed.entity.HourLabel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HourLabelRepository extends JpaRepository<HourLabel,Long> {

    HourLabel findByLabelId(Long id);

}
