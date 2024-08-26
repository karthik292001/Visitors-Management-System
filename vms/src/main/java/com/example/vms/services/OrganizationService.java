package com.example.vms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vms.entities.Organizations;
import com.example.vms.repositories.OrganizationRepository;

@Service
public class OrganizationService {

    @Autowired
    OrganizationRepository oRepo;

    public void add(Organizations o) {
        oRepo.save(o);
    }

    public List<Organizations> getAll() {
        return oRepo.findAll();
    }


    
}
