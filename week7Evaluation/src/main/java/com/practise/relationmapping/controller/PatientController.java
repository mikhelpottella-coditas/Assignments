package com.practise.relationmapping.controller;

import com.practise.relationmapping.dto.PatientRequestDto;
import com.practise.relationmapping.entity.Patient;
import com.practise.relationmapping.entity.PatientType;
import com.practise.relationmapping.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }


//    POST Register a new patient
    @PostMapping("register")
    public String registerPatient(@RequestBody PatientRequestDto patientRequestDto){
        return patientService.registerPatient(patientRequestDto);
    }


//    GET Get all patients

    @GetMapping("/all")
    public List<Patient> getAllPatients(){
        return patientService.getAllpatients();
    }


//    GET Get a specific patient
    @GetMapping("/{id}")
    public Patient getById(@PathVariable Long id){
        return patientService.getById(id);
    }

//    GET Get the calculated bill for a patient
    @GetMapping("/{id}/bill")
    public String getBillById(@PathVariable Long id){
        return patientService.getBillById(id);
    }

//    GET Get all INPATIENT or OUTPATIENT patients
    @GetMapping("/type/{type}")
    public List<Patient> getAllPatientByType(@PathVariable PatientType patientType){
        return patientService.getAllPatientByType(patientType);
    }


}
