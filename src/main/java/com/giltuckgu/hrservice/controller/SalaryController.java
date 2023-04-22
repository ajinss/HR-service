package com.giltuckgu.hrservice.controller;

import com.giltuckgu.hrservice.dto.SalaryDto;
import com.giltuckgu.hrservice.service.salary.SalaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
public class SalaryController {
    private final SalaryService salaryService;

    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @PostMapping("/create-salary")
    public void createSalary(@RequestBody SalaryDto salaryDto) {
        salaryService.createSalary(salaryDto);
    }

    @GetMapping("read-salary/{employeeNo}")
    public List<SalaryDto> readSalary(@PathVariable int employeeNo) {
        return salaryService.readSalary(employeeNo);
    }

    @PostMapping("/update-amount")
    public void modifyAmount(@RequestBody SalaryDto salaryDto) {
        log.info("dto = > "+salaryDto.getSalaryNo());
        log.info("dto = > "+salaryDto.getAmount());
        log.info("dto = > "+salaryDto.getEmployeeNo());
        salaryService.updateAmount(salaryDto);
    }
}
