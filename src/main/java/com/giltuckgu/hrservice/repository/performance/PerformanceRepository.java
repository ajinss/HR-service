package com.giltuckgu.hrservice.repository.performance;

import com.giltuckgu.hrservice.dto.PerformanceDto;
import com.giltuckgu.hrservice.entity.Performance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceRepository extends JpaRepository<Performance, Integer>, PerformanceRepositoryCustom {
}
