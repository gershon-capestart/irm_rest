package com.capestart.irm.workspace.dao;

import com.capestart.irm.workspace.dto.BookWorkspaceReqDto;
import com.capestart.irm.workspace.dto.ListWorkspaceDto;
import com.capestart.irm.workspace.pojo.Workspace;
import com.capestart.irm.workspace.queries.WorkspaceQueries;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static com.capestart.irm.common.utils.QueryUtils.getSearchDate;
import static com.capestart.irm.common.utils.QueryUtils.getSearchKey;

@Component
@Transactional
public class WorkspaceDao {
    @PersistenceContext
    EntityManager em;

    public void createWorkspace(BookWorkspaceReqDto dto) {
        em.createNativeQuery(WorkspaceQueries.BOOK_WORKSPACE)
                .setParameter("employeeId", dto.getEmployeeId())
                .setParameter("floorId", dto.getFloorId())
                .setParameter("bookingDate", dto.getBookingDate())
                .setParameter("shift", dto.getShift())
                .setParameter("row", dto.getRow())
                .setParameter("column", dto.getColumn())
                .setParameter("dinner", dto.isDinner())
                .setParameter("snacks", dto.isSnacks())
                .executeUpdate();
    }

    public List<Workspace> getAll(ListWorkspaceDto dto) {
        Query query = em.createNativeQuery(WorkspaceQueries.GET_ALL)
                .setParameter("floorName", getSearchKey(dto.getFloor()))
                .setParameter("buildingName", getSearchKey(dto.getBuilding()))
                .setParameter("employeeName", getSearchKey(dto.getEmployeeName()))
                .setParameter("shift", getSearchKey(dto.getShift()))
                .setParameter("empCode", getSearchKey(dto.getEmpCode()))
                .setParameter("bookingDate", getSearchDate(dto.getDate()));

        List<Object[]> result = query.getResultList();

        return result.stream()
                .map(Workspace::convertObjToWorkspace)
                .collect(Collectors.toList());

    }
}
