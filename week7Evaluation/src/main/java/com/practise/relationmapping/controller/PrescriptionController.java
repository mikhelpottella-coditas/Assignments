package com.practise.relationmapping.controller;

import com.practise.relationmapping.dto.PrescriptionRequestDto;
import com.practise.relationmapping.entity.Prescription;
import com.practise.relationmapping.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prescription")
public class PrescriptionController {

    PrescriptionService service;


    public PrescriptionController(PrescriptionService service){
        this.service = service;
    }

// Create a new prescription
    @PostMapping("/register")
    public void registerPrescription(@RequestBody PrescriptionRequestDto dto){
        service.registerPrescription(dto);
    }

}
