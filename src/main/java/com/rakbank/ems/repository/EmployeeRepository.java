package com.rakbank.ems.repository;

import com.rakbank.ems.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,String> {
    Optional<Employee> findByEmployeeNo(Long employeeNo) ;
    List<Employee> findAllByIsActive(Boolean isActive) ;
}
