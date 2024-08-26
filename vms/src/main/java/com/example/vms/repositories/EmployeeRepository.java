package com.example.vms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vms.entities.Employee;

public interface  EmployeeRepository extends JpaRepository<Employee, Integer>{

    List<Employee> findAllByOrganizationId(int id);
    
}
