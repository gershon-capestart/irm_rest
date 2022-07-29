package com.capestart.irm.vehicles.controller;

import com.capestart.irm.common.dto.ResponseDto;
import com.capestart.irm.common.utils.IrmResponse;
import com.capestart.irm.vehicles.dto.EmployeeVehicleCreateDto;
import com.capestart.irm.vehicles.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @PostMapping("/admin/vehicle")
    public ResponseEntity<ResponseDto> createVehicle(@RequestBody EmployeeVehicleCreateDto dto) {
        ResponseDto vehicle = vehicleService.createVehicle(dto);
        return IrmResponse.generateResponse(vehicle);
    }

    @GetMapping("/admin/vehicles")
    public ResponseEntity<ResponseDto> getAllVehicles(
            @RequestParam(value = "searchKey", required = false) String searchKey
    ) {
        ResponseDto vehicles = vehicleService.getAllVehicles(searchKey);
        return IrmResponse.generateResponse(vehicles);
    }

    @PutMapping("/vehicle/{tag}/status")
    public ResponseEntity<ResponseDto> updateVehicleStatus(@PathVariable("tag") String tag) {
        ResponseDto vehicle = vehicleService.updateVehicleStatus(tag);
        return IrmResponse.generateResponse(vehicle);
    }

}
