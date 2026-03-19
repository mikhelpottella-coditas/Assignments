package com.practise.relationmapping.dto;


import com.practise.relationmapping.entity.PatientType;

public record PatientRequestDto(String name, PatientType patientType,Integer numberOfDaysAdmitted, Double dailyCharge, Double consultationFee, Integer numberOfVisits, Long doctorId) {}
