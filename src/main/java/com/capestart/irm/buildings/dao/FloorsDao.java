package com.capestart.irm.buildings.dao;

import com.capestart.irm.buildings.dto.CreateFloorReqDto;
import com.capestart.irm.buildings.pojo.BookedSeat;
import com.capestart.irm.buildings.pojo.Floor;
import com.capestart.irm.buildings.queries.FloorManagementQueries;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.capestart.irm.common.utils.QueryUtils.getSearchDate;

@Component
@Transactional
public class FloorsDao {
    @PersistenceContext
    EntityManager em;

    public void createFloor(CreateFloorReqDto dto) {
        em.createNativeQuery(FloorManagementQueries.CREATE_FLOOR)
                .setParameter("name", dto.getFloorName())
                .setParameter("buildingId", dto.getBuildingId())
                .setParameter("maxRow", dto.getMaxRows())
                .setParameter("maxColumn", dto.getMaxColumns())
                .executeUpdate();
    }

    public List<Floor> getAllFloors(int buildingId) {
        Query query = em.createNativeQuery(FloorManagementQueries.GET_ALL)
                .setParameter("buildingId", buildingId);
        List<Object[]> dbResults = query.getResultList();
        List<Floor> floors = dbResults
                .stream()
                .map(Floor::convertObjToFloor)
                .collect(Collectors.toList());
        return floors;
    }

    public Floor getFloorById(int floorId) {
        Query query = em.createNativeQuery(FloorManagementQueries.GET_BY_ID)
                .setParameter("floorId", floorId);
        List<Object[]> dbResults = query.getResultList();
        Floor floor = Floor.convertObjToFloor(dbResults.get(0));
        return floor;
    }

    public List<BookedSeat> getBookedSeatsToday(int floorId) {
        Query query = em.createNativeQuery(FloorManagementQueries.GET_BOOKED_TODAY)
                .setParameter("floorId", floorId)
                .setParameter("bookingDate", getSearchDate(new Date()));
        List<Object[]> result = query.getResultList();
        return result.stream()
                .map(BookedSeat::convertObjToBookedSeat)
                .collect(Collectors.toList());
    }
}
