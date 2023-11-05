package org.caranus.eventticket.dao;

import java.util.Map;

import org.caranus.eventticket.model.AbstractModel;
import org.springframework.stereotype.Component;

@Component
public class MapStorage {
    private final StorageDao dao;

    private Map<String, Map<String, AbstractModel>> storageMap;

    private MapStorage(final StorageDao dao)
    {
        this.dao = dao;
        this.storageMap = dao.getStorageMap();
    }

    public Map<String, AbstractModel> getStorage(String prefix)
    {
        return dao.getAllItemsByType(prefix);
    }

    public StorageDao getStorageDAO()
    {
        return dao;
    }
}
