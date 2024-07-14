package com.mr3nz1.productManagementSystem.controllers;

import com.mr3nz1.productManagementSystem.models.Employee;
import com.mr3nz1.productManagementSystem.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee")
public class AuthController {
    AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("/login")
    public ResponseEntity<String> home(@RequestBody Employee emp) {
        Employee employee = authService.login(emp.getEmail(), emp.getPassword());

        if (employee != null) {
            return new ResponseEntity<>("Login Success", HttpStatus.OK);
        }

        return new ResponseEntity<>("Login Failed", HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Employee employee) {
        authService.register(employee);
        return new ResponseEntity<>("Registration successful", HttpStatus.CREATED);
    }
}
