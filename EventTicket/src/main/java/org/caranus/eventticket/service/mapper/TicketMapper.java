package org.caranus.eventticket.service.mapper;

import org.caranus.eventticket.dto.TicketDto;
import org.caranus.eventticket.model.Ticket;
import org.caranus.eventticket.model.impl.TicketImpl;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface TicketMapper {

    TicketDto ticketToTicketDto(Ticket ticket);

    TicketImpl ticketDtoToTicket(TicketDto ticketDto);
}
