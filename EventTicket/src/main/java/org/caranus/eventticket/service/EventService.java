package org.caranus.eventticket.service;


import java.util.Date;
import java.util.List;

import org.caranus.eventticket.model.Event;


public interface EventService {

    Event createEvent(Event event);

    Event getEventById(long id);

    List<Event> getEventsByTitle(String title);

    List<Event> getEventsForDay(Date day);

    Event updateEvent(Event event);

    boolean deleteEvent(long eventId);
}
