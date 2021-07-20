package com.leanTech.ltapp.model.dao;

import com.leanTech.ltapp.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IEmployeeDao extends JpaRepository<Employee, Integer> {

    @Query(value = "SELECT * FROM employees e JOIN persons p ON (e.person_id = p.id) WHERE p.name =:name", nativeQuery = true)
    public List<Employee> findEmployeesByName(@Param("name") String name);

    @Query(value = "SELECT * FROM employees WHERE position_id =:id", nativeQuery = true)
    public List<Employee> findEmployeesByPosition(@Param("id") int id);
}
