package com.capestart.irm.buildings.pojo;

import lombok.Builder;
import lombok.Data;

import static com.capestart.irm.common.utils.QueryUtils.convertObjToString;

@Data
@Builder
public class BookedSeat {
    private String bookedBy;
    private String seatRow;
    private String seatColumn;

    public static BookedSeat convertObjToBookedSeat(Object[] row) {
        return BookedSeat.builder()
                .bookedBy(convertObjToString(row[0]))
                .seatRow(convertObjToString(row[1]))
                .seatColumn(convertObjToString(row[2]))
                .build();
    }
}
