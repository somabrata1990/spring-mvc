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

    public Employee getEmployeeById(String id){
        return empDao.getById(id);
    }

    public boolean updateEmployeeById(String id, Employee emp) {
        return empDao.updateById(id, emp);
    }

    public boolean addEmployee(Employee emp) {
        return empDao.add(emp);
    }

    public boolean deleteEmployee(String id){
        return empDao.delete(id);
    }
}
