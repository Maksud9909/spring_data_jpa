package com.maksudrustamov.spring.springboot.spring_data_jpa.DAO;


import com.maksudrustamov.spring.springboot.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {
        Query query = entityManager.createQuery("from Employee");
        List<Employee> employeeList = query.getResultList();


//        Session session = entityManager.unwrap(Session.class); // entityManager это обертка сессии, нужно развернуть обертку
//        List<Employee> employeeList = session.createQuery("from Employee ", Employee.class).getResultList();

        return employeeList;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Employee newEmployee = entityManager.merge(employee); // the same as saveOrUpdate
        employee.setId(newEmployee.getId()); // it is sets his id, but merge do not do it


//        Session session = entityManager.unwrap(Session.class);
//        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(int id) {

        Employee employee = entityManager.find(Employee.class,id); // jpa

        //        Session session = entityManager.unwrap(Session.class); // hibernate
//        Employee employee =  session.get(Employee.class,id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {


        Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId",id);
        query.executeUpdate(); // выполнять этот запрос







//        Session session = entityManager.unwrap(Session.class);
//
//        // Retrieve the employee by ID first
//        Employee employeeToDelete = session.get(Employee.class, id);
//
//        // Check if the employee exists
//        if (employeeToDelete != null) {
//            // If the employee exists, delete it
//            session.delete(employeeToDelete);
//        }
    }
}
// hello

















