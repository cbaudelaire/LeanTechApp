package com.leanTech.ltapp.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.leanTech.ltapp.model.entity.Position;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PositionDto {

    private Integer id;

    private String name;

    private List<EmployeeDto> employees;

    public PositionDto(){

    }

    public PositionDto(Position position){
        this.id = position.getId();
        this.name = position.getName();
    }

    public Position toEntity(PositionDto positionDto){
        Position position = new Position();
        position.setId(positionDto.getId());
        position.setName(positionDto.getName());
        return position;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EmployeeDto> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDto> employees) {
        this.employees = employees;
    }
}
