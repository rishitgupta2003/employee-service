package com.epam.employee_service.repository;

import com.epam.employee_service.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartmentCode(String departmentCode);
}
