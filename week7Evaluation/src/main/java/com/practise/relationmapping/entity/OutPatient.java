package com.practise.relationmapping.entity;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OutPatient extends Patient {

    private double consultationFee;
    private int numberOfVisits;

    @Override
    public double calculateBill() {
        return consultationFee * numberOfVisits;
    }


    public OutPatient(double consultationFee, int numberOfVisits) {
        this.consultationFee = consultationFee;
        this.numberOfVisits = numberOfVisits;
    }

    public OutPatient() {
    }
}
