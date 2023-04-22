package com.giltuckgu.hrservice.repository.vacation;

import com.giltuckgu.hrservice.dto.VacationDto;
import com.giltuckgu.hrservice.entity.Vacation;

import java.util.List;

public interface VacationRepositoryCustom {

    List<Vacation> findVacationByEmployeeNo(int employeeNo);

    void updateAdminPermit(VacationDto vacationDto);
    Vacation findVacationByVacationNo(VacationDto vacationDto);
    void deleteVacationByVacationNoAndEmployeeNo(int vacationNo);
}
