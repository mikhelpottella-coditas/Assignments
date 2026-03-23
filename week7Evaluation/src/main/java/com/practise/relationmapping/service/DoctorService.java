package com.practise.relationmapping.service;

import com.practise.relationmapping.dao.DoctorDao;
import com.practise.relationmapping.dto.DoctorRequestDto;
import com.practise.relationmapping.dto.DoctorResponceDto;
import com.practise.relationmapping.entity.Doctor;
import com.practise.relationmapping.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
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

    public List<DoctorResponceDto> getAllDoctors() {
        List<Doctor> doctorList = doctorDao.findAll();
        List<DoctorResponceDto> dtoList = new ArrayList<>();
        doctorList.forEach(doctor -> {
            List<String> patientNames = doctor.getPatients().stream().map(p->p.getName()).toList();
            List<Long> prescriptions = doctor.getPrescriptions().stream().map(p->p.getId()).toList();
            DoctorResponceDto dto = new DoctorResponceDto(doctor.getId(),doctor.getName(),patientNames,prescriptions);
        });

        return  dtoList;
    }

    public DoctorResponceDto getDoctorById(Long id) {
        Doctor doctor = doctorDao.findById(id).orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "doctor not found with the given id"));

        List<String> patientNames = doctor.getPatients().stream().map(p->p.getName()).toList();
        List<Long> prescription = doctor.getPrescriptions().stream().map(p->p.getId()).toList();
        DoctorResponceDto dto =  new DoctorResponceDto(doctor.getId(),doctor.getName(),patientNames,prescription);

        return dto;
    }

    public String deleteDoctorById(Long id) {
        Doctor doctor = doctorDao.findById(id).orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "doctor not found with the given id"));
        doctorDao.delete(doctor);
        return "Doctor deleted successfully";
    }
}
