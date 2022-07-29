package com.capestart.irm.buildings.queries;

public class FloorManagementQueries {
    public static final String CREATE_FLOOR = "INSERT INTO irm.dbo.Floors (FloorName, BuildingId, MaxRow, MaxColumn) " +
            "VALUES(:name, :buildingId, :maxRow , :maxColumn );";

    public static final String GET_ALL = "SELECT FloorId, FloorName, BuildingId, MaxRow, MaxColumn " +
            "FROM irm.dbo.Floors where BuildingId = :buildingId ;";

    public static final String GET_BY_ID = "SELECT FloorId, FloorName, BuildingId, MaxRow, MaxColumn " +
            "FROM irm.dbo.Floors where FloorId = :floorId ;";

    public static final String GET_BOOKED_TODAY = "select  " +
            "e.EmployeeName , w.BookedRow , w.BookedColumn  " +
            "from Workspaces w inner join Employees e  on e.NumericCode = w.EmployeeId  where FloorId = :floorId and BookingDate = :bookingDate ";
}
