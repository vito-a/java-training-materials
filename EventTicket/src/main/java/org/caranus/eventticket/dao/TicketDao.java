package org.caranus.eventticket.dao;

import org.caranus.eventticket.model.Ticket;
import org.springframework.stereotype.Component;

import static org.caranus.eventticket.config.AppConstants.TICKET_PREFIX;

@Component
public class TicketDao extends AbstractDao<Ticket> {

    protected TicketDao(MapStorage mapStorage) {
        super(mapStorage, Ticket.class);
    }

    @Override
    public Ticket map(Object o) {
        return (Ticket) o;
    }

    @Override
    public String getPrefix() {
        return TICKET_PREFIX;
    }
}
