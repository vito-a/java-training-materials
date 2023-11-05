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
	void addItem(String type, String itemId, AbstractModel item);

	AbstractModel getItemById(String type, String itemId);

	Map<String, AbstractModel> getAllItemsByType(String type);

	Event getEventById(String eventId);

	Ticket getTicketById(String ticketId);

	User getUserById(String userId);

	void loadStorage();

	int saveStorage(Map<String, Map<String, AbstractModel>> storageMap);

	Map<String, Map<String, AbstractModel>> getStorageMap();
}
