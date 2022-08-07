package com.capestart.irm.workspace.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class BookWorkspaceReqDto {
    private int floorId;
    private int employeeId;
    private String shift;
    private int row;
    private int column;
    private boolean dinner;
    private boolean snacks;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date bookingDate;
}
