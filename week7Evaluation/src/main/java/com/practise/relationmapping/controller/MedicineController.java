package com.practise.relationmapping.controller;


import com.practise.relationmapping.dto.MedicineResponseDto;
import com.practise.relationmapping.entity.Medicine;
import com.practise.relationmapping.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicine")
public class MedicineController {

    @Autowired
    MedicineService medicineService;


//    register medicine
    @PostMapping("/add")
    public Medicine add(@RequestBody Medicine medicine){
        return medicineService.add(medicine);
    }


//    Get all medicines
    @GetMapping("/all")
    public List<MedicineResponseDto> getAll(){
        return medicineService.getAll();
    }


// Get a specific medicine
    @GetMapping("/{id}")
    public MedicineResponseDto getById(@PathVariable Long id){
        return medicineService.getById(id);
    }

// Reduce stock by given units
    @PatchMapping("/updateQuantity/{id}")
    public void updateQuantity(@RequestBody Integer quantity, @PathVariable Long id){
        medicineService.updateQuantity(quantity,id);
    }

//    Get all medicines where stock is below a given number
    @GetMapping("/quantitylessThan/{size}")
    public List<MedicineResponseDto> getQuantityLesserThan(@PathVariable Integer size){
        return medicineService.getQuantityLesserThan(size);
    }


}


