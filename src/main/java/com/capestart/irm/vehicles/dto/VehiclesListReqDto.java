package com.capestart.irm.vehicles.dto;

import lombok.Data;

@Data
public class VehiclesListReqDto {
    private int employeeCode;
    private String model;
    private String tagName;
    private String status;
}
