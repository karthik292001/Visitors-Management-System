package com.example.vms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vms.entities.Visiting;

public interface VisitingRepository extends JpaRepository<Visiting, Integer>{

    List<Visiting> findAllByVisitorId(int id);

    List<Visiting> findAllByEmpId(int id);
    
}
