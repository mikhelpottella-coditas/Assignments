package com.practise.relationmapping.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
public class DoctorResponceDto {
    Long  id;
    String name;
    List<String> patientNames;
    List<Long> prescriptions;
}
