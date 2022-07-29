package com.capestart.irm.buildings.dao;

import com.capestart.irm.buildings.dto.CreateBuildingReqDto;
import com.capestart.irm.buildings.pojo.Building;
import com.capestart.irm.buildings.queries.BuildingManagementQueries;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
public class BuildingsDao {

    @PersistenceContext
    public EntityManager em;

    public void createBuilding(CreateBuildingReqDto dto) {
        Query query = em.createNativeQuery(BuildingManagementQueries.CREATE_BUILDING)
                .setParameter("name", dto.getBuildingName())
                .setParameter("isActive", dto.isActive());
        query.executeUpdate();
    }

    public List<Building> getAllBuildings() {
        Query query = em.createNativeQuery(BuildingManagementQueries.LIST_ALL);
        List<Object[]> dbResult = query.getResultList();
        List<Building> buildings = dbResult
                .stream()
                .map(Building::convertObjToBuilding)
                .collect(Collectors.toList());
        return buildings;
    }

}
