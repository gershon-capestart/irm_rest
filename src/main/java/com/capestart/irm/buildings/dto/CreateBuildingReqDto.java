package com.capestart.irm.buildings.dto;

import lombok.Data;

@Data
public class CreateBuildingReqDto {
    private String buildingName;
    private boolean isActive;
}
