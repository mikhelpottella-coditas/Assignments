package com.practise.relationmapping.service;

import com.practise.relationmapping.dao.DoctorDao;
import com.practise.relationmapping.dao.MedicineDao;
import com.practise.relationmapping.dao.PatientDao;
import com.practise.relationmapping.dao.PrescriptionDao;
import com.practise.relationmapping.dto.DoctorResponceDto;
import com.practise.relationmapping.dto.FullDetailPrescriptionResponseDto;
import com.practise.relationmapping.dto.MedicineResponseDto;
import com.practise.relationmapping.dto.PrescriptionRequestDto;
import com.practise.relationmapping.entity.Doctor;
import com.practise.relationmapping.entity.Medicine;
import com.practise.relationmapping.entity.Patient;
import com.practise.relationmapping.entity.Prescription;
import com.practise.relationmapping.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PrescriptionService {

    PatientService patientService;
    PatientDao patientDao;
    DoctorService doctorService;
    DoctorDao doctorDao;
    MedicineService medicineService;
    MedicineDao medicineDao;
    PrescriptionDao prescriptionDao;

    public PrescriptionService(PatientService patientService, PatientDao patientDao, DoctorService doctorService, DoctorDao doctorDao, MedicineService medicineService, MedicineDao medicineDao, PrescriptionDao prescriptionDao) {
        this.patientService = patientService;
        this.patientDao = patientDao;
        this.doctorService = doctorService;
        this.doctorDao = doctorDao;
        this.medicineService = medicineService;
        this.medicineDao = medicineDao;
        this.prescriptionDao = prescriptionDao;
    }

    public void registerPrescription(PrescriptionRequestDto dto) {

        Patient patient = patientDao.findById(dto.patientId()).get();
        Doctor doctor = doctorDao.findById(dto.doctorId()).get();

        List<Medicine> medicineList = new ArrayList<>();
        dto.medicineIds().forEach(medicineId -> {
            medicineList.add(medicineDao.findById(medicineId).orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "medicine not found with the given Id")));
        });

        Prescription prescription = new Prescription();
        prescription.setPatient(patient);
        prescription.setDoctor(doctor);
        prescription.setMedicines(medicineList);

        prescriptionDao.save(prescription);
    }

    public FullDetailPrescriptionResponseDto fullDetailsById(Long id) {

        Prescription prescription = prescriptionDao.findById(id).orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "prescription not found with the given ID"));

        String patientName = prescription.getPatient().getName();
        String doctorName = prescription.getDoctor().getName();
        List<MedicineResponseDto> medicineDto = new ArrayList<>();
        List<Medicine> medicineList = prescription.getMedicines();
        medicineList.forEach(medicine -> {
            medicineDto.add(new MedicineResponseDto(medicine.getId(), medicine.getName(), medicine.getPrice(), medicine.getStock()));
        });

        FullDetailPrescriptionResponseDto dto = new FullDetailPrescriptionResponseDto(prescription.getId(), patientName, doctorName, medicineDto);

        return dto;

    }

    // get all prescriptions
    public List<FullDetailPrescriptionResponseDto> getAll() {
        List<Prescription> prescriptions = prescriptionDao.findAll();
        List<FullDetailPrescriptionResponseDto> dto = new ArrayList<>();

        prescriptions.forEach(prescription -> {
            String patientName = prescription.getPatient().getName();
            String doctorName = prescription.getDoctor().getName();
            List<MedicineResponseDto> medicineDto = new ArrayList<>();
            List<Medicine> medicineList = prescription.getMedicines();
            medicineList.forEach(medicine -> {
                medicineDto.add(new MedicineResponseDto(medicine.getId(), medicine.getName(), medicine.getPrice(), medicine.getStock()));
            });
            dto.add(new FullDetailPrescriptionResponseDto(prescription.getId(), patientName, doctorName, medicineDto));
        });
        return dto;
    }

//    prescriptions of a particular patient
//    public List<FullDetailPrescriptionResponseDto> presc



    //    DELETE Cancel a prescription
    public void deleteById(Long id) {
        Prescription prescription = prescriptionDao.findById(id).orElseThrow(()-> new CustomException(HttpStatus.NOT_FOUND,"prescription not found wiht the given Id"));
        prescriptionDao.delete(prescription);
    }
}
