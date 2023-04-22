package com.giltuckgu.hrservice.service.attendanceLog;

import com.giltuckgu.hrservice.dto.AttendanceLogDto;
import com.giltuckgu.hrservice.entity.AttendanceLog;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AttendanceLogService {
    void createAttendanceTime(int employeeNo);
    void createLeaveTime(int employeeNo);
    List<AttendanceLogDto> attendanceLeaveLogByEmployeeNo(int employeeNo);


}
