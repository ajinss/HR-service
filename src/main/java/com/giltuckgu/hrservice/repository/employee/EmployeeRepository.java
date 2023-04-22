package com.giltuckgu.hrservice.repository.employee;

import com.giltuckgu.hrservice.dto.EmployeeDto;
import com.giltuckgu.hrservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>, EmployeeRepositoryCustom {

}
