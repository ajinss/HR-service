package com.giltuckgu.hrservice.repository.salary;

import com.giltuckgu.hrservice.dto.SalaryDto;
import com.giltuckgu.hrservice.entity.Performance;
import com.giltuckgu.hrservice.entity.Salary;

import java.util.List;

public interface SalaryRepositoryCustom {
    List<Salary> findSalarysByEmployeeNo(int employeeNo);

    void updateAmountByEmployeeNoAndSalaryNo(SalaryDto salaryDto);
}
