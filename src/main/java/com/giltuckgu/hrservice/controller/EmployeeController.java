package com.giltuckgu.hrservice.controller;

import com.giltuckgu.hrservice.dto.EmployeeDto;
import com.giltuckgu.hrservice.entity.Employee;
import com.giltuckgu.hrservice.service.employee.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    private  final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/login")
    public boolean logIn(@RequestBody EmployeeDto employeeDto) {
        return employeeService.isMatched(employeeDto);
    }

    @PostMapping("/create-employee")
    public void createEmployee(@RequestBody EmployeeDto employeeDto) {
        employeeService.createEmployee(employeeDto);
    }

    @GetMapping("/find/{employeeNo}")
    public EmployeeDto findEmployee(@PathVariable int employeeNo) {
        EmployeeDto employee = employeeService.readEmployeeByEmployeeNo(employeeNo);
        return employee;
    }

    @PostMapping("/update-employee")
    public void updateEmployee(@RequestBody EmployeeDto employeeDto) {
        employeeService.updateEmployee(employeeDto);
    }

    @GetMapping("/{employeeNo}/delete-employee")
    public void deleteEmployee(@PathVariable int employeeNo) {
        employeeService.removeEmployee(employeeNo);
    }

}
