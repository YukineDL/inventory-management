package com.inventorymanagement.controller;

import com.inventorymanagement.dto.AuthenDTO;
import com.inventorymanagement.dto.RegisterDTO;
import com.inventorymanagement.dto.response.ApiResponse;
import com.inventorymanagement.exception.InventoryException;
import com.inventorymanagement.services.IAuthenticatedServices;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/authenticated")
public class AuthenticatedController {
    private final IAuthenticatedServices authenticatedServices;
    @PostMapping(value = "/register")
    public ApiResponse<Object> register(@RequestBody RegisterDTO registerDTO){
            authenticatedServices.register(registerDTO);
            return ApiResponse.builder()
                    .code("SUCCESS")
                    .message("Thanh cong")
                    .build();
    }
    @PostMapping(value = "/login")
    public ApiResponse<Object> login(@RequestBody AuthenDTO authenDTO){
            return ApiResponse.builder()
                    .code("SUCCESS")
                    .result(authenticatedServices.login(authenDTO))
                    .build();
    }
}
