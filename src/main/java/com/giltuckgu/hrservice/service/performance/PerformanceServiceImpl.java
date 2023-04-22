package com.giltuckgu.hrservice.service.performance;

import com.giltuckgu.hrservice.dto.PerformanceDto;
import com.giltuckgu.hrservice.entity.Employee;
import com.giltuckgu.hrservice.entity.Performance;
import com.giltuckgu.hrservice.repository.employee.EmployeeRepository;
import com.giltuckgu.hrservice.repository.performance.PerformanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PerformanceServiceImpl implements PerformanceService{
    private final PerformanceRepository performanceRepository;
    private final EmployeeRepository employeeRepository;




    @Override
    public void createPerformance(PerformanceDto performanceDto) {
        Employee employee = employeeRepository.findEmployeeByEmployeeNo(performanceDto.getEmployeeNo());
        Performance performance = new Performance(performanceDto,employee);
        performanceRepository.save(performance);
    }

    @Override
    public List<PerformanceDto> readPerformance(int employeeNo) {
        List<Performance> performances = performanceRepository.findPerformancesByEmployeeNo(employeeNo);
        List<PerformanceDto> performancesDto = new ArrayList<>();
        for (int i = 0; i < performances.size(); i++){
            Performance performance = performances.get(i);
            performancesDto.add(new PerformanceDto(performance.getPerformanceNo(),performance.getEmployee().getEmployeeNo(),
                    performance.getTopic(),performance.getStartDate(),performance.getEndDate(),performance.getPart(),performance.getConduct()));
        }
        return performancesDto;
    }




}
