package com.giltuckgu.hrservice.service.salary;

import com.giltuckgu.hrservice.dto.SalaryDto;

import java.util.List;

public interface SalaryService {
    void createSalary(SalaryDto salaryDto);
    List<SalaryDto> readSalary(int employeeNo);
    void updateAmount(SalaryDto salaryDto);
}
