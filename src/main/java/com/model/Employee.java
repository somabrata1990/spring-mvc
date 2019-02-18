package com.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Employee")
@Table(name = "employees")
public class Employee {

    @Column(name = "emp_no")
    @Id
    public int id;

    @Column(name = "first_name")
    public String fname;

    @Column(name = "last_name")
    public String lname;

    @Column(name = "birth_date")
    public Date birthDate;

    @Column(name = "gender")
    public String gender;

    @Column(name = "hire_date")
    public Date hireDate;

    public Employee() {}

    public Employee(
            int id,
            String fname,
            String lname,
            Date birtDate,
            Date hireDate,
            String gender
    ){
        this.id = id;
        this.fname= fname;
        this.lname = lname;
        this.birthDate = birtDate;
        this.hireDate = hireDate;
        this.gender = gender;
    }

    public int getId(){ return this.id; }
    public String getFname(){
        return this.fname;
    }
    public String getLname(){
        return this.lname;
    }
    public String getBirthDate() { return this.birthDate.toString(); }
    public Date getHireDate() { return this.hireDate; }
    public String getGender() { return this.gender; }

    public void setId(int id) { this.id = id; }
    public void setFname(String fname) { this.fname = fname; }
    public void setLname(String lname) { this.lname = lname; }
    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }
    public void setHireDate(Date hireDate) { this.hireDate = hireDate; }
    public void setGender(String gender) { this.gender = gender; }

}
