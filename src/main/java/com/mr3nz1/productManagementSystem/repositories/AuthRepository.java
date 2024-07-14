package com.mr3nz1.productManagementSystem.repositories;

import com.mr3nz1.productManagementSystem.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthRepository extends JpaRepository<Employee, UUID> {
    @Query("SELECT employee FROM Employee employee WHERE employee.email = :email")
    Employee findByEmail(@Param("email") String email);
}
