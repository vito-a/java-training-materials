package org.caranus.eventticket.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.caranus.eventticket.dao.MapStorage;
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
	public void StorageDAO()
	{
		storageMap = new HashMap<>();
//		loadStorage();
	}

	public void addItem(String type, String itemId, AbstractModel item)
	{
		storageMap.computeIfAbsent(type, k -> new HashMap<>()).put(itemId, item);
	}

	public AbstractModel getItemById(String type, String itemId)
	{
		Map<String, AbstractModel> typeMap = storageMap.get(type);
		if (typeMap != null)
		{
			return typeMap.get(itemId);
		}
		return null;
	}

	@Override
	public Map<String, AbstractModel> getAllItemsByType(String type)
	{
		return storageMap.getOrDefault(type, new HashMap<>());
	}

	@Override
	public Event getEventById(String eventId)
	{
		AbstractModel item = getItemById("events", eventId);
		if (item instanceof Event)
		{
			return (Event) item;
		}
		else
		{
			return null;
		}
	}

	@Override
	public Ticket getTicketById(String ticketId)
	{
		AbstractModel item = getItemById("tickets", ticketId);
		if (item instanceof Ticket)
		{
			return (Ticket) item;
		}
		else
		{
			return null;
		}
	}

	@Override
	public User getUserById(String userId)
	{
		AbstractModel item = getItemById("users", userId);
		if (item instanceof User)
		{
			return (User) item;
		}
		else
		{
			return null;
		}
	}

	@Override
	public void loadStorage()
	{
		try
		{
			Gson gson = new Gson();
			Type typeObject = new TypeToken<Map<String, Map<String, AbstractModel>>>()
			{
			}.getType();
			ClassLoader classLoader = getClass().getClassLoader();
			String filename = classLoader.getResource(".").getFile() + "/test.json";
			File file = new File(filename);
			FileInputStream fis = new FileInputStream(file);
			String gsonData = Arrays.toString(fis.readAllBytes());
			fis.close();
			this.storageMap = gson.fromJson(gsonData, typeObject);
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}

	@Override
	public int saveStorage(Map<String, Map<String, AbstractModel>> storageMap)
	{
		int savedItems = 0;

		try
		{
			Gson gson = new Gson();
			Type typeObject = new TypeToken<Map<String, Map<String, AbstractModel>>>()
			{
			}.getType();
			String gsonData = gson.toJson(storageMap, typeObject);
			savedItems = storageMap.size();
			System.out.println("savedItems: " + savedItems);
			storageMap.keySet().forEach(System.out::println);
			System.out.println(gsonData);
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource(".").getFile() + "/test.json");

			if (file.createNewFile())
			{
				System.out.println("File is created!");
			}
			else
			{
				System.out.println("File exists, deleting result: " + file.delete());
				file = new File(classLoader.getResource(".").getFile() + "/test.json");
			}
			FileWriter writer = new FileWriter(file);
			writer.write(gsonData);
			writer.close();
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}

		return savedItems;
	}

	@Override
	public Map<String, Map<String, AbstractModel>> getStorageMap() {
		return storageMap;
	}
}
