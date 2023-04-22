package com.giltuckgu.hrservice.controller;

import com.giltuckgu.hrservice.dto.PerformanceDto;
import com.giltuckgu.hrservice.service.performance.PerformanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PerformanceController {
    private final PerformanceService performanceService;

    public PerformanceController(PerformanceService performanceService) {
        this.performanceService = performanceService;
    }


    @PostMapping("/create-performance")
    public void createPerformance(@RequestBody PerformanceDto performanceDto) {
        performanceService.createPerformance(performanceDto);
    }

    @GetMapping("/{employeeNo}/performance")
    public List<PerformanceDto> readPerformances(@PathVariable int employeeNo) {
        return performanceService.readPerformance(employeeNo);
    }




}
