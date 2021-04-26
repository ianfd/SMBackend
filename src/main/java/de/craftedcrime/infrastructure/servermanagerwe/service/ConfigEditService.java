package de.craftedcrime.infrastructure.servermanagerwe.service;
/*
 * Created by ian on 19.03.21
 * Location: de.craftedcrime.infrastructure.servermanagerwe.service
 * Created for the project servermanagerwe with the name ConfigEditService
 */

import de.craftedcrime.infrastructure.servermanagerwe.model.ConfigEdit;
import de.craftedcrime.infrastructure.servermanagerwe.data.DataStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigEditService {

    private DataStorage dataStorage;

    @Autowired
    public ConfigEditService(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }


    public ConfigEdit getConfigEdit(String key) {
        System.out.println("Downloadign credentials");
        return dataStorage.getConfigEdit(key);
    }

    public boolean configEditExists(String key) {
        return dataStorage.configEditExists(key);
    }

    public void saveConfig(String key, ConfigEdit configEdit) {
        dataStorage.addEdit(key, configEdit);
    }

}
