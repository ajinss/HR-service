package com.giltuckgu.hrservice.repository.vacation;

import com.giltuckgu.hrservice.entity.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacationRepository extends JpaRepository<Vacation, Integer>, VacationRepositoryCustom {
}
