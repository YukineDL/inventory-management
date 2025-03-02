package com.inventorymanagement.controller;

import com.inventorymanagement.constant.Constants;
import com.inventorymanagement.dto.response.ApiResponse;
import com.inventorymanagement.services.IEmployeeServices;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
    private final IEmployeeServices employeeServices;
    @GetMapping
    public ApiResponse<Object> findAll(HttpServletRequest request){
        String authHeader = request.getHeader(Constants.HEADER_AUTHORIZATION);
        return ApiResponse.builder()
                .result(employeeServices.getAll(authHeader))
                .build();
    }
}
