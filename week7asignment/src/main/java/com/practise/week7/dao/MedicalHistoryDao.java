package com.practise.week7.dao;

import com.practise.week7.entity.MedicalHistory;
import com.practise.week7.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicalHistoryDao extends JpaRepository<MedicalHistory, Long> {


}
