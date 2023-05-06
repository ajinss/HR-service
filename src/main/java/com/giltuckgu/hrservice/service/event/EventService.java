package com.giltuckgu.hrservice.service.event;

import com.giltuckgu.hrservice.dto.EventDto;

import java.util.List;

public interface EventService {
    void inputQueue(EventDto eventDto);
    List<EventDto> limit100();
    void startTask();
}
