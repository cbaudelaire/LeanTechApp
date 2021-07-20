package com.leanTech.ltapp.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.leanTech.ltapp.model.entity.Person;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Component
public class PersonDto {

    @JsonIgnore
    private int id;

    @NotNull
    private String name;

    @NotBlank(message="El apellido es obligatorio")
    @NotEmpty(message="El apellido es obligatorio")
    private String lastName;

    @NotNull
    private String address;

    @NotNull
    private String cellphone;

    @NotNull
    private String cityName;

    public PersonDto(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.lastName = person.getLastName();
        this.address = person.getAddress();
        this.cellphone = person.getCellphone();
        this.cityName = person.getCityName();
    }

    public PersonDto() {
    }

    public Person toEntity(PersonDto personDto){
        Person person = new Person();
        person.setId(personDto.getId());
        person.setName(personDto.getName());
        person.setLastName(personDto.lastName);
        person.setAddress(personDto.getAddress());
        person.setCellphone(personDto.getCellphone());
        person.setCityName(personDto.getCityName());
        return person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
