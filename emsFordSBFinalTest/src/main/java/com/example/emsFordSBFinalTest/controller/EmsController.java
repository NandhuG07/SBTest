package com.example.emsFordSBFinalTest.controller;

import com.example.emsFordSBFinalTest.dto.EmsRequestDTO;
import com.example.emsFordSBFinalTest.dto.EmsResponseDTO;
import com.example.emsFordSBFinalTest.model.Ems;
import com.example.emsFordSBFinalTest.service.EmsService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmsController {
    private static final Log LOGGER = LogFactory.getLog(EmsController.class);
    @Autowired
    private EmsService emsService;
    @GetMapping("/employees")
    public ResponseEntity<List<EmsResponseDTO>> getEmployee(){
        List<EmsResponseDTO> empList=emsService.getAllEmployees();
        if(empList.size()>0){
            return new ResponseEntity<List<EmsResponseDTO>>(empList, HttpStatus.OK);
        }else{
            LOGGER.info("No employees found");
            return new ResponseEntity<List<EmsResponseDTO>>(empList, HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/employees")
    public ResponseEntity<EmsResponseDTO> createEmp(@Valid @RequestBody EmsRequestDTO EmsRequestDTO){
        EmsResponseDTO EmsResponseDTO =  emsService.addEmployee(EmsRequestDTO);
        if(EmsResponseDTO!=null){
            return new ResponseEntity<EmsResponseDTO>(EmsResponseDTO,HttpStatus.CREATED);
        }
        return null;
    }
    @GetMapping("/employees/{empId}")
    public EmsResponseDTO getEmpById(@PathVariable long empId){
        return emsService.getEmployee(empId);
    }
    @PutMapping("/employees/{empId}")
    public EmsResponseDTO updateEmpById(@PathVariable long empId,@RequestBody  EmsRequestDTO EmsRequestDTO){
        return emsService.updateEmployee(empId,EmsRequestDTO);
    }
    @DeleteMapping("/employees/{empId}")
    public EmsResponseDTO deleteEmpById(@PathVariable long empId){
        return emsService.deleteEmployeeById(empId);
    }
}
