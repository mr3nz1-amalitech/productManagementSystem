package com.mr3nz1.productManagementSystem.services;

import com.mr3nz1.productManagementSystem.models.Employee;
import com.mr3nz1.productManagementSystem.repositories.AuthRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private AuthRepository authRepository;

    public AuthService(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public void register(Employee employee) {
        authRepository.save(employee);
    }

    public Employee login(String email, String password) {
        Employee employee = authRepository.findByEmail(email);
        System.out.println(employee);
        return employee;
    }
}
