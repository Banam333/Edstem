package com.edstem.interview.exception;

import com.edstem.interview.model.ErrorModel;
import com.edstem.interview.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Arrays;

public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleException(InvalidRequestException ex) {
        ErrorModel error = new ErrorModel("", ex.getMessage());
        return new ErrorResponse(ex.getMessage(), Arrays.asList(error));
    }
}
