package org.caranus.eventticket;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import org.caranus.eventticket.facade.BookingFacade;
import org.caranus.eventticket.model.AbstractModel;
import org.caranus.eventticket.model.Event;
import org.caranus.eventticket.model.Ticket;
import org.caranus.eventticket.model.User;
import org.caranus.eventticket.model.impl.EventImpl;
import org.caranus.eventticket.model.impl.UserImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@SpringBootTest
class BookingTest
{
    @Autowired
    private BookingFacade bookingFacade;

    @Test
    void testBooking()
    {
        {
            User user = bookingFacade.createUser(new UserImpl(11L, "Test user 1", "test1@example.com"));
            Event event = bookingFacade.createEvent(new EventImpl(22L, "Test event 1"));
            bookingFacade.createUser(user);
            bookingFacade.createEvent(event);
            Ticket ticket = bookingFacade.bookTicket(user.getId(), event.getId(), 10, Ticket.Category.VIP);
            Gson gson = new Gson();
            Type typeObject = new TypeToken<HashMap>() {}.getType();
            Map<String, AbstractModel> storageDao = bookingFacade.getStorageDao();
            String gsonData = gson.toJson(storageDao, typeObject);
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource(".").getFile() + "/test.json");
            try
            {
                if (file.createNewFile())
                {
                    System.out.println("File is created!");
                }
                else
                {
                    System.out.println("File already exists.");
                }
                FileWriter writer = new FileWriter(file);
                writer.write(gsonData);
                writer.close();
            }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }
            Assert.notNull(ticket, "ticket is not null");
        }
    }
}