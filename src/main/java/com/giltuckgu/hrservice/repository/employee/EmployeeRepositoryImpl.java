package com.giltuckgu.hrservice.repository.employee;

import com.giltuckgu.hrservice.dto.EmployeeDto;
import com.giltuckgu.hrservice.entity.Employee;
import com.giltuckgu.hrservice.entity.QEmployee;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import static com.giltuckgu.hrservice.entity.QEmployee.employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;

    public EmployeeRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public int findRecentEmployeeNum() {
        QEmployee employee = QEmployee.employee;
        //Q클래스 사용할때 file-project structure- modules- generated-sources 오른쪽 마우스 클릭후 소스로 바꿔주기

        return jpaQueryFactory.selectFrom(employee)
                .orderBy(employee.employeeNo.desc())
                .fetchFirst().getEmployeeNo();
    }

    @Override
    public Employee findEmployeeByEmployeeNo(int employeeNo) {
        QEmployee employee = QEmployee.employee;
        return jpaQueryFactory.selectFrom(employee)
                .where(employee.employeeNo.eq(employeeNo))
                .fetchFirst();
    }

    @Override
    public Employee findEmployeeByName(String name) {
        QEmployee employee = QEmployee.employee;
        return jpaQueryFactory.selectFrom(employee)
                .where(employee.name.eq(name))
                .fetchFirst();
    }


}
