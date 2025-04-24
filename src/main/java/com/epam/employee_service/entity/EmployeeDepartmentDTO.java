package com.epam.employee_service.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class EmployeeDepartmentDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Department department;
    private OrganisationDto organisationDto;
}