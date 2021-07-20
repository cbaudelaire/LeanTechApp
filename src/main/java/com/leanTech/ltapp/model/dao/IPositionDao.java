package com.leanTech.ltapp.model.dao;

import com.leanTech.ltapp.model.dto.PositionDto;
import com.leanTech.ltapp.model.entity.Employee;
import com.leanTech.ltapp.model.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPositionDao extends JpaRepository<Position, Integer> {

    //SELECT PO.ID, PO.NAME, E.ID, E.SALARY,  PE.NAME, PE.LAST_NAME, PE.ADDRESS, PE.CELLPHONE, PE.CITY_NAME FROM POSITIONS PO JOIN  EMPLOYEES E ON (PO.ID = E.POSITION_ID)
    //JOIN PERSONS PE ON (E.PERSON_ID = PE.ID )
    @Query(value = "SELECT PO.ID, PO.NAME, E.ID, E.SALARY, PE.NAME, PE.LAST_NAME, PE.ADDRESS, PE.CELLPHONE, PE.CITY_NAME FROM POSITIONS PO JOIN EMPLOYEES E ON (PO.ID = E.POSITION_ID)\n" +
            "JOIN PERSONS PE ON (E.PERSON_ID = PE.ID ) ", nativeQuery = true)
    public List<PositionDto> findPositions();

}
