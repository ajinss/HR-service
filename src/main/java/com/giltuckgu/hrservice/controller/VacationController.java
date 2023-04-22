package com.giltuckgu.hrservice.controller;

import com.giltuckgu.hrservice.dto.VacationDto;
import com.giltuckgu.hrservice.entity.Vacation;
import com.giltuckgu.hrservice.service.vacation.VacationService;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VacationController {
    private final VacationService vacationService;

    public VacationController(VacationService vacationService) {
        this.vacationService = vacationService;
    }

    @PostMapping("/create-vacation")
    public void createVacation(@RequestBody VacationDto vacationDto) {
        vacationService.createVacation(vacationDto);
    }

    @GetMapping("/{vacationNo}/read-vacation")
    public List<VacationDto> readVacation(@PathVariable int vacationNo) {
        return vacationService.readVacation(vacationNo);
    }

    @PostMapping("/update-vacation")
    public void updateVacation(@RequestBody VacationDto vacationDto) {
        vacationService.updateVacation(vacationDto);
    }

    @GetMapping("{vacationNo}/delete-vacation")
    public void deleteVacation(@PathVariable int vacationNo) {
        vacationService.deleteVacation(vacationNo);
    }
}
