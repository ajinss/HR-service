package com.giltuckgu.hrservice.controller;

import com.giltuckgu.hrservice.dto.EventDto;
import com.giltuckgu.hrservice.service.event.EventService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @PostMapping("/input-queue")
    public void inputQueue(EventDto eventDto){
        eventService.inputQueue(eventDto);
    }

    @GetMapping("/prize-employee")
    public List<EventDto> viewPrizeEmployee100(){
        List<EventDto> eventDtoList = eventService.limit100();
        return eventDtoList;
    }

    @GetMapping("/start")
    public void start(){
        eventService.startTask();
    }
}
