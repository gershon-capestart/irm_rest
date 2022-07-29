package com.capestart.irm.vehicles.dto;

import lombok.Data;

@Data
public class EmployeeVehicleCreateDto {
    private String vehicleName;
    private String vehicleTag;
    private String status;
    private int empCode;
}
