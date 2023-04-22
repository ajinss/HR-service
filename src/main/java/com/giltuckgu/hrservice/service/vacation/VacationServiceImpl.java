package com.giltuckgu.hrservice.service.vacation;

import com.giltuckgu.hrservice.dto.VacationDto;
import com.giltuckgu.hrservice.entity.Vacation;
import com.giltuckgu.hrservice.repository.employee.EmployeeRepository;
import com.giltuckgu.hrservice.repository.vacation.VacationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class VacationServiceImpl implements VacationService{
    private VacationRepository vacationRepository;
    private final EmployeeRepository employeeRepository;
    public VacationServiceImpl(VacationRepository vacationRepository, EmployeeRepository employeeRepository) {
        this.vacationRepository = vacationRepository;
        this.employeeRepository = employeeRepository;
    }


    @Override
    public void createVacation(VacationDto vacationDto) {
        Vacation vacation = new Vacation(vacationDto, employeeRepository.findEmployeeByEmployeeNo(vacationDto.getEmployeeNo()));
        vacationRepository.save(vacation);
    }

    @Override
    public List<VacationDto> readVacation(int employeeNo) {
        List<Vacation> vacations = vacationRepository.findVacationByEmployeeNo(employeeNo);
        List<VacationDto> vacationDtos = new ArrayList<>();
        for (int i = 0; i < vacations.size(); i++){
            Vacation vacation1 = vacations.get(i);
            vacationDtos.add(new VacationDto(vacation1.getVacationNo(),vacation1.getEmployee().getEmployeeNo(),
                    vacation1.getDays(),vacation1.getPeriods(),vacation1.getType(),vacation1.getReason(),vacation1.isAdminPermit()));
        }
        return vacationDtos;
    }

    @Transactional
    @Override
    public void modifyAdminPermit(VacationDto vacationDto) {
        vacationRepository.updateAdminPermit(vacationDto);
    }

    @Override
    public void updateVacation(VacationDto vacationDto) {
        Vacation vacation = vacationRepository.findVacationByVacationNo(vacationDto);
        System.out.println("vacation " + vacation);
        if (!Objects.isNull(vacationDto.getDays())){
            vacation.setDays(vacationDto.getDays());
        }
        if (!Objects.isNull(vacationDto.getType())){
            vacation.setType(vacationDto.getType());
        }
        if (!Objects.isNull(vacationDto.getReason())){
            vacation.setReason(vacationDto.getReason());
        }
        if (!Objects.isNull(vacationDto.getPeriods())){
            vacation.setPeriods(vacationDto.getPeriods());
        }
        vacationRepository.save(vacation);

    }

    @Transactional
    @Override
    public void deleteVacation(int vacationNo) {
        vacationRepository.deleteVacationByVacationNoAndEmployeeNo(vacationNo);
    }


}
