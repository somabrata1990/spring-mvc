package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.service.EmployeeService;

@RestController
@RequestMapping(value = "/")
public class EmployeeController {

    @Autowired private EmployeeService empService;

    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public String get(){
        return empService.getEmployeeDetails();
        //return "hello world!!!!";
    }
}
