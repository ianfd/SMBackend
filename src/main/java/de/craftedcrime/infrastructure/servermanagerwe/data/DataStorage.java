package de.craftedcrime.infrastructure.servermanagerwe.data;
/*
 * Created by ian on 18.03.21
 * Location: de.craftedcrime.infrastructure.servermanagerwe.data
 * Created for the project servermanagerwe with the name DataStorage
 */

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import de.craftedcrime.infrastructure.servermanagerwe.model.ConfigEdit;
import de.craftedcrime.infrastructure.servermanagerwe.model.ConfigUpload;
import de.craftedcrime.infrastructure.servermanagerwe.model.KeySecretPair;
import de.craftedcrime.infrastructure.servermanagerwe.model.ServerObject;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@Component
public class DataStorage {

    private Cache<String, String> keyToSecretCache = CacheBuilder.newBuilder()
            .maximumSize(200)
            .expireAfterAccess(2, TimeUnit.HOURS)
            .build();

    private Cache<String, ConfigUpload> configUploadCache = CacheBuilder.newBuilder()
            .maximumSize(200)
            .expireAfterAccess(2, TimeUnit.HOURS)
            .build();

    private Cache<String, ConfigEdit> configEditCache = CacheBuilder.newBuilder()
            .maximumSize(200)
            .expireAfterAccess(2, TimeUnit.HOURS)
            .build();

    /**
     * Generate a key for authentication to edit uploaded server files
     *
     * @param key    Provide a random alphanumeric key
     * @param secret Provide a random alphanumeric secret
     * @return returns a KeySecretPair Object for further usage
     */
    public KeySecretPair insertKeyAndSecret(String key, String secret) {
        if (keyAlreadyRegistered(key)) {
            keyToSecretCache.invalidate(key);
        }
        keyToSecretCache.put(key, secret);
        return new KeySecretPair(key, secret);
    }

    /**
     * Check if a key is already registered
     *
     * @param key Key that is used to authenticate the player
     * @return whether or not the key is already registered
     */
    public boolean keyAlreadyRegistered(String key) {
        return keyToSecretCache.getIfPresent(key) != null;
    }


    /**
     * removes key and secret from cache
     *
     * @param key Key you want to remove
     */
    public void removeKeyAndSecret(String key) {
        keyToSecretCache.invalidate(key);
    }

    public String getSecretToKey(String key) {
        return keyToSecretCache.getIfPresent(key);
    }

    /**
     * Used to invalidate / remove all information that is associated with the server
     *
     * @param key The key to identify all information
     */
    public void removeEverything(String key) {
        keyToSecretCache.invalidate(key);
        configUploadCache.invalidate(key);
        configEditCache.invalidate(key);
    }

    /**
     * Check if the config is uploaded or not
     *
     * @param key Key the upload is associated
     * @return whether or not the config is uploaded
     */
    public boolean configUploadExists(String key) {
        return configUploadCache.getIfPresent(key) != null;
    }

    /**
     * add an upload to the cache
     *
     * @param key          Key you want the ConfigUpload to be associated with
     * @param configUpload config that was uploaded from the server
     */
    public void addUpload(String key, ConfigUpload configUpload) {
        if (configUploadExists(key)) {
            configUploadCache.invalidate(key);
        }
        configUploadCache.put(key, configUpload);
    }

    /**
     * removes upload from cache
     *
     * @param key Key you want to delete information from
     */
    public void removeUpload(String key) {
        configUploadCache.invalidate(key);
    }

    public ConfigUpload getConfigUpload(String key) {
        return configUploadCache.getIfPresent(key);
    }

    /**
     * checks if an edit with the key exists
     *
     * @param key key the edit is associated
     * @return whether the edit exists or not
     */
    public boolean configEditExists(String key) {
        return configEditCache.getIfPresent(key) != null;
    }

    /**
     * save the edit file from the web editor
     *
     * @param key        key you want the edit to be associated with
     * @param configEdit config edit file from the web editor
     */
    public void addEdit(String key, ConfigEdit configEdit) {
        if (configEditExists(key)) {
            configEditCache.invalidate(key);
        }
        configEditCache.put(key, configEdit);
    }

    /**
     * removes / invalidates an edit
     *
     * @param key removes the edit associated with that key
     */
    public void removeEdit(String key) {
        configEditCache.invalidate(key);
    }

    public ConfigEdit getConfigEdit(String key) {
        return configEditCache.getIfPresent(key);
    }

    @PostConstruct
    public void init() {
        insertKeyAndSecret("asd", "asd");
        HashMap<String, ServerObject> lol = new HashMap<>();
        lol.put("lobby1", new ServerObject(1, "lobby1", "10.10.5.4", 25565, "all", 100, true));
        lol.put("lobby2", new ServerObject(2, "lobby2", "10.10.5.6", 25565, "elite", 5, false));
        lol.put("lobby3", new ServerObject(3, "lobby3", "10.10.5.7", 25565, "vip", 6, true));
        HashMap<String, ServerObject> norm = new HashMap<>();
        norm.put("survival1", new ServerObject(5, "survival1", "10.10.2.5", 25565, "vip", 25, true));
        norm.put("survival2", new ServerObject(9, "survival2", "10.10.4.5", 25565, "elite", 25, true));
        norm.put("survival3", new ServerObject(12, "survival3", "10.10.7.5", 25565, "yt", 125, true));
        addUpload("asd", new ConfigUpload("lol", 100, lol, norm));
        addEdit("asd", new ConfigEdit(new ArrayList<>(), "lol", 100));
    }


}
