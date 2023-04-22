package com.giltuckgu.hrservice.repository.attendanceLog;

import com.giltuckgu.hrservice.dto.AttendanceLogDto;
import com.giltuckgu.hrservice.entity.AttendanceLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceLogRepository extends AttendanceLogRepositoryCustom, JpaRepository<AttendanceLog,Integer> {

}
