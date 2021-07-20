package com.leanTech.ltapp.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.leanTech.ltapp.model.entity.Position;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;


@Component
public class EmployeeDto {

    private int id;

    private PersonDto person;

    @JsonIgnore
    private Position position;

    private Integer salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PersonDto getPerson() {
        return person;
    }

    public void setPerson(PersonDto person) {
        this.person = person;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
