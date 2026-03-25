package com.practise.relationmapping.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class InPatient extends Patient{

    private int numberOfDaysAdmitted;
    private double dailyCharge;

    @Override
    public double calculateBill() {
        return numberOfDaysAdmitted * dailyCharge;
    }

    public InPatient(int numberOfDaysAdmitted, double dailyCharge) {
        this.numberOfDaysAdmitted = numberOfDaysAdmitted;
        this.dailyCharge = dailyCharge;
    }

    public InPatient() {
    }
}
