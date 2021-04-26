package de.craftedcrime.infrastructure.servermanagerwe.service;
/*
 * Created by ian on 19.03.21
 * Location: de.craftedcrime.infrastructure.servermanagerwe.service
 * Created for the project servermanagerwe with the name SecurityService
 */

import de.craftedcrime.infrastructure.servermanagerwe.model.KeySecretPair;
import de.craftedcrime.infrastructure.servermanagerwe.data.DataStorage;
import de.craftedcrime.infrastructure.servermanagerwe.utils.GenerationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    private DataStorage dataStorage;
    private GenerationUtils generationUtils;

    @Autowired
    public SecurityService(DataStorage dataStorage, GenerationUtils generationUtils) {
        this.dataStorage = dataStorage;
        this.generationUtils = generationUtils;
    }

    public boolean validKeyAndSecret(String key, String secret) {
        if (dataStorage.keyAlreadyRegistered(key) && (dataStorage.getSecretToKey(key) != null)) {
            return  (secret.equals(dataStorage.getSecretToKey(key)));
        }
        return false;
    }

    public KeySecretPair generateNewKeyAndSecret() {
        String key = generationUtils.generateRandomAlphanumericString(15, true, true);
        String secret = generationUtils.generateRandomAlphanumericString(20, true, true);

        return dataStorage.insertKeyAndSecret(key, secret);
    }

    public void resetCredentials(String key) {
        dataStorage.removeEverything(key);
    }
}
