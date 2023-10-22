package org.caranus.eventticket.util;

import org.caranus.eventticket.dao.EventDao;
import org.caranus.eventticket.dao.TicketDao;
import org.caranus.eventticket.dao.UserDao;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.Supplier;

@Component
public class ServiceValidator {

    private final TicketDao ticketDao;

    private final UserDao userDao;

    private final EventDao eventDao;

    @Autowired
    public ServiceValidator(TicketDao ticketDao, UserDao userDao, EventDao eventDao) {
        this.ticketDao = ticketDao;
        this.userDao = userDao;
        this.eventDao = eventDao;
    }

    public void validateUser(long userId){
        validate(userDao.get(userId), Objects::isNull, userDao.getModelClass());
    }

    public void validateTicket(long ticketId){
        validate(ticketDao.get(ticketId), Objects::isNull, ticketDao.getModelClass());
    }

    public void validateEvent(long eventId){
        validate(eventDao.get(eventId), Objects::isNull, eventDao.getModelClass());
    }

    public static <T> void validate(T value,
                              Predicate<T> invalidValueVerifier,
                              Class<T> valueClass) {
        if (invalidValueVerifier.test(value)) {
            throw new InvalidPropertyException(valueClass, valueClass.getName(), "Wrong property supplied");
        }
    }
}
