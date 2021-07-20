package com.leanTech.ltapp.model.mapper;

import com.leanTech.ltapp.model.dto.EmployeeDto;
import com.leanTech.ltapp.model.entity.Employee;

public interface IEmployeeMapper {

    public EmployeeDto toDto(Employee employee);

    public Employee toEntity(EmployeeDto employeeDto);
}
