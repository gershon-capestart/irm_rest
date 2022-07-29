package com.capestart.irm.buildings.pojo;

import lombok.Builder;
import lombok.Data;

import static com.capestart.irm.common.utils.QueryUtils.convertObjToInteger;
import static com.capestart.irm.common.utils.QueryUtils.convertObjToString;

@Data
@Builder
public class Building {
    private int buildingId;
    private String buildingName;

    public static Building convertObjToBuilding(Object[] row) {
        return Building.builder()
                .buildingId(convertObjToInteger(row[0]))
                .buildingName(convertObjToString(row[1]))
                .build();
    }
}
