package com.epam.employee_service.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Department {
    private Long id;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;
}
