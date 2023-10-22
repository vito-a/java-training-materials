package org.caranus.eventticket.dao.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import org.caranus.eventticket.dao.StorageDao;
import org.caranus.eventticket.facade.impl.BookingFacadeImpl;
import org.caranus.eventticket.model.AbstractModel;
import org.caranus.eventticket.model.Event;
import org.caranus.eventticket.model.Ticket;
import org.caranus.eventticket.model.User;
import org.caranus.eventticket.model.impl.EventImpl;
import org.caranus.eventticket.model.impl.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


/**
 * Simple in-memory DAO
 */
@Service
public class StorageDaoImpl implements StorageDao
{
    private Map<String, Map<String, AbstractModel>> storageMap;

    @Autowired
    public void StorageDAO() {
        storageMap = new HashMap<>();
    }

    public void addItem(String type, String itemId, AbstractModel item) {
        storageMap.computeIfAbsent(type, k -> new HashMap<>()).put(itemId, item);
    }

    public AbstractModel getItemById(String type, String itemId) {
        Map<String, AbstractModel> typeMap = storageMap.get(type);
        if (typeMap != null) {
            return typeMap.get(itemId);
        }
        return null;
    }

    public Map<String, AbstractModel> getAllItemsByType(String type) {
        return storageMap.getOrDefault(type, new HashMap<>());
    }

    public Event getEventById(String eventId) {
        AbstractModel item = getItemById("events", eventId);
        if (item instanceof Event) {
            return (Event) item;
        } else {
            return null;
        }
    }

    public Ticket getTicketById(String ticketId) {
        AbstractModel item = getItemById("tickets", ticketId);
        if (item instanceof Ticket) {
            return (Ticket) item;
        } else {
            return null;
        }
    }

    public User getUserById(String userId) {
        AbstractModel item = getItemById("users", userId);
        if (item instanceof User) {
            return (User) item;
        } else {
            return null;
        }
    }
}
