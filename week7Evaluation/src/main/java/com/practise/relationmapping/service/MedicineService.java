package com.practise.relationmapping.service;

import com.practise.relationmapping.dao.MedicineDao;
import com.practise.relationmapping.dto.MedicineResponseDto;
import com.practise.relationmapping.entity.Medicine;
import com.practise.relationmapping.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicineService {

    @Autowired
    private MedicineDao medicineDao;

    public Medicine add(Medicine medicine) {
        medicineDao.save(medicine);
        return medicine;
    }

    public List<MedicineResponseDto> getAll() {
        List<MedicineResponseDto> medicineResponseDtos = new ArrayList<>();
        List<Medicine> medicines = medicineDao.findAll();

        medicines.forEach(medicine -> {
            medicineResponseDtos.add(new MedicineResponseDto(medicine.getId(),medicine.getName(),medicine.getPrice(),medicine.getStock()));

        });
        return medicineResponseDtos;
    }


    public MedicineResponseDto getById(Long id) {

        Medicine medicine = medicineDao.findById(id).orElseThrow(()-> new CustomException(HttpStatus.NOT_FOUND,"medicine not found with the given id"));

        MedicineResponseDto medicineResponseDto = new MedicineResponseDto(medicine.getId(),medicine.getName(),medicine.getPrice(),medicine.getStock());

        return medicineResponseDto;

    }

    public void updateQuantity(Integer quantity, Long id) {

        Medicine medicine = medicineDao.findById(id).orElseThrow(()-> new CustomException(HttpStatus.NOT_FOUND,"medicine not found with the given id"));

        medicine.setStock(quantity);

        medicineDao.save(medicine);


    }

    public List<MedicineResponseDto> getQuantityLesserThan(Integer size) {
        List<Medicine> medicineList = medicineDao.findByStockLessThan(size);

        List<MedicineResponseDto> medicineResponseDtos = new ArrayList<>();

        medicineList.forEach(medicine -> {
            medicineResponseDtos.add(new MedicineResponseDto(medicine.getId(),medicine.getName(),medicine.getPrice(),medicine.getStock()));

        });

        return medicineResponseDtos;
    }
}
