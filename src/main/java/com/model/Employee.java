package com.model;

import org.springframework.stereotype.Component;

@Component
public class Employee {
//    Employee(){
//        this.id = "123";
//        this.fname= "test";
//        this.lname = "test1";
//    }
    private String id = "123";
    private String fname = "som";
    private String lname = "test";

    @Override
    public String toString(){
        return "id:-" + id + " fname:- " + fname + " lname:- " + lname;
    }
}
