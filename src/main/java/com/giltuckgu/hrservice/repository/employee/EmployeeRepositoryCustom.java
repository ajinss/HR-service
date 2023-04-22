package com.giltuckgu.hrservice.repository.employee;

import com.giltuckgu.hrservice.dto.EmployeeDto;
import com.giltuckgu.hrservice.entity.Employee;

public interface EmployeeRepositoryCustom {

    int findRecentEmployeeNum();
    Employee findEmployeeByEmployeeNo(int employeeNo);
    Employee findEmployeeByName(String name);

}
