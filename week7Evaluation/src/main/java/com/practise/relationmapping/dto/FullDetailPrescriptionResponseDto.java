package com.practise.relationmapping.dto;

import com.practise.relationmapping.entity.Doctor;
import com.practise.relationmapping.entity.Medicine;
import com.practise.relationmapping.entity.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FullDetailPrescriptionResponseDto {

    private Long id;
    private String patient;
    private String doctor;
    private List<MedicineResponseDto> medicines;

}
