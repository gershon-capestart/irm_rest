package com.capestart.irm.common.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ResponseDto {
    private int statusCode;
    private Object data;
    private Date responseTimeStamp;


    public ResponseDto(int statusCode, Object data) {
        this.setData(data);
        this.setStatusCode(statusCode);
        this.setResponseTimeStamp(new Date());
    }

}
