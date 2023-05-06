package com.giltuckgu.hrservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventDto {
    private int eventNo;

    private  int employeeNo;

    public EventDto(int eventNo, int employeeNo) {
        this.eventNo = eventNo;
        this.employeeNo = employeeNo;
    }
}
