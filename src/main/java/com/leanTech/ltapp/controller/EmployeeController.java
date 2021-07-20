package com.leanTech.ltapp.controller;

import com.leanTech.ltapp.model.dto.EmployeeDto;
import com.leanTech.ltapp.model.dto.PersonDto;
import com.leanTech.ltapp.model.dto.PositionDto;
import com.leanTech.ltapp.model.entity.Employee;
import com.leanTech.ltapp.model.entity.Person;
import com.leanTech.ltapp.model.entity.Position;
import com.leanTech.ltapp.model.mapper.IEmployeeMapper;
import com.leanTech.ltapp.model.service.IEmployeeService;
import com.leanTech.ltapp.model.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private IEmployeeMapper employeeMapper;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IPersonService personService;


    @RequestMapping(value = "/employees", method = RequestMethod.GET, produces = "application/json")
    public List<Employee> listEmployees(@RequestParam(required = false, defaultValue = "") String position,
                                            @RequestParam(required = false, defaultValue = "") String name){
        if(!position.isEmpty()){
            return employeeService.ListEmployeesByPosition(Integer.parseInt(position));
        }
        else if(!name.isEmpty()){
            return employeeService.ListEmployeesByName(name);
        }
        else {
            return employeeService.ListEmployees();
        }
    }

    @PostMapping("/employees")
    public Employee newEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
    }

    @PutMapping("/employees/{id}")
    public Optional<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable int id){
        return employeeService.updateEmployee(employee, id);
    }

    @PostMapping("/persons")
    public Person newPerson(@Valid @RequestBody PersonDto person){
        PersonDto personDto = new PersonDto();
        return personService.createPerson(personDto.toEntity(person));
    }

    @GetMapping("/positions")
    public List<PositionDto> listPositions(){
        return employeeService.ListPositions();
    }

    @GetMapping("/positions2")
    public List<Position> listPositions2(){
        return employeeService.ListPositions_();
    }

}
