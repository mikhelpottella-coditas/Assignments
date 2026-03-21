package com.practise.relationmapping.service;

import com.practise.relationmapping.dao.DoctorDao;
import com.practise.relationmapping.dao.PatientDao;
import com.practise.relationmapping.dto.PatientRequestDto;
import com.practise.relationmapping.dto.PatientResponseDto;
import com.practise.relationmapping.entity.*;
import com.practise.relationmapping.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {


    private final PatientDao patientDao;
    private final DoctorDao doctorDao;

    public PatientService(PatientDao patientDao, DoctorDao doctorDao) {
        this.patientDao = patientDao;
        this.doctorDao = doctorDao;
    }

    public String registerPatient(PatientRequestDto patientRequestDto) {

        // lets check if the doctor is there or not
        Doctor doctor = doctorDao.findById(patientRequestDto.doctorId()).orElseThrow(()->new CustomException(HttpStatus.NOT_FOUND,"doctor ID not found to register the patient"));

        Patient patient;

        if(patientRequestDto.patientType()== PatientType.INPATIENT){
            InPatient inPatient = new InPatient();
            inPatient.setName(patientRequestDto.name());
            inPatient.setPatientType(patientRequestDto.patientType());
            inPatient.setDoctor(doctor);
            inPatient.setNumberOfDaysAdmitted(patientRequestDto.numberOfDaysAdmitted());
            inPatient.calculateBill();

            patient = inPatient;
        }
        else{

            OutPatient outPatient = new OutPatient();
            outPatient.setName(patientRequestDto.name());
            outPatient.setDoctor(doctor);
            outPatient.setConsultationFee(patientRequestDto.consultationFee());
            outPatient.setNumberOfVisits(patientRequestDto.numberOfVisits());

            patient = outPatient;

        }

        patientDao.save(patient);
        return "patient registration successful";
    }


    public List<PatientResponseDto> getAllpatients() {
        List<Patient> patientList = patientDao.findAll();
        List<PatientResponseDto> patientResponseDtoList = new ArrayList<>();


        patientList.forEach(e->{
            patientResponseDtoList.add(new PatientResponseDto(e.getId(),e.getName(),e.getPatientType(),e.calculateBill()));
        });

        return patientResponseDtoList;


    }

    public Patient getById(Long id) {
        Patient patient = patientDao.findById(id).orElseThrow(()-> new CustomException(HttpStatus.NOT_FOUND,"patient not found with the given Id"));
        return patient;
    }


    public String getBillById(Long id) {
        Patient patient = patientDao.findById(id).orElseThrow(()-> new CustomException(HttpStatus.NOT_FOUND,"patient not found with the given Id"));
       Double bill = patient.calculateBill();
       return "ID: "+patient.getId()+"   name:"+patient.getName()+"   bill:"+bill;
    }


    public List<Patient> getAllPatientByType(PatientType patientType) {
        List<Patient> patients = patientDao.findByPatientType(patientType);
        return patients;

    }
}
