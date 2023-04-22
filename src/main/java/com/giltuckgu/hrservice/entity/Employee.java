package com.giltuckgu.hrservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    private int employeeNo;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    private String password;

    private String team;
    private String position;


}
