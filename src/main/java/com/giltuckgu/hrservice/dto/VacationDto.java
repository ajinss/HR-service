package com.giltuckgu.hrservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class VacationDto {
    private int vacationNo;
    private int employeeNo;
    private int days;
    private LocalDate periods;
    private String type;
    private String reason;
    private boolean adminPermit;

    public VacationDto(int vacationNo,int employeeNo, int days, LocalDate periods, String type, String reason, boolean adminPermit) {
        this.vacationNo = vacationNo;
        this.employeeNo = employeeNo;
        this.days = days;
        this.periods = periods;
        this.type = type;
        this.reason = reason;
        this.adminPermit = adminPermit;
    }


    public VacationDto() {
    }
}
