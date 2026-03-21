package com.practise.week7.controller;

import com.practise.week7.dao.MedicalHistoryDao;
import com.practise.week7.dao.PatientDao;
import com.practise.week7.dto.MedicalRequest;
import com.practise.week7.dto.PatientResponseDto;
import com.practise.week7.entity.MedicalHistory;
import com.practise.week7.entity.Patient;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.parser.Part;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class PatientController {

    @Autowired
    PatientDao patientDao;

    @Autowired
    MedicalHistoryDao medicalHistoryDao;


    // . Register a New Patient

    @PostMapping("/register")
    public void register(@RequestBody Patient patient){
        patientDao.save(patient);
    }
    //View All Patients

    @GetMapping("/getall")
    public List<Patient> getAll(){
        return patientDao.findAll(Sort.by("name"));
    }


//    View Patient Details by ID
    @GetMapping("/getPatientById/{id}")
    public PatientResponseDto getPatientById(@PathVariable Long id){
        Patient patient =  patientDao.findById(id).orElseThrow(()->new RuntimeException("hello"));
        PatientResponseDto patientResponseDto = new PatientResponseDto(patient.getPatientID(),patient.getName(),patient.getAge(), patient.getGender(), patient.getMobileNumber());
        return patientResponseDto;

    }

    // View Medical History of a Patient
    @GetMapping("/getPatientById&MedicalHistory/{id}")
    public Patient getPatientByIdAndMedicalHistory(@PathVariable Long id){
        return patientDao.findById(id).orElseThrow(()->new RuntimeException("hello"));
    }


    // Update Patient Details
    @PatchMapping("/updatePatientById/{id}")
    @Transactional
    public String updatePatientById(@PathVariable Long id, @RequestBody PatientResponseDto patientResponseDto){
        Patient patient = patientDao.findById(id).orElseThrow(()->new RuntimeException("hello"));
        if(patientResponseDto.name()!=null)patient.setName(patientResponseDto.name());
        if(patientResponseDto.age()!=null)patient.setAge(patientResponseDto.age());
        if(patientResponseDto.gender()!=null)patient.setGender(patientResponseDto.gender());
        if(patientResponseDto.mobileNumber()!=null)patient.setMobileNumber(patientResponseDto.mobileNumber());
        return "done with update";
    }


//    Update Medical History
    @PatchMapping("/updateMadicalDataWithPatientId/{id}")
    @Transactional
    public String updatePatientDataWithPatientById(@PathVariable Long id, @RequestBody MedicalRequest medicalRequest){
        Patient patient = patientDao.findById(id).orElseThrow(()->new RuntimeException("hello"));

        MedicalHistory medicalHistory = patient.getMedicalHistory();

        if (medicalHistory == null) {
            medicalHistory = new MedicalHistory();
            patient.setMedicalHistory(medicalHistory);
        }


        if(medicalRequest.currentMedication()!=null) medicalHistory.setCurrentMedication(medicalRequest.currentMedication());
        if(medicalRequest.allergies()!=null) medicalHistory.setAllergies(medicalRequest.allergies());
        if(medicalRequest.bloodGrp()!=null) medicalHistory.setBloodGrp(medicalRequest.bloodGrp());
        if(medicalRequest.PastDiseases()!=null) medicalHistory.setPastDiseases(medicalRequest.PastDiseases());

        patientDao.save(patient);

        return "done with update";

    }




//     Delete a Patient
    @DeleteMapping("/deletePatientById/{id}")
    public String deletePatientById(@PathVariable Long id){
        Patient patient = patientDao.findById(id).orElseThrow(()->new RuntimeException("hello"));
        if(patient!=null) patientDao.deleteById(id);

        return "delete success";
    }

//    View All Medical Histories
//    Add Medical History to an Existing Patient
    @GetMapping("/allMediacalHistory")
    public List<MedicalRequest> getAllMedicalHistory(){
        List<MedicalHistory> medicalHistoryList = medicalHistoryDao.findAll();
        List<MedicalRequest> medicalRequestList = new ArrayList<>();
        medicalHistoryList.forEach((e)-> medicalRequestList.add(new MedicalRequest(e.getMedicalHistoryId(),e.getBloodGrp(),e.getCurrentMedication(),e.getPastDiseases(),e.getCurrentMedication())) );
        return medicalRequestList;
    }

//7. Delete a Patient

    @DeleteMapping("/deletePatient/{id}")
    public String deletePatient(@PathVariable Long id){
        Patient patient = patientDao.findById(id).orElseThrow(()->new RuntimeException("not found"));
        patientDao.deleteById(id);
        return "delete success";
    }

//10. Find Patients by Blood Group
    @GetMapping("/patients/by-blood-group/{bloodGrp}")
    public List<Patient> getPatientsByBloodGroup(@PathVariable String bloodGrp) {
        return patientDao.findByMedicalHistory_BloodGrp(bloodGrp);
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
