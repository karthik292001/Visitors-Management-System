package com.example.vms.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Visiting {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private int empId;
    private int visitorId;
    private String visitorName;
    private String empName;
    private String company;
    private String date="25/09/2024";
    private String status="requested";

    
}
