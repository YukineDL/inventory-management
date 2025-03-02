package com.inventorymanagement;

import com.inventorymanagement.entity.Employee;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
@Configuration
public class SecurityUtils {

    public String generate(Employee employee){
        JWTClaimsSet claims = new JWTClaimsSet.Builder()
                .issuer(employee.getUsername())
                .subject(employee.getUsername())
                .expirationTime(new Date(
                        Instant.now().plus(4, ChronoUnit.HOURS).toEpochMilli()
                ))
                .claim("role_code", employee.getRoleCode())
                .claim("employee_id",employee.getId())
                .build();
        Payload payload = new Payload(claims.toJSONObject());
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS256);
        JWSObject token = new JWSObject(header,payload);
        try {
            token.sign(new MACSigner("o7Mw6BZjVh0yALUyzY3kE4ZABkIlonmY".getBytes()));
        } catch (JOSEException e){
            throw new RuntimeException(e);
        }
        return token.serialize();
    }
    public String decode(String authHeader){
         return authHeader.substring(7);
    }
}
