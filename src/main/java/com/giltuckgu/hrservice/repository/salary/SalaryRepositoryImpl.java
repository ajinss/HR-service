package com.giltuckgu.hrservice.repository.salary;

import com.giltuckgu.hrservice.dto.SalaryDto;
import com.giltuckgu.hrservice.entity.Performance;
import com.giltuckgu.hrservice.entity.QPerformance;
import com.giltuckgu.hrservice.entity.QSalary;
import com.giltuckgu.hrservice.entity.Salary;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SalaryRepositoryImpl implements SalaryRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    public SalaryRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }


    @Override
    public List<Salary> findSalarysByEmployeeNo(int employeeNo) {
        QSalary qSalary = QSalary.salary;
        return jpaQueryFactory.selectFrom(qSalary)
                .where(qSalary.employee.employeeNo.eq(employeeNo))
                .fetch();
    }

    @Override
    public void updateAmountByEmployeeNoAndSalaryNo(SalaryDto salaryDto) {
        QSalary qSalary = QSalary.salary;
         jpaQueryFactory.update(qSalary)
                .set(qSalary.amount, salaryDto.getAmount())
                .where(qSalary.salaryNo.eq(salaryDto.getSalaryNo()))
                 .execute();
    }
}
