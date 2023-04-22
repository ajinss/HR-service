package com.giltuckgu.hrservice.entity;

import com.giltuckgu.hrservice.dto.EmployeeDto;
import com.giltuckgu.hrservice.dto.PerformanceDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Performance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int performanceNo;
    @ManyToOne
    @JoinColumn(name = "employee_no")
    private Employee employee;
    private String topic;
    private LocalDate startDate;


    private LocalDate endDate;
    private String part;
    private String conduct;


    public Performance(PerformanceDto performanceDto, Employee employee1) {
        this.performanceNo = performanceDto.getPerformanceNo();
        this.employee = employee1;
        this.topic = performanceDto.getTopic();
        this.startDate = performanceDto.getStartDate();
        this.endDate = performanceDto.getEndDate();
        this.part = performanceDto.getPart();
        this.conduct = performanceDto.getConduct();
    }
}
