package com.codeclan.example.WhiskyTracker.repositories;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long> {
    List<Whisky> findByAge(int age);

    List<Whisky> findByDistillery_Region(String region);

    List<Whisky> findByAgeAndDistillery_Id(int age, Long id);







}
