package com.giltuckgu.hrservice.dto;

import com.giltuckgu.hrservice.entity.Performance;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PerformanceDto {
    private int performanceNo;
    private int employeeNo;
    private String topic;
    private LocalDate startDate;


    private LocalDate endDate;
    private String part;
    private String conduct;
    public PerformanceDto(int performanceNo, int employeeNo, String topic, LocalDate startDate, LocalDate endDate, String part, String conduct) {
        this.performanceNo = performanceNo;
        this.employeeNo = employeeNo;
        this.topic = topic;
        this.startDate = startDate;
        this.endDate = endDate;
        this.part = part;
        this.conduct = conduct;
    }

    public PerformanceDto() {

    }
    public PerformanceDto(Performance performance) {
        this.performanceNo = performance.getPerformanceNo();
        this.employeeNo = performance.getEmployee().getEmployeeNo();
        this.topic = performance.getTopic();
        this.startDate = performance.getStartDate();
        this.endDate = performance.getEndDate();
        this.part = performance.getPart();
        this.conduct = performance.getConduct();
    }
}
