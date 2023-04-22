package com.giltuckgu.hrservice.entity;

import com.giltuckgu.hrservice.dto.VacationDto;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@ToString
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Vacation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vacationNo;
    @ManyToOne
    @JoinColumn(name = "employee_no")
    private Employee employee;
    private int days;
    private LocalDate periods;
    private String type;
    private String reason;
    private boolean adminPermit;

    public Vacation(VacationDto vacationDto, Employee employee1) {
        this.vacationNo = vacationDto.getVacationNo();
        this.employee = employee1;
        this.days = vacationDto.getDays();
        this.periods = vacationDto.getPeriods();
        this.type = vacationDto.getType();
        this.reason = vacationDto.getReason();
        this.adminPermit = vacationDto.isAdminPermit();
    }
}
