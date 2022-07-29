package com.capestart.irm.employees.controller;

import com.capestart.irm.common.dto.ResponseDto;
import com.capestart.irm.common.utils.IrmResponse;
import com.capestart.irm.employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/profile")
    public ResponseEntity<ResponseDto> getEmployeeProfile(@RequestParam("empCode") int empCode) {
        ResponseDto employee = employeeService.getEmployeeProfile(empCode);
        return IrmResponse.generateResponse(employee);
    }

}
