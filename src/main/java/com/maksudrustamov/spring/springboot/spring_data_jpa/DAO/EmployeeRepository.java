package com.maksudrustamov.spring.springboot.spring_data_jpa.DAO;





import com.maksudrustamov.spring.springboot.spring_data_jpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    // SpringBoot все знает про это, так, что методы тоже не нужны, главное написать
    // и тип данных entity, и тип данных primary key

    public List<Employee> findAllByName(String name);
}
