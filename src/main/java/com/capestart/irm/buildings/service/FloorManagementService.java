package com.capestart.irm.buildings.service;

import com.capestart.irm.buildings.dao.FloorsDao;
import com.capestart.irm.buildings.dto.CreateFloorReqDto;
import com.capestart.irm.buildings.pojo.BookedSeat;
import com.capestart.irm.buildings.pojo.Floor;
import com.capestart.irm.common.dto.ResponseDto;
import com.capestart.irm.common.exceptions.IrmException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class FloorManagementService {
    @Autowired
    FloorsDao floorsDao;

    public ResponseDto createFloor(CreateFloorReqDto dto) {
        try {
            floorsDao.createFloor(dto);
            return new ResponseDto(200, dto);
        } catch (Exception e) {
            return IrmException.sendErrorResponse(e);
        }
    }

    public ResponseDto getAllFloors(int buildingId) {
        try {
            List<Floor> floors = floorsDao.getAllFloors(buildingId);
            return new ResponseDto(HttpStatus.OK.value(), floors);
        } catch (Exception e) {
            return IrmException.sendErrorResponse(e);
        }
    }

    public ResponseDto getFloorById(int floorId) {
        try {
            Floor floor = floorsDao.getFloorById(floorId);
            return new ResponseDto(HttpStatus.OK.value(), floor);
        } catch (Exception e) {
            return IrmException.sendErrorResponse(e);
        }
    }

    public ResponseDto getBookedSeatsToday(int floorId) {
        try {
            List<BookedSeat> bookedSeats = floorsDao.getBookedSeatsToday(floorId);
            HashMap<String, BookedSeat> mappedSeats = convertSeatsToMap(bookedSeats);
            return new ResponseDto(HttpStatus.OK.value(), mappedSeats);
        } catch (Exception e) {
            return IrmException.sendErrorResponse(e);
        }
    }

    private HashMap<String, BookedSeat> convertSeatsToMap(List<BookedSeat> bookedSeats) {
        HashMap<String, BookedSeat> seatMap = new HashMap<>();
        for (BookedSeat seat : bookedSeats) {
            String currentSeat = seat.getSeatRow() + "x" + seat.getSeatColumn();
            seatMap.put(currentSeat, seat);
        }
        return seatMap;
    }
}
