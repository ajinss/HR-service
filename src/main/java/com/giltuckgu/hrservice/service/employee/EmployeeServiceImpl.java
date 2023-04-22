package com.giltuckgu.hrservice.service.employee;

import com.giltuckgu.hrservice.dto.EmployeeDto;
import com.giltuckgu.hrservice.entity.Employee;
import com.giltuckgu.hrservice.repository.employee.EmployeeRepository;
import com.giltuckgu.hrservice.service.employee.EmployeeService;
import com.mysql.cj.x.protobuf.MysqlxCursor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;


    @Override
    public void createEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        int employeeNum = employeeRepository.findRecentEmployeeNum() + 1;
        employee.setEmployeeNo(employeeNum);
        employee.setName(employeeDto.getName());
        employee.setAddress(employeeDto.getAddress());
        employee.setPassword(employeeDto.getPassword());
        employee.setEmail(employeeDto.getEmail());
        employee.setTeam(employeeDto.getTeam());
        employee.setPosition(employeeDto.getPosition());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(EmployeeDto employeeDto) {
        Employee employee =  employeeRepository.findEmployeeByEmployeeNo(employeeDto.getEmployeeNo());
        if(!Objects.isNull(employeeDto.getPhoneNumber())){
            employee.setPhoneNumber(employeeDto.getPhoneNumber());
        }
        if(!Objects.isNull(employeeDto.getAddress())){
            employee.setAddress(employeeDto.getAddress());
        }
        if(!Objects.isNull(employeeDto.getPassword())){
            employee.setPassword(employeeDto.getPassword());
        }
        if(!Objects.isNull(employeeDto.getEmail())){
            employee.setEmail(employeeDto.getEmail());
        }
        employeeRepository.save(employee);
    }

    @Override
    public EmployeeDto readEmployeeByEmployeeNo(int employeeNo) {
        Employee employee = employeeRepository.findEmployeeByEmployeeNo(employeeNo);
        EmployeeDto employeeDto = new EmployeeDto(employee.getEmployeeNo(), employee.getName(), employee.getPhoneNumber(), employee.getEmail(), employee.getAddress(), employee.getPassword(), employee.getTeam(), employee.getPosition());
        return employeeDto;
    }




    @Override
    public void removeEmployee(int employeeNo) {
        employeeRepository.deleteById(employeeNo);
    }

    @Override
    public List<EmployeeDto> readAll() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        for (int i = 0; i < employees.size(); i++) {
            Employee employee1 = employees.get(i);
            employeeDtoList.add(new EmployeeDto(employee1.getEmployeeNo(), employee1.getName(), employee1.getPhoneNumber(), employee1.getEmail(), employee1.getAddress(), employee1.getPassword(), employee1.getTeam(), employee1.getPosition()));
        }
        return employeeDtoList;
    }

    @Override
    public boolean isMatched(EmployeeDto employeeDto) {
        Employee employee1 = employeeRepository.findEmployeeByEmployeeNo(employeeDto.getEmployeeNo());
        if (Objects.isNull(employee1)){
            return false;
        }
        if (!Objects.equals(employee1.getPassword(),employeeDto.getPassword())) {
            return false;
        }
        return true;
    }


}
