package com.capestart.irm.common.utils;

import com.capestart.irm.common.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class IrmResponse {

    public static ResponseEntity<ResponseDto> generateResponse(ResponseDto response) {
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
    }

}
