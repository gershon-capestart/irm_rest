package com.capestart.irm.workspace.controller;

import com.capestart.irm.common.dto.ResponseDto;
import com.capestart.irm.common.utils.IrmResponse;
import com.capestart.irm.workspace.dto.BookWorkspaceReqDto;
import com.capestart.irm.workspace.dto.ListWorkspaceDto;
import com.capestart.irm.workspace.service.WorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class WorkspaceController {

    @Autowired
    private WorkspaceService workspaceService;

    @PostMapping("/workspace")
    public ResponseEntity<ResponseDto> bookWorkspace(@RequestBody BookWorkspaceReqDto dto){
        ResponseDto response = workspaceService.createWorkspace(dto);
        return IrmResponse.generateResponse(response);
    }

    @GetMapping("/admin/workspaces")
    public ResponseEntity<ResponseDto> getAllWorkspaces(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "empCode", required = false) String empCode,
            @RequestParam(value = "shift", required = false) String shift,
            @RequestParam(value = "floor", required = false) String floor,
            @RequestParam(value = "building", required = false) String building,
            @RequestParam(value = "date", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date date
    ){
        ListWorkspaceDto dto = ListWorkspaceDto.builder()
                .employeeName(name)
                .shift(shift)
                .floor(floor)
                .building(building)
                .date(date)
                .empCode(empCode)
                .build();
        ResponseDto workspaces = workspaceService.getAllWorkspaces(dto);
        return IrmResponse.generateResponse(workspaces);
    }

}
