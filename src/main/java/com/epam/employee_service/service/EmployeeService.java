package com.epam.employee_service.service;

import com.epam.employee_service.client.DepartmentClient;
import com.epam.employee_service.entity.Department;
import com.epam.employee_service.entity.Employee;
import com.epam.employee_service.entity.EmployeeDepartmentDTO;
import com.epam.employee_service.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentClient departmentClient;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, DepartmentClient departmentClient) {
        this.employeeRepository = employeeRepository;
        this.departmentClient = departmentClient;
    }

    public EmployeeDepartmentDTO getEmplWithID(Long id){
        Employee employee = employeeRepository.findById(id).get();

        log.info("Employee Fetched -> {}", employee);

        Department body = departmentClient.getDepartmentByDepartmentCode(employee.getDepartmentCode()).getBody();

        log.info("Department Fetched -> {}", body);

        return EmployeeDepartmentDTO
                .builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .departmentName(body.getDepartmentName())
                .departmentDescription(body.getDepartmentDescription())
                .departmentCode(body.getDepartmentCode())
                .build();
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
