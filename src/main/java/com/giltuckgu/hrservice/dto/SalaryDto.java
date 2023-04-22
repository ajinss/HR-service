package com.giltuckgu.hrservice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class SalaryDto {
    private int salaryNo;
    private int employeeNo;
    private LocalDate workMonth;
    private int amount;
    private LocalDate give;

    public SalaryDto(int salaryNo,int employeeNo, LocalDate workMonth, int amount, LocalDate give) {
        this.salaryNo = salaryNo;
        this.employeeNo = employeeNo;
        this.workMonth = workMonth;
        this.amount = amount;
        this.give = give;
    }


    public SalaryDto() {

    }
}
