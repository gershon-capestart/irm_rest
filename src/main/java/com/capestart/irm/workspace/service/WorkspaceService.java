package com.capestart.irm.workspace.service;

import com.capestart.irm.common.dto.ResponseDto;
import com.capestart.irm.common.exceptions.IrmException;
import com.capestart.irm.workspace.dao.WorkspaceDao;
import com.capestart.irm.workspace.dto.BookWorkspaceReqDto;
import com.capestart.irm.workspace.dto.ListWorkspaceDto;
import com.capestart.irm.workspace.pojo.Workspace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkspaceService {

    @Autowired
    WorkspaceDao workspaceDao;

    public ResponseDto createWorkspace(BookWorkspaceReqDto dto) {
        workspaceDao.createWorkspace(dto);
        return new ResponseDto(200, dto);
    }

    public ResponseDto getAllWorkspaces(ListWorkspaceDto dto) {
        try {
            List<Workspace> workspaces = workspaceDao.getAll(dto);
            return new ResponseDto(HttpStatus.OK.value(), workspaces);
        } catch (Exception e) {
            return IrmException.sendErrorResponse(e);
        }
    }
}
