package org.caranus.eventticket.facade.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.caranus.eventticket.facade.BookingFacade;
import org.caranus.eventticket.model.AbstractModel;
import org.caranus.eventticket.model.Event;
import org.caranus.eventticket.model.Ticket;
import org.caranus.eventticket.model.User;
import org.caranus.eventticket.model.impl.TicketImpl;
import org.caranus.eventticket.service.EventService;
import org.caranus.eventticket.service.TicketService;
import org.caranus.eventticket.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class BookingFacadeImpl implements BookingFacade
{
    private final EventService eventService;

    private final TicketService ticketService;

    private final UserService userService;

    public BookingFacadeImpl(final EventService eventService, final TicketService ticketService, final UserService userService)
    {
        this.eventService = eventService;
        this.ticketService = ticketService;
        this.userService = userService;
    }

    @Override
    public Event getEventById(long eventId) {
        return eventService.getEventById(eventId);
    }

    @Override
    public List<Ticket> getAllTickets() {
       return ticketService.getAll();
    }

    @Override
    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return eventService.getEventsByTitle(title);
    }

    @Override
    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return eventService.getEventsForDay(day);
    }

    @Override
    public Event createEvent(Event event) {
        return eventService.createEvent(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return eventService.updateEvent(event);
    }

    @Override
    public boolean deleteEvent(long eventId) {
        return eventService.deleteEvent(eventId);
    }

    @Override
    public User getUserById(long userId) {
        return userService.getUserById(userId);
    }

    @Override
    public User getUserByEmail(String email) {
        return userService.getUserByEmail(email);
    }

    @Override
    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        return userService.getUsersByName(name);
    }

    @Override
    public User createUser(User user) {
        return userService.createUser(user);
    }

    @Override
    public User updateUser(User user) {
        return userService.updateUser(user);
    }

    @Override
    public boolean deleteUser(long userId) {
        return userService.deleteUser(userId);
    }

    @Override
    public Ticket bookTicket(long userId, long eventId, int place, Ticket.Category category) {
        return ticketService.bookTicket(userId, eventId, place, category);
    }

    @Override
    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        return ticketService.getBookedTickets(user);
    }

    @Override
    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        return ticketService.getBookedTickets(event);
    }

    @Override
    public boolean cancelTicket(long ticketId) {
        return ticketService.cancelTicket(ticketId);
    }

    private List<Ticket> map(List<TicketImpl> tickets) {
        return tickets.stream().map(this::map).collect(Collectors.toList());
    }

    private Ticket map(TicketImpl ticket) {
        return ticket;
    }

    public Map<String, AbstractModel> getStorageDao () {
        return this.ticketService.getTicketDao().getStorage();
    }
}
