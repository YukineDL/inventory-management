package com.inventorymanagement.controller;

import com.inventorymanagement.constant.Constants;
import com.inventorymanagement.dto.EmployeeUpdateDTO;
import com.inventorymanagement.dto.response.ApiResponse;
import com.inventorymanagement.services.IEmployeeServices;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/employees")
@SecurityRequirement(name = "bearerAuth")
public class EmployeeController {
    private final IEmployeeServices employeeServices;
    @GetMapping
    public ApiResponse<Object> findAll(HttpServletRequest request){
        String authHeader = request.getHeader(Constants.HEADER_AUTHORIZATION);
        return ApiResponse.builder()
                .result(employeeServices.getAll(authHeader))
                .build();
    }
    @GetMapping(value = "/{employeeCode}")
    public ApiResponse<Object> findByCode(@PathVariable String employeeCode,
                                          HttpServletRequest request){
        String authHeader = request.getHeader(Constants.HEADER_AUTHORIZATION);
        return ApiResponse.builder()
                .result(employeeServices.findByCode(authHeader,employeeCode))
                .build();
    }
    @PutMapping(value = "/{employeeCode}")
    public ApiResponse<Object> updateByCode(@PathVariable String employeeCode,
                                            HttpServletRequest request,
                                            @RequestBody EmployeeUpdateDTO employeeUpdateDTO){
        String authHeader = request.getHeader(Constants.HEADER_AUTHORIZATION);
        employeeServices.updateByCode(authHeader,employeeCode,employeeUpdateDTO);
        return ApiResponse.builder()
                .code("SUCCESS")
                .build();
    }
    @GetMapping(value = "/{employeeCode}/lock")
    public ApiResponse<Object> lock(@PathVariable String employeeCode,
                                    HttpServletRequest request){
        String authHeader = request.getHeader(Constants.HEADER_AUTHORIZATION);
        employeeServices.lockAccount(authHeader,employeeCode);
        return ApiResponse.builder()
                .code("SUCCESS")
                .build();
    }
    @GetMapping(value = "/{employeeCode}/unlock")
    public ApiResponse<Object> unlock(@PathVariable String employeeCode,
                                    HttpServletRequest request){
        String authHeader = request.getHeader(Constants.HEADER_AUTHORIZATION);
        employeeServices.unlockAccount(authHeader,employeeCode);
        return ApiResponse.builder()
                .code("SUCCESS")
                .build();
    }
}
