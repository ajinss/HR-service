package com.giltuckgu.hrservice.repository.performance;

import com.giltuckgu.hrservice.entity.Performance;
import com.giltuckgu.hrservice.entity.QPerformance;
import com.giltuckgu.hrservice.repository.employee.EmployeeRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PerformanceRepositoryImpl implements PerformanceRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    public PerformanceRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;

    }

    @Override
    public List<Performance> findPerformancesByEmployeeNo(int employeeNo) {
        QPerformance qPerformance = QPerformance.performance;
        return jpaQueryFactory.selectFrom(qPerformance)
                .where(qPerformance.employee.employeeNo.eq(employeeNo))
                .fetch();
    }
}
