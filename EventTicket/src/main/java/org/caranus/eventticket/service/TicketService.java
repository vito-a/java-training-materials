package org.caranus.eventticket.service;

import java.util.List;

import org.caranus.eventticket.dao.StorageDao;
import org.caranus.eventticket.dao.TicketDao;
import org.caranus.eventticket.model.Event;
import org.caranus.eventticket.model.Ticket;
import org.caranus.eventticket.model.User;


public interface TicketService {

    Ticket bookTicket(long userId, long eventId, int place, Ticket.Category category);

    List<Ticket> getAll();

    List<Ticket> getBookedTickets(User user);

    List<Ticket> getBookedTickets(Event event);

    boolean cancelTicket(long ticketId);

    void createTickets(List<Ticket> tickets);

    public TicketDao getTicketDao ();
}
