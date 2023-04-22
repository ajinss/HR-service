package com.giltuckgu.hrservice.repository.vacation;

import com.giltuckgu.hrservice.dto.VacationDto;
import com.giltuckgu.hrservice.entity.QVacation;
import com.giltuckgu.hrservice.entity.Vacation;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class VacationRepositoryImpl implements VacationRepositoryCustom{

    private  final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Vacation> findVacationByEmployeeNo(int employeeNo) {
        QVacation qVacation = QVacation.vacation;
        return jpaQueryFactory.selectFrom(qVacation)
                .where(qVacation.employee.employeeNo.eq(employeeNo))
                .fetch();
    }

    @Override
    public void updateAdminPermit(VacationDto vacationDto) {
        QVacation qVacation = QVacation.vacation;
        jpaQueryFactory.update(qVacation)
                .set(qVacation.adminPermit, vacationDto.isAdminPermit())
                .where(qVacation.employee.employeeNo.eq(vacationDto.getEmployeeNo()))
                .execute();
    }

    @Override
    public Vacation findVacationByVacationNo(VacationDto vacationDto) {
        QVacation qVacation = QVacation.vacation;
        return jpaQueryFactory.selectFrom(qVacation)
                .where(qVacation.vacationNo.eq(vacationDto.getVacationNo()))
                .fetchFirst();
    }

    @Override
    public void deleteVacationByVacationNoAndEmployeeNo(int vacationNo) {
        QVacation qVacation = QVacation.vacation;
        jpaQueryFactory.delete(qVacation)
                .where((qVacation.vacationNo.eq(vacationNo)))
                .execute();
    }

}
