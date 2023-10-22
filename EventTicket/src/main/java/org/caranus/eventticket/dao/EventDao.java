package org.caranus.eventticket.dao;

import static org.caranus.eventticket.config.AppConstants.EVENT_PREFIX;

import org.caranus.eventticket.model.Event;
import org.springframework.stereotype.Component;
@Component
public class EventDao extends AbstractDao<Event> {

    public EventDao(MapStorage mapStorage) {
        super(mapStorage, Event.class);
    }

    @Override
    public Event map(Object o) {
        return (Event) o;
    }

    @Override
    public String getPrefix() {
        return EVENT_PREFIX;
    }
}
