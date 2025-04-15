package com.epam.employee_service.controller;

import com.epam.employee_service.entity.Employee;
import com.epam.employee_service.entity.EmployeeDepartmentDTO;
import com.epam.employee_service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/department/{code}")
    public ResponseEntity<List<Employee>> getByDepartment(@PathVariable("code") String departmentCode){
        return ResponseEntity.ok(employeeService.getByDepartmentCode(departmentCode));
    }

    @PostMapping
    public ResponseEntity<Employee> createOrUpdateEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.ok(savedEmployee);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/fullInfo/{id}")
    public EmployeeDepartmentDTO getEmplInfo(@PathVariable long id) {
        return employeeService.getEmplWithID(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
