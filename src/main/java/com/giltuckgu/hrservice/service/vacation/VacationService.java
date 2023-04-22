package com.giltuckgu.hrservice.service.vacation;

import com.giltuckgu.hrservice.dto.VacationDto;

import java.util.List;

public interface VacationService {
    void createVacation(VacationDto vacationDto);

    List<VacationDto> readVacation(int employeeNo);
    void modifyAdminPermit(VacationDto vacationDto);
    void updateVacation(VacationDto vacationDto);
    void deleteVacation(int vacationNo);
}
