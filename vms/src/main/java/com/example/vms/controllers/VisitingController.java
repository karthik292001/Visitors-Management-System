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
import com.example.vms.entities.Visiting;
import com.example.vms.repositories.EmployeeRepository;
import com.example.vms.repositories.OrganizationRepository;
import com.example.vms.services.VisitingService;

@RestController
@RequestMapping("/visiting")
public class VisitingController {

    @Autowired
    VisitingService visitSrv;

    @Autowired
    EmployeeRepository eRepo;

    @Autowired
    OrganizationRepository oRepo;
    

    @PostMapping("/request")
    public String addVisiting(@RequestBody Visiting visit){
        Employee e1=eRepo.findById(visit.getEmpId()).get();
        Employee e2=eRepo.findById(visit.getVisitorId()).get();


        Organizations o = oRepo.findById(e2.getOrganization_id()).get();


        visit.setCompany(o.getName());
        visit.setEmpName(e1.getName());
        visit.setVisitorName(e2.getName());
        visitSrv.add(visit);
        return "Requested successfully";
    }

    @PostMapping("/getrequests")
    public List<Visiting> requests(@RequestBody Map<String, String> requestBody){
        int id =Integer.parseInt(requestBody.get("id"));
        return visitSrv.readAll(id);
    }

    @PostMapping("/updateStatus")
    public String updateStatus(@RequestBody Map<String, String> requestBody){
        int id =Integer.parseInt(requestBody.get("id"));
        String status = requestBody.get("status");
        
        visitSrv.updateStatus(id,status);
        return "Updated successfully";
    }

    @PostMapping("/employees")
    public List<Visiting> visitingOrVisitors(@RequestBody java.util.Map<String, String> requestBody) {
        int id =Integer.parseInt(requestBody.get("id"));
        String keyword = requestBody.get("keyword");
        System.out.println(id);
        System.out.println(keyword);
        return visitSrv.visitingOrVisitors(id, keyword);
    }
}
