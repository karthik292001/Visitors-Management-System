package com.example.vms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vms.entities.Organizations;
import com.example.vms.services.OrganizationService;

@RestController
@RequestMapping("/organization")
public class OrganizationController {
    @Autowired
    OrganizationService oSrv;


    @PostMapping("/add")
    public String addOrganization(@RequestBody Organizations o){
        oSrv.add(o);
        return "Added successfully";
    }

    @GetMapping("/read")
    public List<Organizations> readOrganizations(){
        return oSrv.getAll();
    }

}
