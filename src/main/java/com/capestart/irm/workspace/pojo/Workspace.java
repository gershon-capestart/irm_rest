package com.capestart.irm.workspace.pojo;

import com.capestart.irm.common.utils.QueryUtils;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Workspace {
    private int workspaceId;
    private int employeeId;
    private String employeeName;
    private String floorName;
    private String buildingName;
    private String bookedDate;
    private String shift;
    private int bookedRow;
    private int bookedColumn;
    private int floorId;
    private String dinner;
    private String snacks;

    public static Workspace convertObjToWorkspace(Object[] row) {
        return Workspace.builder()
                .workspaceId(QueryUtils.convertObjToInteger(row[0]))
                .employeeId(QueryUtils.convertObjToInteger(row[1]))
                .employeeName(QueryUtils.convertObjToString(row[2]))
                .floorName(QueryUtils.convertObjToString(row[3]))
                .buildingName(QueryUtils.convertObjToString(row[4]))
                .bookedDate(QueryUtils.convertObjToString(row[5]))
                .shift(QueryUtils.convertObjToString(row[6]))
                .bookedRow(QueryUtils.convertObjToInteger(row[7]))
                .bookedColumn(QueryUtils.convertObjToInteger(row[8]))
                .floorId(QueryUtils.convertObjToInteger(row[9]))
                .dinner(QueryUtils.convertObjToString(row[10]))
                .snacks(QueryUtils.convertObjToString(row[11]))
                .build();
    }

}
