package com.practise.relationmapping.controller;

import com.practise.relationmapping.dto.DoctorRequestDto;
import com.practise.relationmapping.service.DoctorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
