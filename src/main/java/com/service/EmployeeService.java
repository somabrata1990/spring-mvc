package com.service;

import com.dao.EmployeeDao;
import com.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeService {

    @Autowired private EmployeeDao empDao;

    public ArrayList<Employee> getAllEmployee(){
        return empDao.getAll();
    }

    public Employee getEmployeeById(int id){
        return empDao.getById(id);
    }

    public boolean addEmployee(Employee emp) {
        return empDao.add(emp);
    }

    public boolean deleteEmployee(int id){
        return empDao.delete(id);
    }
}
