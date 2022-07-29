package com.capestart.irm.employees.service;

import com.capestart.irm.common.dto.ResponseDto;
import com.capestart.irm.common.exceptions.IrmException;
import com.capestart.irm.employees.dao.EmployeeDao;
import com.capestart.irm.employees.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    public ResponseDto getEmployeeProfile(int employeeCode){
       try{
           Employee employee = employeeDao.getEmployeeProfileById(employeeCode);
           return new ResponseDto(HttpStatus.OK.value(), employee);
       }catch (Exception e){
           return IrmException.sendErrorResponse(e);
       }
    }
}
