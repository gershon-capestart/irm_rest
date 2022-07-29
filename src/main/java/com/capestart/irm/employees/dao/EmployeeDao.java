package com.capestart.irm.employees.dao;

import com.capestart.irm.employees.pojo.Employee;
import com.capestart.irm.employees.queries.EmployeeQueries;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Transactional
@Component
public class EmployeeDao {
    @PersistenceContext
    EntityManager em;

    public Employee getEmployeeProfileById(int empCode){
        Query query = em.createNativeQuery(EmployeeQueries.GET_PROFILE_BY_ID)
                .setParameter("empCode", empCode);
        Object[] result = (Object[]) query.getResultList().get(0);
        return Employee.ConvertObjToEmployee(result);

    }
}
