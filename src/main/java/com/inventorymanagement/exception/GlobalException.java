package com.inventorymanagement.exception;

import com.inventorymanagement.dto.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(value = Exception.class)
    ResponseEntity<Object> handlingException(RuntimeException exception){
        ApiResponse apiResponse = new ApiResponse<>();
        apiResponse.setCode(ExceptionMessage.INTERNAL_SERVER_ERROR);
        apiResponse.setMessage(ExceptionMessage.messages.get(ExceptionMessage.INTERNAL_SERVER_ERROR));
        return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(value = InventoryException.class)
    ResponseEntity<Object> handlingException(InventoryException exception){
        ApiResponse apiResponse = new ApiResponse<>();
        apiResponse.setCode(exception.getCodeMessage());
        apiResponse.setMessage(exception.getMessage());
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }
}
