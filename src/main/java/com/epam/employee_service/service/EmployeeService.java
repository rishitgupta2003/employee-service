package com.epam.employee_service.service;

import com.epam.employee_service.client.DepartmentClient;
import com.epam.employee_service.client.OrganisationClient;
import com.epam.employee_service.entity.Department;
import com.epam.employee_service.entity.Employee;
import com.epam.employee_service.entity.EmployeeDepartmentDTO;
import com.epam.employee_service.entity.OrganisationDto;
import com.epam.employee_service.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final OrganisationClient organisationClient;
    private final DepartmentClient departmentClient;

    public EmployeeDepartmentDTO getEmplWithID(Long id){
        Employee employee = employeeRepository.findById(id).get();

        log.info("Employee Fetched -> {}", employee);

        Department body = departmentClient.getDepartmentByDepartmentCode(employee.getDepartmentCode()).getBody();
        OrganisationDto body1 = organisationClient.getOrganisationByCode(body.getOrgCode()).getBody();

        log.info("Department Fetched -> {}", body);

        return EmployeeDepartmentDTO
                .builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .department(body)
                .organisationDto(body1)
                .build();
    }

    public List<Employee> getByDepartmentCode(String departmentCode){
        return employeeRepository.findByDepartmentCode(departmentCode);
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
