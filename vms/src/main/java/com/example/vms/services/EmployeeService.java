package com.example.vms.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vms.entities.Employee;
import com.example.vms.repositories.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository eRepo;

    public void add(Employee e) {
        eRepo.save(e);
    }

    public void update(int id) {
        Employee e=eRepo.findById(id).get();
        if(e.getIsAvailable().equalsIgnoreCase("available")){
            e.setIsAvailable("notAvailable");
        }else{
            e.setIsAvailable("available");
        }
        eRepo.save(e);
    }

    public List<Employee> getEmployees(int id) {
        List<Employee> employees= eRepo.findAllByOrganizationId(id);
        List<Employee> available=new ArrayList<>();
        for(Employee e:employees){
            if(e.getIsAvailable().equalsIgnoreCase("available")){
                available.add(e);
            }
        }
        return available;
    }


    
}
