package com.capestart.irm.buildings.service;

import com.capestart.irm.buildings.dao.BuildingsDao;
import com.capestart.irm.buildings.dto.CreateBuildingReqDto;
import com.capestart.irm.buildings.pojo.Building;
import com.capestart.irm.common.dto.ResponseDto;
import com.capestart.irm.common.exceptions.IrmException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingManagementService {

    @Autowired
    private BuildingsDao buildingsDao;

    public ResponseDto createNewBuilding(CreateBuildingReqDto dto) {
        try {
            buildingsDao.createBuilding(dto);
            return new ResponseDto(200, dto);
        } catch (Exception e) {
            return IrmException.sendErrorResponse(e);
        }
    }

    public ResponseDto getAllBuildings() {
        try {
            List<Building> buildings = buildingsDao.getAllBuildings();
            return new ResponseDto(HttpStatus.OK.value(), buildings);
        } catch (Exception e) {
            return IrmException.sendErrorResponse(e);
        }
    }

}
