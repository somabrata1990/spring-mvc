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

    public Employee getById(int id) {
        try{
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            Employee employee = (Employee) session.createQuery("FROM Employee where id = " + id).uniqueResult();
            tx.commit();
            session.close();
            return employee;
        } catch(Exception e) {
            return null;
        }
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
        try{
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(emp);
            tx.commit();
            session.close();
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public boolean delete(int id){
        return employeeList.removeIf(emp -> {
            return id == emp.id;
        });
    }
}
