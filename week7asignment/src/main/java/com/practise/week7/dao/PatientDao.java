package com.practise.week7.dao;

import com.practise.week7.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientDao extends JpaRepository<Patient,Long> {
    // Query by blood group stored in MedicalHistory
    List<Patient> findByMedicalHistory_BloodGrp(String bloodGrp);
}
