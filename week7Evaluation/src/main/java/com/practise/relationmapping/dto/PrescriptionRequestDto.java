package com.practise.relationmapping.dto;

import java.util.List;

public record PrescriptionRequestDto(Long patientId, Long doctorId, List<Long> medicineIds) {
}
