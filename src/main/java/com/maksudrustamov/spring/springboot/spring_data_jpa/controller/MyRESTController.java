package com.maksudrustamov.spring.springboot.spring_data_jpa.controller;




import com.maksudrustamov.spring.springboot.entity.Employee;
import com.maksudrustamov.spring.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// здесь мы создаем все методы для servlet
@RestController // говорит, что он rest controller
@RequestMapping("/api")
public class MyRESTController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees") // это обозначает, что мы в сылке делаем метод get
    public List<Employee> showAllEmployees(){
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees; // теперь он это конвертирует в JSON, через Jackson
    }
    @GetMapping("/employees/{id}") // тут мы пишем, что после сылки должен быть айди работника
    public Employee getEmployee(@PathVariable int id){ // он помогает взять из сылки этот айди и использовать его в нашем методе
        Employee employee = employeeService.getEmployee(id);

        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee){ // из-за того, что у нас метод http post, мы получаем его в body
        employeeService.saveEmployee(employee);
        System.out.println("he");
        return employee;
    }

    @PutMapping("/employees") // обновляет работника
    public Employee updateEmployee(@RequestBody Employee employee){ //из-за того, что у нас метод http post, мы получаем его из тела запроса
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
            return "Employee with this " + id + " deleted";
        }


    }


