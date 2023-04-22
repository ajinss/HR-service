package com.giltuckgu.hrservice.service.salary;

import com.giltuckgu.hrservice.dto.SalaryDto;
import com.giltuckgu.hrservice.entity.Salary;
import com.giltuckgu.hrservice.repository.employee.EmployeeRepository;
import com.giltuckgu.hrservice.repository.salary.SalaryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class SalaryServiceImpl implements SalaryService{
    private final SalaryRepository salaryRepository;
    private final EmployeeRepository employeeRepository;

    public SalaryServiceImpl(SalaryRepository salaryRepository, EmployeeRepository employeeRepository) {
        this.salaryRepository = salaryRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void createSalary(SalaryDto salaryDto) {
        Salary salary = new Salary(salaryDto, employeeRepository.findEmployeeByEmployeeNo(salaryDto.getEmployeeNo()));
        salaryRepository.save(salary);
    }

    @Override
    public List<SalaryDto> readSalary(int employeeNo) {
        List<Salary> salarys = salaryRepository.findSalarysByEmployeeNo(employeeNo);
        List<SalaryDto> salaryDto = new ArrayList<>();
        for (int i = 0; i < salarys.size(); i++){
            Salary salary1 = salarys.get(i);
            salaryDto.add(new SalaryDto(salary1.getSalaryNo(), salary1.getEmployee().getEmployeeNo(),salary1.getWorkMonth(),salary1.getAmount(), salary1.getGive()));
        }
        return salaryDto;
    }


    @Transactional
    @Override
    public void updateAmount(SalaryDto salaryDto) {
        salaryRepository.updateAmountByEmployeeNoAndSalaryNo(salaryDto);
    }


}
