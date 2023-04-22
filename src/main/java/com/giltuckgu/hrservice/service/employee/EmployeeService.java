package com.giltuckgu.hrservice.service.employee;

import com.giltuckgu.hrservice.dto.EmployeeDto;
import com.giltuckgu.hrservice.entity.Employee;

import java.util.List;

public interface EmployeeService {
    void createEmployee(EmployeeDto employeeDto);

    void updateEmployee(EmployeeDto employeeDto);

    EmployeeDto readEmployeeByEmployeeNo(int employeeNo);


    void removeEmployee(int employeeNo);

    List<EmployeeDto> readAll();

    boolean isMatched(EmployeeDto employeeDto);



}
