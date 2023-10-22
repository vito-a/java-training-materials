package org.caranus.eventticket.service.mapper;

import org.caranus.eventticket.dto.EventDto;
import org.caranus.eventticket.model.impl.EventImpl;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventMapper {

    EventDto eventToEventDto(EventImpl event);

    EventImpl eventDtoToEvent(EventDto eventDto);
}
