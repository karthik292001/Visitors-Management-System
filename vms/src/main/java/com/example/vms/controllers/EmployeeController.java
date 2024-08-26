package com.example.vms.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vms.entities.Employee;
import com.example.vms.entities.Organizations;
import com.example.vms.repositories.EmployeeRepository;
import com.example.vms.repositories.OrganizationRepository;
import com.example.vms.services.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService eSrv;


    @Autowired
    EmployeeRepository eRepo;

    @Autowired
    OrganizationRepository oRepo;

    @PostMapping("/add")
    public String addEmployee(@RequestBody Employee e){
        Organizations or=oRepo.findById(e.getOrganization_id()).orElse(null);
        e.setOrganization(or);
        eSrv.add(e);
        return "Employee added successfully";
    }

    @PostMapping("/read")
    public Employee readEmployee(@RequestBody Map<String, Integer> requestBody){
        int id=requestBody.get("id");
        return eRepo.findById(id).get();
    }

    @PostMapping("/updateStatus")
    public String updateStatus(@RequestBody Map<String, Integer> requestBody){
        int id=requestBody.get("id");
        eSrv.update(id);
        return "Status updated successfully";
    }

    @PostMapping("/readEmployees")
    public List<Employee> employees(@RequestBody Map<String, Integer> requestBody){
        int id=requestBody.get("id");
        return eSrv.getEmployees(id);
    }
    
}
