package com.practise.week7.controller;

import com.practise.week7.dao.MedicalHistoryDao;
import com.practise.week7.dao.PatientDao;
import com.practise.week7.entity.MedicalHistory;
import com.practise.week7.entity.Patient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/MedicalHistory")
public class MedicalHistoryController {

    MedicalHistoryDao medicalHistoryDao;
    PatientDao patientDao;

    public MedicalHistoryController(MedicalHistoryDao medicalHistoryDao, PatientDao patientDao) {
        this.medicalHistoryDao = medicalHistoryDao;
        this.patientDao = patientDao;
    }

//    8. View All Medical Histories
    @GetMapping("/all")
    public List<MedicalHistory> getAllMedicalHistory(){
        return medicalHistoryDao.findAll();
    }





}
