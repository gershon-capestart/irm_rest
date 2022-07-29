package com.capestart.irm.common.exceptions;

import com.capestart.irm.common.dto.ResponseDto;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class IrmException extends Exception {

    public IrmException(String message) {
        super(message);
    }

    public static ResponseDto sendErrorResponse(Exception e) {
        boolean isExceptionHandled = e.getClass().isInstance(IrmException.class);
        if (isExceptionHandled) {
            log.info("Exception Handled " + e.getMessage());
            return new ResponseDto(400, e.getMessage());
        }
        e.printStackTrace();
        return new ResponseDto(500, "Internal Server Error Occurred");
    }

}
