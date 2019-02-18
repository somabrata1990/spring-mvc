package com.dao;

import com.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeDao {

    private ArrayList<Employee> employeeList = new ArrayList<>();

    private SessionFactory sessionFactory;

    public EmployeeDao(){
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class);
            System.out.println("Hibernate Annotation Configuration loaded");

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            System.out.println("Hibernate Annotation serviceRegistry created");

            this.sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Employee getById(String id) {
        List<Employee> filteredList = employeeList.stream().filter(emp -> emp.id.equals(id)).collect(Collectors.toList());
        return filteredList.get(0);
    }

    public ArrayList<Employee> getAll() {
        try{
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            List<Employee> employeeList = session.createQuery("FROM Employee").list();
            tx.commit();
            session.close();
            return (ArrayList<Employee>) employeeList;
        } catch(Exception e) {
            return new ArrayList<Employee>();
        }
    }

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
