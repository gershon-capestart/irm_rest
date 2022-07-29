package com.capestart.irm.employees.queries;


public class EmployeeQueries {
    public static final String GET_PROFILE_BY_ID = "SELECT  EmployeeName, NumericCode, Designation,Email, Team FROM irm.dbo.Employees where NumericCode = :empCode ";
}
