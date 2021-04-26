package de.craftedcrime.infrastructure.servermanagerwe.service;
/*
 * Created by ian on 20.03.21
 * Location: de.craftedcrime.infrastructure.servermanagerwe.service
 * Created for the project servermanagerwe with the name ConfigUploadService
 */

import de.craftedcrime.infrastructure.servermanagerwe.data.DataStorage;
import de.craftedcrime.infrastructure.servermanagerwe.model.ConfigUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigUploadService {

    private DataStorage dataStorage;

    @Autowired
    public ConfigUploadService(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    public void saveConfigUpload(String key, ConfigUpload configUpload) {
        dataStorage.addUpload(key, configUpload);
    }

    public ConfigUpload getConfigUpload(String key) {
        return dataStorage.getConfigUpload(key);
    }

}
