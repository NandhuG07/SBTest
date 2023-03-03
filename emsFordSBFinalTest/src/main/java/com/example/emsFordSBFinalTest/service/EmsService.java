package com.example.emsFordSBFinalTest.service;

import com.example.emsFordSBFinalTest.dto.EmsRequestDTO;
import com.example.emsFordSBFinalTest.dto.EmsResponseDTO;
import com.example.emsFordSBFinalTest.model.Ems;

import java.util.List;

public interface EmsService {
    List<EmsResponseDTO> getAllEmployees();

    EmsResponseDTO addEmployee(EmsRequestDTO bookRequestDTO);

    EmsResponseDTO getEmployee(long empId);

    EmsResponseDTO updateEmployee(long empId, EmsRequestDTO emsRequestDTO);

    EmsResponseDTO deleteEmployeeById(long empId);
}
