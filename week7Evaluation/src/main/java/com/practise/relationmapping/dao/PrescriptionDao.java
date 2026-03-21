package com.practise.relationmapping.dao;

import com.practise.relationmapping.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionDao extends JpaRepository<Prescription,Long> {
}
