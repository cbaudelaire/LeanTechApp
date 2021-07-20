package com.leanTech.ltapp.model.service;

import com.leanTech.ltapp.model.dao.IPersonDao;
import com.leanTech.ltapp.model.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersoneServiceImpl implements IPersonService{

    @Autowired
    private IPersonDao personDao;

    @Override
    public Person createPerson(Person person) {
        return personDao.save(person);
    }
}
