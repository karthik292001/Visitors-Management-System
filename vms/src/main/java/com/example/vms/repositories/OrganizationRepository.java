package com.example.vms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vms.entities.Organizations;

public interface  OrganizationRepository extends JpaRepository<Organizations, Integer>{
    
}
