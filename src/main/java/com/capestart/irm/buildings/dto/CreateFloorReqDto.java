package com.capestart.irm.buildings.dto;

import lombok.Data;

@Data
public class CreateFloorReqDto {
    private int buildingId;
    private String floorName;
    private int maxRows;
    private int maxColumns;
}
