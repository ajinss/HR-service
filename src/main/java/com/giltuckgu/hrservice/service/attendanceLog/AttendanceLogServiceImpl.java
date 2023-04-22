package com.giltuckgu.hrservice.service.attendanceLog;

import com.giltuckgu.hrservice.dto.AttendanceLogDto;
import com.giltuckgu.hrservice.entity.AttendanceLog;
import com.giltuckgu.hrservice.repository.attendanceLog.AttendanceLogRepository;
import com.giltuckgu.hrservice.repository.employee.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.giltuckgu.hrservice.entity.QAttendanceLog.attendanceLog;

@Service
@RequiredArgsConstructor
public class AttendanceLogServiceImpl implements AttendanceLogService{
    private final AttendanceLogRepository attendanceLogRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public void createAttendanceTime(int employeeNo) {
        LocalDateTime standardTime1 = LocalDateTime.now().withHour(9).withMinute(0).withSecond(0).withNano(0);
        LocalDateTime standardTime2 = LocalDateTime.now().withHour(18).withMinute(0).withSecond(0).withNano(0);



        AttendanceLog attendanceLog1 = new AttendanceLog();
        attendanceLog1.setEmployee(employeeRepository.findEmployeeByEmployeeNo(employeeNo));
        attendanceLog1.setAttendanceTime(LocalDateTime.now());

        if (attendanceLog1.getAttendanceTime().isAfter(standardTime1) && attendanceLog1.getAttendanceTime().isBefore(standardTime2)){
            attendanceLog1.setLate(true);
        }
        attendanceLogRepository.save(attendanceLog1);
    }

    @Override
    public void createLeaveTime(int employeeNo) {
        AttendanceLog leaveLog = new AttendanceLog();
        leaveLog.setEmployee(employeeRepository.findEmployeeByEmployeeNo(employeeNo));
        leaveLog.setLeaveTime(LocalDateTime.now());
        attendanceLogRepository.save(leaveLog);
    }

    @Override
    public List<AttendanceLogDto> attendanceLeaveLogByEmployeeNo(int employeeNo) {
       List<AttendanceLog> attendanceLogs = attendanceLogRepository.findAttendanceLogsById(employeeNo);
       int lateCount = attendanceLogRepository.countLate(employeeNo);

       List<AttendanceLogDto> logsDto = new ArrayList<>();
       for(int i = 0; i < attendanceLogs.size(); i++){
           AttendanceLog attendanceLog1 = attendanceLogs.get(i);
           logsDto.add(new AttendanceLogDto(attendanceLog1.getLogNo(),attendanceLog1.getEmployee().getEmployeeNo(), attendanceLog1.getAttendanceTime(),attendanceLog1.getLeaveTime(),attendanceLog1.isLate(),lateCount));
       }
        return logsDto;
    }

}
