package com.dao;

import com.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDao {

    @Autowired
    private Employee emp;

    public String get() {
        return emp.toString();
    }
}
