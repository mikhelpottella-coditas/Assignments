package com.practise.relationmapping.controller;

import com.practise.relationmapping.dto.DoctorRequestDto;
import com.practise.relationmapping.entity.Doctor;
import com.practise.relationmapping.service.DoctorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    private final DoctorService doctorService;


    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping("/register")
    public String doctorRegister(@RequestBody DoctorRequestDto dto){
        return doctorService.doctorRegister(dto);
    }

//    Get all doctors
    @GetMapping("/all")
    public List<Doctor>  getAllDoctors(){
        return doctorService.getAllDoctors();
    }


//    Get a specific doctor with their linked patients
    @GetMapping("getById/{id}")
    public Doctor getDoctorById(@PathVariable Long id){
        return doctorService.getDoctorById(id);
    }


//    DELETE Remove a doctor
    @DeleteMapping("{id}")
    public String deleteDoctorById(@PathVariable Long id){
        return doctorService.deleteDoctorById(id);
    }



}
