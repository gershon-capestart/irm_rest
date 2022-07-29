package com.capestart.irm.buildings.pojo;

import lombok.Builder;
import lombok.Data;

import static com.capestart.irm.common.utils.QueryUtils.convertObjToInteger;
import static com.capestart.irm.common.utils.QueryUtils.convertObjToString;

@Data
@Builder
public class Floor {
    private int floorId;
    private String floorName;
    private int buildingId;
    private int maxRow;
    private int maxColumn;

    public static Floor convertObjToFloor(Object[] row) {
        return Floor.builder()
                .floorId(convertObjToInteger(row[0]))
                .floorName(convertObjToString(row[1]))
                .buildingId(convertObjToInteger(row[2]))
                .maxRow(convertObjToInteger(row[3]))
                .maxColumn(convertObjToInteger(row[4]))
                .build();
    }

}
