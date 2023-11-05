package org.caranus.eventticket.dao;

import org.caranus.eventticket.model.AbstractModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public abstract class AbstractDao<T extends AbstractModel> {
    protected static final Logger logger = LoggerFactory.getLogger(AbstractDao.class);

    private final Class<T> type;

    private final Map<String, AbstractModel> storage;

    Map<String, Map<String, AbstractModel>> storageMap;

    private final StorageDao storageDao;

    protected String prefix;

    protected AbstractDao(MapStorage mapStorage, Class<T> type) {
        this.prefix = getPrefix();
        this.storageDao = mapStorage.getStorageDAO();
        this.storageMap = this.storageDao.getStorageMap();
        this.storage = mapStorage.getStorage(this.prefix);
        this.type = type;
    }

    public void save(T model) {
        storage.put(prefix + model.getId(), model);
        storageDao.saveStorage(this.storageMap);

        logger.info("Saved entity: {}", model);
    }

    public T update(T oldEvent, T newEvent) {
        if (storage.replace(prefix + oldEvent.getId(), oldEvent, newEvent)) {
            logger.info("Updated event: {}.", newEvent);

            return newEvent;
        }
        storageDao.saveStorage(storageMap);
        logger.error("Failed to update event: {}.", oldEvent);

        return null;
    }

    public T get(long id) {
        logger.info("Getting {}{}", prefix, id);

        return map(storage.get(prefix + id));
    }

    public List<T> getAll() {
        return (List<T>) getStorage().entrySet().stream()
                           .filter(map -> map.getKey().contains(prefix))
                           .map(Map.Entry::getValue)
                           .collect(Collectors.toList());
    }

    public Class<T> getModelClass() {
        return type;
    }

    public void delete(long id) {
        storage.remove(prefix + id);
        storageDao.saveStorage(this.storageMap);
        logger.error("Deleted item: {}{}", prefix, id);
    }

    public abstract T map(Object o);

    public abstract String getPrefix();

    public Map<String, AbstractModel> getStorage() {
        return storage;
    }
}
