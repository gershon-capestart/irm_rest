package com.capestart.irm.vehicles.pojo;

import lombok.Builder;
import lombok.Data;

import static com.capestart.irm.common.utils.QueryUtils.convertObjToInteger;
import static com.capestart.irm.common.utils.QueryUtils.convertObjToString;

@Data
@Builder
public class Vehicle {
    private int vehicleId;
    private String vehicleModel;
    private String tag;
    private int empCode;
    private String status;

    public static Vehicle convertObjToVehicle(Object[] row) {
        return Vehicle.builder()
                .vehicleId(convertObjToInteger(row[0]))
                .vehicleModel(convertObjToString(row[1]))
                .empCode(convertObjToInteger(row[2]))
                .status(convertObjToString(row[3]))
                .tag(convertObjToString(row[4]))
                .build();
    }

    public void flipStatus() {
        if (this.status.equals("IN")) {
            this.setStatus("OUT");
            return;
        }
        this.setStatus("IN");
    }

}
