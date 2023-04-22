package com.giltuckgu.hrservice.entity;

import com.giltuckgu.hrservice.dto.SalaryDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int salaryNo;
    @ManyToOne
    @JoinColumn(name = "employee_no")
    private Employee employee;
    private LocalDate workMonth;
    private int amount;
    private LocalDate give;

    public Salary(SalaryDto salaryDto, Employee employee1) {
        this.salaryNo = salaryDto.getSalaryNo();
        this.employee = employee1;
        this.workMonth = salaryDto.getWorkMonth();
        this.amount = salaryDto.getAmount();
        this.give = salaryDto.getGive();
    }
}
