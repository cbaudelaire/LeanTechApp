package com.leanTech.ltapp.model.service;

import com.leanTech.ltapp.model.dto.EmployeeDto;
import com.leanTech.ltapp.model.dto.PositionDto;
import com.leanTech.ltapp.model.entity.Employee;
import com.leanTech.ltapp.model.entity.Position;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {

    public List<Employee> ListEmployeesByName(String name);

    public List<Employee> ListEmployeesByPosition(int position_id);

    public List<Employee> ListEmployees();

    public Employee createEmployee(Employee employee);

    public Optional<Employee> updateEmployee(Employee employee, int id);

    public void deleteEmployee(int id);

    public List<PositionDto> ListPositions();

    public List<Position> ListPositions_();

}
