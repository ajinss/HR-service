package com.giltuckgu.hrservice.dto;

import com.giltuckgu.hrservice.entity.Employee;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AttendanceLogDto {
    private int logNo;
    private int employeeNo;
    private LocalDateTime attendanceTime;
    private LocalDateTime leaveTime;
    private boolean late;
    private  int lateCount;

    public AttendanceLogDto(int logNo, int employeeNo, LocalDateTime attendanceTime, LocalDateTime leaveTime, boolean late, int lateCount) {
        this.logNo = logNo;
        this.employeeNo = employeeNo;
        this.attendanceTime = attendanceTime;
        this.leaveTime = leaveTime;
        this.late = late;
        this.lateCount = lateCount;
    }

    public AttendanceLogDto(int logNo, int employeeNo, LocalDateTime attendanceTime, LocalDateTime leaveTime, boolean late) {
        this.logNo = logNo;
        this.employeeNo = employeeNo;
        this.attendanceTime = attendanceTime;
        this.leaveTime = leaveTime;
        this.late = late;

    }
    public AttendanceLogDto() {

    }
}
