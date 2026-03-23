package com.practise.relationmapping.controller;

import com.practise.relationmapping.dto.FullDetailPrescriptionResponseDto;
import com.practise.relationmapping.dto.PrescriptionRequestDto;
import com.practise.relationmapping.service.PrescriptionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

//    GET Get a specific prescription with full patient and medicine details
    @GetMapping("/fullDetailsById/{id}")
    public FullDetailPrescriptionResponseDto fullDetailsById(@PathVariable Long id){
        return service.fullDetailsById(id);
    }

    // get all the prescriptions
    @GetMapping("/all")
    public List<FullDetailPrescriptionResponseDto> getAll(){
        return service.getAll();
    }


//    DELETE Cancel a prescription
    @DeleteMapping("/delete/{id}")
    public void deletePrescription(@PathVariable Long id){
        service.deleteById(id);
    }
}
