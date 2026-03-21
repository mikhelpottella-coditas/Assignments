package com.practise.week7.dto;

public record MedicalRequest(Long medicalHistoryId,String bloodGrp, String allergies,String PastDiseases, String currentMedication) {
}
