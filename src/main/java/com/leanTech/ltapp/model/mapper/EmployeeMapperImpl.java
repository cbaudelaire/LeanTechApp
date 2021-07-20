package com.leanTech.ltapp.model.mapper;

import com.leanTech.ltapp.model.dto.EmployeeDto;
import com.leanTech.ltapp.model.dto.PersonDto;
import com.leanTech.ltapp.model.dto.PositionDto;
import com.leanTech.ltapp.model.entity.Employee;
import com.leanTech.ltapp.model.entity.Position;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapperImpl implements IEmployeeMapper{

    @Override
    public EmployeeDto toDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setPosition(employee.getPosition());
        employeeDto.setSalary(employee.getSalary());

        PersonDto personDto = new PersonDto(employee.getPerson());
        employeeDto.setPerson(personDto);
        return employeeDto;
    }

    @Override
    public Employee toEntity(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setPosition(employeeDto.getPosition());
        employee.setSalary(employeeDto.getSalary());

        PersonDto personDto = new PersonDto();
        employee.setPerson(personDto.toEntity(employeeDto.getPerson()));
        return employee;
    }

}
