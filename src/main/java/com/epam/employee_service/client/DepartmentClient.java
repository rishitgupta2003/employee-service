package com.epam.employee_service.client;

import com.epam.employee_service.entity.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "DEPARTMENT-SERVICE")
public interface DepartmentClient {
    @GetMapping("/departments/departmentCode/{departmentCode}")
    ResponseEntity<Department> getDepartmentByDepartmentCode(@PathVariable String departmentCode);
}
