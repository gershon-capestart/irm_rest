package com.capestart.irm.buildings.controllers;

import com.capestart.irm.buildings.dto.CreateBuildingReqDto;
import com.capestart.irm.buildings.service.BuildingManagementService;
import com.capestart.irm.common.dto.ResponseDto;
import com.capestart.irm.common.utils.IrmResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BuildingManagementController {

    @Autowired
    private BuildingManagementService buildingManagementService;

    @PostMapping("/admin/building")
    public ResponseEntity<ResponseDto> createNewBuilding(@RequestBody CreateBuildingReqDto dto) {
        ResponseDto response = buildingManagementService.createNewBuilding(dto);
        return IrmResponse.generateResponse(response);
    }

    @GetMapping("/buildings")
    public ResponseEntity<ResponseDto> getAllBuildings(){
        ResponseDto buildings = buildingManagementService.getAllBuildings();
        return IrmResponse.generateResponse(buildings);
    }

}
