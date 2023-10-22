package org.caranus.eventticket.dao;

import java.util.Map;

import org.caranus.eventticket.model.AbstractModel;
import org.caranus.eventticket.model.Event;
import org.caranus.eventticket.model.Ticket;
import org.caranus.eventticket.model.User;

/**
 * Storage DAO
 *
 */
public interface StorageDao
{
	public void addItem(String type, String itemId, AbstractModel item);

	public AbstractModel getItemById(String type, String itemId);

	public Map<String, AbstractModel> getAllItemsByType(String type);

	public Event getEventById(String eventId);

	public Ticket getTicketById(String ticketId);

	public User getUserById(String userId);
}
