package com.example.vms.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vms.entities.Visiting;
import com.example.vms.repositories.VisitingRepository;

@Service
public class VisitingService {

    @Autowired
    VisitingRepository visitRepo;

    public void add(Visiting visit) {
        visitRepo.save(visit);
    }

    public void updateStatus(int id, String status) {
        Visiting v=visitRepo.findById(id).get();
        v.setStatus(status);
        visitRepo.save(v);
    }

    public List<Visiting> visitingOrVisitors(int id, String keyword) {
        if(keyword.equalsIgnoreCase("visiting")){
            return visitRepo.findAllByVisitorId(id);
        }else if(keyword.equalsIgnoreCase("visitors")){
            List<Visiting> vts=visitRepo.findAllByEmpId(id);
            List<Visiting> accepted=new ArrayList<>();
            for(Visiting v:vts){
                if(v.getStatus().equalsIgnoreCase("accepted")){
                    accepted.add(v);
                }
            }
            return accepted;
        }
        return null;
    }

    public List<Visiting> readAll(int id) {
        return visitRepo.findAllByEmpId(id);
    }
    
}
