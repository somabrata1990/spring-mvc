package com.dao;

import com.model.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeDao {

    private ArrayList<Employee> employeeList = new ArrayList<>();

    public EmployeeDao(){
        try {
            employeeList.add(new Employee("1", "som", "test"));
            employeeList.add(new Employee("2", "som1", "test1"));
            employeeList.add(new Employee("3", "som2", "test2"));
            employeeList.add(new Employee("4", "som3", "test3"));
            employeeList.add(new Employee("5", "som4", "test4"));
            employeeList.add(new Employee("6", "som5", "test5"));
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    public Employee getById(String id) {
        List<Employee> filteredList = employeeList.stream().filter(emp -> emp.id.equals(id)).collect(Collectors.toList());
        return filteredList.get(0);
    }

    public ArrayList<Employee> getAll() {return employeeList;}

    public boolean add(Employee emp) {
        return employeeList.add(emp);
    }

    public boolean delete(String id){
        return employeeList.removeIf(emp -> {
            return id.equals(emp.id);
        });
    }

    public boolean updateById(String id, Employee updatedEmp) {
        try{
            this.employeeList = (ArrayList<Employee>) employeeList.stream().map(emp -> {
                if(id.equals(emp.id)) {
                    return updatedEmp;
                }
                return emp;
                }).collect(Collectors.toList());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
