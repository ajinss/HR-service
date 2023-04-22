package com.giltuckgu.hrservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int logNo;

    @ManyToOne
    @JoinColumn(name = "employee_no")
    private Employee employee;// FK매핑 테이블 자체를 속성으로 가지고 옴.
    private LocalDateTime attendanceTime;
    private LocalDateTime leaveTime;
    private boolean late;


}
