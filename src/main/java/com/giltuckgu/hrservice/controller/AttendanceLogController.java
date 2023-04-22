package com.giltuckgu.hrservice.controller;

import com.giltuckgu.hrservice.dto.AttendanceLogDto;
import com.giltuckgu.hrservice.entity.AttendanceLog;
import com.giltuckgu.hrservice.service.attendanceLog.AttendanceLogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AttendanceLogController {
    private final AttendanceLogService attendanceLogService;

    public AttendanceLogController(AttendanceLogService attendanceLogService) {
        this.attendanceLogService = attendanceLogService;
    }

    @GetMapping("/{employeeNo}/attendance")
    public void attendance(@PathVariable int employeeNo){
        attendanceLogService.createAttendanceTime(employeeNo);
    }

    @GetMapping("/{employeeNo}/leave")
    public void leave(@PathVariable int employeeNo){
        attendanceLogService.createLeaveTime(employeeNo);
    }

    @GetMapping("/{employeeNo}/log")
    public List<AttendanceLogDto> attendanceLogList(@PathVariable int employeeNo){
        List<AttendanceLogDto> attendanceLogs = attendanceLogService.attendanceLeaveLogByEmployeeNo(employeeNo);
        return attendanceLogs;
    }
}
