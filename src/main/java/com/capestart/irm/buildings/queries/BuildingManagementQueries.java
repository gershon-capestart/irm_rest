package com.capestart.irm.buildings.queries;

public class BuildingManagementQueries {
    public static final String CREATE_BUILDING = "INSERT INTO irm.dbo.Buildings (BuildlingName,isActive) VALUES (:name,:isActive) ;";
    public static final String LIST_ALL = "SELECT BuildingId, BuildlingName, isActive FROM irm.dbo.Buildings;";

}
