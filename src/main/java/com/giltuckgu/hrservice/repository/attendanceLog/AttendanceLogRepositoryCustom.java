package com.giltuckgu.hrservice.repository.attendanceLog;

import com.giltuckgu.hrservice.entity.AttendanceLog;

import java.util.List;

public interface AttendanceLogRepositoryCustom {
    List<AttendanceLog> findAttendanceLogsById(int employeeNo);

    int countLate(int employeeNo);
    //select count(late) from attendanceLog where late = true and employeeNo=?q



}
