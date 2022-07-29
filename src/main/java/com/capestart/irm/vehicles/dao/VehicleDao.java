package com.capestart.irm.vehicles.dao;

import com.capestart.irm.common.utils.QueryUtils;
import com.capestart.irm.vehicles.dto.EmployeeVehicleCreateDto;
import com.capestart.irm.vehicles.pojo.Vehicle;
import com.capestart.irm.vehicles.queries.VehicleQueries;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
public class VehicleDao {

    @PersistenceContext
    EntityManager em;

    public void createVehicle(EmployeeVehicleCreateDto dto) {
        em.createNativeQuery(VehicleQueries.CREATE_VEHICLE)
                .setParameter("empCode", dto.getEmpCode())
                .setParameter("model", dto.getVehicleName())
                .setParameter("tag", dto.getVehicleTag())
                .setParameter("status", dto.getStatus())
                .executeUpdate();
    }

    public Vehicle getVehicleByTag(String tag) {
        List<Object[]> result = em.createNativeQuery(VehicleQueries.GET_BY_TAG)
                .setParameter("tag", tag)
                .setMaxResults(1)
                .getResultList();
        return Vehicle.convertObjToVehicle(result.get(0));
    }

    public void updateVehicleStatus(Vehicle vehicle) {
        em.createNativeQuery(VehicleQueries.UPDATE_STATUS)
                .setParameter("status", vehicle.getStatus())
                .setParameter("tag", vehicle.getTag())
                .executeUpdate();
    }

    public List<Vehicle> getAllVehicles(String searchKey) {
       Query query = em.createNativeQuery(VehicleQueries.GET_ALL)
               .setParameter("searchKey", QueryUtils.getSearchKey(searchKey));
       List<Object[]> result = query.getResultList();
       return result.stream()
               .map(Vehicle::convertObjToVehicle)
               .collect(Collectors.toList());
    }
}
