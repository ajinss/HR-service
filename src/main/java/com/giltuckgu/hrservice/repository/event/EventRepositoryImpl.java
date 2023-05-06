package com.giltuckgu.hrservice.repository.event;

import com.giltuckgu.hrservice.entity.Event;
import com.giltuckgu.hrservice.entity.QEvent;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EventRepositoryImpl implements EventRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;


    @Override
    public List<Event> read100PrizeEmployee() {
        QEvent qEvent = QEvent.event;
        return jpaQueryFactory.selectFrom(qEvent)
                .limit(100)
                .fetch();
    }
}
