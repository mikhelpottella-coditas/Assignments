package com.practise.relationmapping.service;

import com.practise.relationmapping.dao.DoctorDao;
import com.practise.relationmapping.dao.PatientDao;
import com.practise.relationmapping.dao.PrescriptionDao;
import com.practise.relationmapping.dto.PrescriptionRequestDto;
import com.practise.relationmapping.entity.Patient;
import com.practise.relationmapping.entity.Prescription;
import com.practise.relationmapping.exception.CustomException;
import org.springframework.http.HttpStatus;

public class PrescriptionService {

    PatientDao patientDao;
    DoctorDao doctorDao;
    PrescriptionDao prescriptionDao;


    public PrescriptionService(PatientDao patientDao, DoctorDao doctorDao, PrescriptionDao prescriptionDao) {
        this.patientDao = patientDao;
        this.doctorDao = doctorDao;
        this.prescriptionDao = prescriptionDao;
    }

    public void registerPrescription(PrescriptionRequestDto dto) {

        Patient patient = patientDao.findById(dto.patientId()).orElseThrow(()-> new CustomException(HttpStatus.NOT_FOUND,"patient not found"));


    }
}
