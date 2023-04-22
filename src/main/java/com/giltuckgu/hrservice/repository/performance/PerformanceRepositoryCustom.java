package com.giltuckgu.hrservice.repository.performance;

import com.giltuckgu.hrservice.entity.Performance;

import java.util.List;

public interface PerformanceRepositoryCustom {
    List<Performance> findPerformancesByEmployeeNo(int employeeNo);

}
