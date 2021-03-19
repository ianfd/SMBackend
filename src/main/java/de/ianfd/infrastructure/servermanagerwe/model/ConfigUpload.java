package de.ianfd.infrastructure.servermanagerwe.model;
/*
 * Created by ian on 19.03.21
 * Location: de.ianfd.infrastructure.servermanagerwe.model
 * Created for the project servermanagerwe with the name ConfigUpload
 */

import java.util.HashMap;
import java.util.Map;

public class ConfigUpload {

    private String motdBungee;
    private int maxPlayerBungee;
    private Map<String, ServerObject> lobbyMap = new HashMap<>();
    private Map<String, ServerObject> nonLobbiesMap = new HashMap<>();

    public ConfigUpload(String motdBungee, int maxPlayerBungee, Map<String, ServerObject> lobbyMap, Map<String, ServerObject> nonLobbiesMap) {
        this.motdBungee = motdBungee;
        this.maxPlayerBungee = maxPlayerBungee;
        this.lobbyMap = lobbyMap;
        this.nonLobbiesMap = nonLobbiesMap;
    }

    public String getMotdBungee() {
        return motdBungee;
    }

    public void setMotdBungee(String motdBungee) {
        this.motdBungee = motdBungee;
    }

    public int getMaxPlayerBungee() {
        return maxPlayerBungee;
    }

    public void setMaxPlayerBungee(int maxPlayerBungee) {
        this.maxPlayerBungee = maxPlayerBungee;
    }

    public Map<String, ServerObject> getLobbyMap() {
        return lobbyMap;
    }

    public void setLobbyMap(Map<String, ServerObject> lobbyMap) {
        this.lobbyMap = lobbyMap;
    }

    public Map<String, ServerObject> getNonLobbiesMap() {
        return nonLobbiesMap;
    }

    public void setNonLobbiesMap(Map<String, ServerObject> nonLobbiesMap) {
        this.nonLobbiesMap = nonLobbiesMap;
    }
}
