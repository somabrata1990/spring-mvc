package com.model;

import org.springframework.stereotype.Component;

public class Employee {
    public String id;
    public String fname;
    public String lname;

    public Employee() {

    }

    public Employee(String id, String fname, String lname){
        this.id = id;
        this.fname= fname;
        this.lname = lname;
    }

    public String getId(){ return this.id; }
    public String getFname(){
        return this.fname;
    }
    public String getLname(){
        return this.lname;
    }

    public void setId(String id) { this.id = id; }
    public void setFname(String fname) { this.fname = fname; }
    public void setLname(String lname) { this.lname = lname; }

}
