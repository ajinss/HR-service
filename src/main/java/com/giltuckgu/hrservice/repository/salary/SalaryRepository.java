package com.giltuckgu.hrservice.repository.salary;

import com.giltuckgu.hrservice.dto.SalaryDto;
import com.giltuckgu.hrservice.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface SalaryRepository extends JpaRepository<Salary, Integer>, SalaryRepositoryCustom {
}
