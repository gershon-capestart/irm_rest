package com.capestart.irm.workspace.queries;

public class WorkspaceQueries {
    public static final String BOOK_WORKSPACE = "INSERT INTO irm.dbo.Workspaces (EmployeeId, FloorId, BookingDate, Shift, BookedRow, BookedColumn, Dinner, Snacks) VALUES (:employeeId, :floorId, :bookingDate , :shift, :row, :column, :dinner, :snacks );";

    public static final String GET_ALL = "SELECT w.WorkspaceId, w.EmployeeId, e.EmployeeName, f.FloorName , b.BuildlingName, w.BookingDate, w.Shift, w.BookedRow, w.BookedColumn, f.FloorId, w.Dinner, w.Snacks " +
            "FROM Workspaces w  " +
            "INNER JOIN Employees e on (e.NumericCode  = w.EmployeeId) " +
            "INNER JOIN Floors f on (f.FloorId = w.FloorId) " +
            "INNER JOIN Buildings b on (b.BuildingId  = f.BuildingId) " +
            "Where shift like :shift and BuildlingName like :buildingName and FloorName like :floorName and EmployeeName like :employeeName and BookingDate like :bookingDate and w.EmployeeId like :empCode " +
            "ORDER by BookingDate desc";
}
