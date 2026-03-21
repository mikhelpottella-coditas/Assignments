package com.practise.relationmapping.dao;

import com.practise.relationmapping.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineDao extends JpaRepository<Medicine,Long> {

//    Get all medicines where stock is below a given number
    List<Medicine> findByStockLessThan(Integer stockLesserThan);
}
