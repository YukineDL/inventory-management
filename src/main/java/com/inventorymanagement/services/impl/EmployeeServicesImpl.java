package com.inventorymanagement.services.impl;

import com.inventorymanagement.SecurityUtils;
import com.inventorymanagement.constant.RoleEnum;
import com.inventorymanagement.entity.Employee;
import com.inventorymanagement.exception.ExceptionMessage;
import com.inventorymanagement.exception.InventoryException;
import com.inventorymanagement.repository.EmployeeRepository;
import com.inventorymanagement.services.IEmployeeServices;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServicesImpl implements IEmployeeServices {
    private final EmployeeRepository employeeRepository;
    private final SecurityUtils securityUtils;
    private final List<String> LIST_MANAGER = new ArrayList<>(List.of(RoleEnum.ADMIN.name(),
            RoleEnum.MANAGER.name()));
    @Override
    public List<Employee> getAll(String authHeader) {
        Employee employee = getFullInformation(authHeader);
        if(!LIST_MANAGER.contains(employee.getRoleCode())){
            throw new InventoryException(ExceptionMessage.NO_PERMISSION,
                    ExceptionMessage.messages.get(ExceptionMessage.NO_PERMISSION));
        }
        return employeeRepository.findAll();
    }

    @Override
    public Employee getFullInformation(String authHeader) {
        NimbusJwtDecoder nimbusJwtDecoder = null;
        String token = securityUtils.decode(authHeader);
        SecretKeySpec secretKeySpec = new SecretKeySpec("o7Mw6BZjVh0yALUyzY3kE4ZABkIlonmY".getBytes(), "HS256");
        nimbusJwtDecoder = NimbusJwtDecoder.withSecretKey(secretKeySpec)
                .macAlgorithm(MacAlgorithm.HS256)
                .build();
        Jwt jwt = nimbusJwtDecoder.decode(token);
        Long employeeId = (Long) jwt.getClaims().get("employee_id");
        Optional<Employee> employee = employeeRepository.findById(Math.toIntExact(employeeId));
        if(employee.isEmpty()){
            throw new InventoryException(
                    ExceptionMessage.EMPLOYEE_NOT_EXISTED,
                    ExceptionMessage.messages.get(ExceptionMessage.EMPLOYEE_NOT_EXISTED)
            );
        }
        return employee.get();
    }
}
