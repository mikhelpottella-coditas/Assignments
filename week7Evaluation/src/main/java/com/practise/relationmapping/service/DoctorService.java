package com.practise.relationmapping.service;

import com.practise.relationmapping.dao.DoctorDao;
import com.practise.relationmapping.dto.DoctorRequestDto;
import com.practise.relationmapping.entity.Doctor;
import com.practise.relationmapping.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Doctor> getAllDoctors() {
        return doctorDao.findAll();
    }

    public Doctor getDoctorById(Long id) {

        return doctorDao.findById(id).orElseThrow(()-> new CustomException(HttpStatus.NOT_FOUND,"doctor not found with the given id"));

    }

    public String deleteDoctorById(Long id) {

     Doctor doctor = doctorDao.findById(id).orElseThrow(()-> new CustomException(HttpStatus.NOT_FOUND,"doctor not found with the given id"));

     doctorDao.delete(doctor);

     return "Doctor deleted successfully";

    }
}
