package com.capestart.irm.vehicles.service;

import com.capestart.irm.common.dto.ResponseDto;
import com.capestart.irm.common.exceptions.IrmException;
import com.capestart.irm.vehicles.dao.VehicleDao;
import com.capestart.irm.vehicles.dto.EmployeeVehicleCreateDto;
import com.capestart.irm.vehicles.pojo.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    VehicleDao vehicleDao;

    public ResponseDto createVehicle(EmployeeVehicleCreateDto dto) {
        try {
            vehicleDao.createVehicle(dto);
            return new ResponseDto(HttpStatus.OK.value(), dto);
        } catch (Exception e) {
            return IrmException.sendErrorResponse(e);
        }
    }

    public ResponseDto updateVehicleStatus(String tag) {
        try {
            Vehicle vehicle = vehicleDao.getVehicleByTag(tag);
            vehicle.flipStatus();
            vehicleDao.updateVehicleStatus(vehicle);
            return new ResponseDto(HttpStatus.OK.value(), vehicle);
        } catch (Exception e) {
            return IrmException.sendErrorResponse(e);
        }

    }

    public ResponseDto getAllVehicles(String searchKey) {
        try{
           List<Vehicle> vehicles = vehicleDao.getAllVehicles(searchKey);
           return new ResponseDto(HttpStatus.OK.value(), vehicles);
        }catch (Exception e){
            return IrmException.sendErrorResponse(e);
        }
    }
}
