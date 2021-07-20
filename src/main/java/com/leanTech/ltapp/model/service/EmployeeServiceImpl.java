package com.leanTech.ltapp.model.service;

import com.leanTech.ltapp.model.dao.IEmployeeDao;
import com.leanTech.ltapp.model.dao.IPositionDao;
import com.leanTech.ltapp.model.dto.EmployeeDto;
import com.leanTech.ltapp.model.dto.PositionDto;
import com.leanTech.ltapp.model.entity.Employee;
import com.leanTech.ltapp.model.entity.Position;
import com.leanTech.ltapp.model.mapper.IEmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService{


    @Autowired
    private IEmployeeDao employeeDao;

    @Autowired
    private IEmployeeMapper employeeMapper;

    @Autowired
    private IPositionDao positionDao;

    @Override
    public List<Employee> ListEmployeesByName(String name) {
        return employeeDao.findEmployeesByName(name);
    }

    @Override
    public List<Employee> ListEmployeesByPosition(int position_id) {
        return employeeDao.findEmployeesByPosition(position_id);
    }

    @Override
    public List<Employee> ListEmployees() {
        return employeeDao.findAll();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeDao.save(employee);
    }

    @Override
    public Optional<Employee> updateEmployee(Employee newEmployee, int id) {
        Optional<Employee> oldEmployee =  employeeDao.findById(id);
        return oldEmployee.map(employee -> {
            if(!newEmployee.getPosition().getId().equals(null)){
                Optional<Position> newPosition = positionDao.findById(newEmployee.getPosition().getId());
                employee.setPosition(newPosition.get());
            }
            if(!newEmployee.getSalary().equals(null)){
                employee.setSalary(newEmployee.getSalary());
            }
            return employeeDao.save(employee);
        });

    }

    @Override
    public void deleteEmployee(int id) {
        employeeDao.deleteById(id);
    }

    @Override
    public List<PositionDto> ListPositions() {
        List<Position> positions = positionDao.findAll();
        List<PositionDto> positionsDto = new ArrayList<>();
        for(Position position : positions) {
            PositionDto positionDto = new PositionDto();
            List<Employee> employees = ListEmployeesByPosition(position.getId());
            Collections.sort(employees, (Employee e1, Employee e2) -> e2.getSalary().compareTo(e1.getSalary()) );
            positionDto.setId(position.getId());
            positionDto.setName(position.getName());

            List<EmployeeDto> employeesDto = new ArrayList<>();
            for(Employee employee : employees){
                employeesDto.add(employeeMapper.toDto(employee));
            }
            positionDto.setEmployees(employeesDto);
            positionsDto.add(positionDto);
        }
        return positionsDto;
    }

    @Override
    public List<Position> ListPositions_() {
        return positionDao.findAll();
    }

}
