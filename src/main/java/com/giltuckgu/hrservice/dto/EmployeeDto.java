package com.giltuckgu.hrservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {
    private int employeeNo;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    private String password;


    private String team;
    private String position;

    public EmployeeDto(int employeeNo, String name, String phoneNumber, String email, String address, String password, String team, String position) {
        this.employeeNo = employeeNo;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.password = password;
        this.team = team;
        this.position = position;
    }

    public EmployeeDto() {

    }
}
