package com.capestart.irm.workspace.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class ListWorkspaceDto {
   private String employeeName;
   private String empCode;
   private String shift;
   private String floor;
   private String building;
   private Date date;
}
