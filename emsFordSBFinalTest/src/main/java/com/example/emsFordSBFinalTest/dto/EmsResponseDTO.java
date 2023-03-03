package com.example.emsFordSBFinalTest.dto;

import com.example.emsFordSBFinalTest.model.Ems;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class EmsResponseDTO {
    private long empId;
    private String firstName;
    private String lastName;
    private String department;
    private String designation;
    private  double salary;

    public EmsResponseDTO(Ems ems) {
        this.setEmpId(ems.getEmpId());
        this.setFirstName(ems.getFirstName());
        this.setLastName(ems.getLastName());
        this.setDepartment(ems.getDepartment());
        this.setDesignation(ems.getDesignation());
        this.setSalary(ems.getSalary());
    }
}