package com.capestart.irm.vehicles.queries;

public class VehicleQueries {
    public static final String CREATE_VEHICLE = "INSERT INTO irm.dbo.Vehicle " +
            "(VehicleModel, EmployeeCode, VehicleStatus, VehicleTag) " +
            "VALUES(:model, :empCode, :status, :tag) ;";

    public static final String GET_BY_TAG = "SELECT VehicleId, VehicleModel, EmployeeCode, VehicleStatus, VehicleTag\n" +
            "FROM irm.dbo.Vehicle where VehicleTag = :tag ;";

    public static final String UPDATE_STATUS = "UPDATE irm.dbo.Vehicle " +
            "SET VehicleStatus=:status where VehicleTag =:tag ;";

    public static final String GET_ALL = "SELECT VehicleId, VehicleModel, EmployeeCode, VehicleStatus, VehicleTag " +
            "FROM irm.dbo.Vehicle where (VehicleId like :searchKey or EmployeeCode like :searchKey or " +
            "VehicleStatus like :searchKey or VehicleTag like :searchKey or VehicleModel like :searchKey) order by VehicleStatus asc;";
}
