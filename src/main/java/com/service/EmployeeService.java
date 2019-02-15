package com.service;

import com.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService {

    @Autowired private EmployeeDao empDao;

    public String getEmployeeDetails(){
        return empDao.get();
    }
}
