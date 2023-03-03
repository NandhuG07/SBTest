package com.example.emsFordSBFinalTest.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmsRequestDTO {
    private String firstName;
    private String lastName;
    private String department;
    private String designation;
    private double salary;
}