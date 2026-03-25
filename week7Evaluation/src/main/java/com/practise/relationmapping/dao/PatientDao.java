package com.practise.relationmapping.dao;

import com.practise.relationmapping.entity.Patient;
import com.practise.relationmapping.entity.PatientType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientDao extends JpaRepository<Patient,Long> {


    List<Patient> findByPatientType(PatientType patientType);
}
