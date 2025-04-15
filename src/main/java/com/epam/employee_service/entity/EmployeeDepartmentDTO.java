package com.epam.employee_service.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class EmployeeDepartmentDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String departmentCode;
    private String departmentName;
    private String departmentDescription;

}
