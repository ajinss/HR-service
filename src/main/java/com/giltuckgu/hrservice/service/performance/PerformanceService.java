package com.giltuckgu.hrservice.service.performance;

import com.giltuckgu.hrservice.dto.PerformanceDto;
import com.giltuckgu.hrservice.entity.Performance;

import java.util.List;

public interface PerformanceService {

    void createPerformance(PerformanceDto performanceDto);

    List<PerformanceDto> readPerformance(int employeeNo);

}
