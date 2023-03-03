package com.example.emsFordSBFinalTest.service;

import com.example.emsFordSBFinalTest.dto.EmsRequestDTO;
import com.example.emsFordSBFinalTest.dto.EmsResponseDTO;
import com.example.emsFordSBFinalTest.exception.EmsNotFoundException;
import com.example.emsFordSBFinalTest.model.Ems;
import com.example.emsFordSBFinalTest.repo.EmsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmsServiceImpl implements EmsService{
    @Autowired
    private EmsRepo emsRepo;
    @Override
    public List<EmsResponseDTO> getAllEmployees() {
        List<Ems> empList = emsRepo.findAll();
        List<EmsResponseDTO> emsResponseDTOList = new ArrayList<EmsResponseDTO>();
        emsResponseDTOList =  empList.stream().map((ems)->{
            EmsResponseDTO emsResponseDTO = new EmsResponseDTO();
            emsResponseDTO.setEmpId(ems.getEmpId());
            emsResponseDTO.setFirstName(ems.getFirstName());
            emsResponseDTO.setLastName(ems.getLastName());
            emsResponseDTO.setDepartment(ems.getDepartment());
            emsResponseDTO.setDesignation(ems.getDesignation());
            emsResponseDTO.setSalary(ems.getSalary());
            return emsResponseDTO;
        }).collect(Collectors.toList());
        return emsResponseDTOList;
    }

    @Override
    public EmsResponseDTO addEmployee(EmsRequestDTO emsRequestDTO) {
        Ems ems = new Ems();
        ems.setFirstName(emsRequestDTO.getFirstName());
        ems.setLastName(emsRequestDTO.getLastName());
        ems.setDepartment(emsRequestDTO.getDepartment());
        ems.setDesignation(emsRequestDTO.getDesignation());
        ems.setSalary(emsRequestDTO.getSalary());
        Ems savedEms =  emsRepo.save(ems);
        EmsResponseDTO emsResponseDTO = new EmsResponseDTO();
        emsResponseDTO.setFirstName(savedEms.getFirstName());
        emsResponseDTO.setLastName(savedEms.getLastName());
        emsResponseDTO.setDepartment(savedEms.getDepartment());
        emsResponseDTO.setDesignation(savedEms.getDesignation());
        emsResponseDTO.setSalary(savedEms.getSalary());
        return emsResponseDTO;
    }

    @Override
    public EmsResponseDTO getEmployee(long empId) {
        Optional<Ems> emsOptional = emsRepo.findById(empId);

        if(emsOptional.isPresent()){
            Ems searchedEmp =  emsOptional.get();
            EmsResponseDTO emsResponseDTO = new EmsResponseDTO();
            emsResponseDTO.setFirstName(searchedEmp.getFirstName());
            emsResponseDTO.setLastName(searchedEmp.getLastName());
            emsResponseDTO.setDepartment(searchedEmp.getDepartment());
            emsResponseDTO.setDesignation(searchedEmp.getDesignation());
            emsResponseDTO.setSalary(searchedEmp.getSalary());
            return emsResponseDTO;
        }else{
            throw new EmsNotFoundException("Employee ID : "+empId + " is not present.");
        }
    }

    @Override
    public EmsResponseDTO updateEmployee(long empId, EmsRequestDTO EmsRequestDTO) {
        Optional<Ems> emsOptional = emsRepo.findById(empId);
        if(emsOptional.isPresent()){

            Ems searchedEmp =  emsOptional.get();
            searchedEmp.setFirstName(EmsRequestDTO.getFirstName());
            searchedEmp.setLastName(EmsRequestDTO.getLastName());
            searchedEmp.setDepartment(EmsRequestDTO.getDepartment());
            searchedEmp.setDesignation(EmsRequestDTO.getDesignation());
            searchedEmp.setSalary(EmsRequestDTO.getSalary());
            emsRepo.flush();
            EmsResponseDTO emsResponseDTO = new EmsResponseDTO();
            emsResponseDTO.setFirstName(searchedEmp.getFirstName());
            emsResponseDTO.setLastName(searchedEmp.getLastName());
            emsResponseDTO.setDepartment(searchedEmp.getDepartment());
            emsResponseDTO.setDesignation(searchedEmp.getDesignation());
            emsResponseDTO.setSalary(searchedEmp.getSalary());
            return emsResponseDTO;
        }else{

            Ems newEms = new Ems();
            newEms.setFirstName(EmsRequestDTO.getFirstName());
            newEms.setLastName(EmsRequestDTO.getLastName());
            newEms.setDepartment(EmsRequestDTO.getDepartment());
            newEms.setDesignation(EmsRequestDTO.getDesignation());
            newEms.setSalary(EmsRequestDTO.getSalary());
            Ems savedEms = emsRepo.save(newEms);
            EmsResponseDTO emsResponseDTO = new EmsResponseDTO();
            emsResponseDTO.setFirstName(savedEms.getFirstName());
            emsResponseDTO.setLastName(savedEms.getLastName());
            emsResponseDTO.setDepartment(savedEms.getDepartment());
            emsResponseDTO.setDesignation(savedEms.getDesignation());
            emsResponseDTO.setSalary(savedEms.getSalary());
            return emsResponseDTO;
        }

    }

    @Override
    public EmsResponseDTO deleteEmployeeById(long empId) {
        Optional<Ems> emsOptional = emsRepo.findById(empId);
        if(emsOptional.isPresent()){
            Ems deletedEms = emsOptional.get();
            emsRepo.delete(deletedEms);
            EmsResponseDTO emsResponseDTO = new EmsResponseDTO(deletedEms);
            return emsResponseDTO;
        }else{
            throw new EmsNotFoundException("Employee ID : "+empId+ " not available in DB");
        }

    }
}
