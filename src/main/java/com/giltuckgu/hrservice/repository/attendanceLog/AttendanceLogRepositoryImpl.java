package com.giltuckgu.hrservice.repository.attendanceLog;

import com.giltuckgu.hrservice.entity.AttendanceLog;
import com.giltuckgu.hrservice.entity.QAttendanceLog;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AttendanceLogRepositoryImpl implements AttendanceLogRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;


    @Override
    public List<AttendanceLog> findAttendanceLogsById(int employeeNo) {
        QAttendanceLog qattendanceLog = QAttendanceLog.attendanceLog;
        return jpaQueryFactory.selectFrom(qattendanceLog)
                .where(qattendanceLog.employee.employeeNo.eq(employeeNo))
                .fetch();
    }

    @Override
    public int countLate(int employeeNo) {
        QAttendanceLog count = QAttendanceLog.attendanceLog;
        int countNum = (int) jpaQueryFactory.selectFrom(count)
                .where(count.late.eq(true).and(count.employee.employeeNo.eq(employeeNo)))
                .fetchCount();
        return countNum;
    }
}
