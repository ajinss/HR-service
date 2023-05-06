package com.giltuckgu.hrservice.service.event;

import com.giltuckgu.hrservice.dto.EventDto;
import com.giltuckgu.hrservice.entity.Employee;
import com.giltuckgu.hrservice.entity.Event;
import com.giltuckgu.hrservice.repository.employee.EmployeeRepository;
import com.giltuckgu.hrservice.repository.event.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Service
@RequiredArgsConstructor
public class EventServiceImpl  implements EventService{
    private final EventRepository eventRepository;
    private final EmployeeRepository employeeRepository;
    private final ConcurrentLinkedQueue<EventDto> queue = new ConcurrentLinkedQueue<>();
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);


    @Override
    public void inputQueue(EventDto eventDto) {
        if (queue.size() < 101) {
            queue.add(eventDto);
        }
    }

    @Override
    public List<EventDto> limit100() {
        List<Event> eventList = eventRepository.read100PrizeEmployee();
        List<EventDto> eventDtoList = new ArrayList<>();
        for(int i = 0; i < eventList.size();i++){
            Event event = eventList.get(i);
            EventDto eventDto = new EventDto(event.getEventNo(), event.getEmployee().getEmployeeNo());
            eventDtoList.add(eventDto);
        }
        return eventDtoList;
    }

    public void startTask(){
        while(!queue.isEmpty()){
            executorService.submit(()->{
                EventDto eventDto = queue.poll();
                Employee employee = employeeRepository.findEmployeeByEmployeeNo(eventDto.getEmployeeNo());
                Event event = new Event(eventDto.getEventNo(), employee);
                eventRepository.save(event);
            });
        }

    }
}
