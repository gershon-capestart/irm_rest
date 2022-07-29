package com.capestart.irm.buildings.controllers;

import com.capestart.irm.buildings.dto.CreateFloorReqDto;
import com.capestart.irm.buildings.service.FloorManagementService;
import com.capestart.irm.common.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.capestart.irm.common.utils.IrmResponse.generateResponse;

@RestController
public class FloorManagementController {

    @Autowired
    private FloorManagementService floorManagementService;

    @PostMapping("/admin/floor")
    public ResponseEntity<ResponseDto> createFloor(@RequestBody CreateFloorReqDto dto){
        ResponseDto response = floorManagementService.createFloor(dto);
        return generateResponse(response);
    }

    @GetMapping("/building/{buildingId}/floor")
    public ResponseEntity<ResponseDto> getAllFloors(@PathVariable("buildingId") int buildingId){
        ResponseDto buildings = floorManagementService.getAllFloors(buildingId);
        return generateResponse(buildings);
    }

    @GetMapping("/floor/{floorId}")
    public ResponseEntity<ResponseDto> getFloorByFloorId(@PathVariable("floorId") int floorId){
        ResponseDto floor = floorManagementService.getFloorById(floorId);
        return generateResponse(floor);
    }

    @GetMapping("/floor/{floorId}/seats/booked")
    public ResponseEntity<ResponseDto> getBookedFloors(@PathVariable("floorId") int floorId){
        ResponseDto bookedSeats = floorManagementService.getBookedSeatsToday(floorId);
        return generateResponse(bookedSeats);
    }

}
