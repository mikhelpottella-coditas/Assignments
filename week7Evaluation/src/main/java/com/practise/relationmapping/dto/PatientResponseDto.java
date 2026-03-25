package com.practise.relationmapping.dto;

import com.practise.relationmapping.entity.PatientType;

import java.math.BigDecimal;

public record PatientResponseDto(Long id,
                                 String name,
                                 PatientType patientType,
                                    Double bill
                                 ) {
}
