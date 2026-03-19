package com.practise.relationmapping.service;

import com.practise.relationmapping.dao.DoctorDao;
import com.practise.relationmapping.dto.DoctorRequestDto;
import com.practise.relationmapping.entity.Doctor;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    DoctorDao doctorDao;

    public DoctorService(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }


    public String doctorRegister(DoctorRequestDto dto) {

        Doctor doctor = new Doctor();
        doctor.setName(dto.name());

        doctorDao.save(doctor);

        return "Doctor registration success";

    }
}
