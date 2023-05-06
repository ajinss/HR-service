package com.giltuckgu.hrservice.repository.event;

import com.giltuckgu.hrservice.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer>, EventRepositoryCustom{
}
