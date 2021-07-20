package com.leanTech.ltapp.model.dao;

import com.leanTech.ltapp.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface IPersonDao extends JpaRepository<Person, Integer> {

}
