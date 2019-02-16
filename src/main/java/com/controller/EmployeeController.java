package com.controller;

import com.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired private EmployeeService empService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Employee getEmployeeById(@PathVariable String id){
        return empService.getEmployeeById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ArrayList<Employee> getEmployee(){
        return empService.getAllEmployee();
    }

    @RequestMapping(
            value = "/",
            method = RequestMethod.PUT,
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public boolean updateEmployeeById(
            @RequestBody Employee emp
    ){
        return empService.updateEmployeeById(emp.id, emp);
    }

    @RequestMapping(
            value = "/",
            method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public boolean addEmployee(
            @RequestBody Employee emp
    ){
        return empService.addEmployee(emp);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean deleteEmployee(@PathVariable String id){
        return empService.deleteEmployee(id);
    }
}
