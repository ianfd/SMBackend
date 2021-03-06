package de.craftedcrime.infrastructure.servermanagerwe.model;
/*
 * Created by ian on 19.03.21
 * Location: de.craftedcrime.infrastructure.servermanagerwe.model
 * Created for the project servermanagerwe with the name ServerObject
 */

public class ServerObject {

    private int serverId;
    private String serverName;
    private String ipAddress;
    private int port;
    private String accessType;
    private int maxPlayers;
    private boolean active;

    public ServerObject(int serverId, String serverName, String ipAddress, int port, String accessType, int maxPlayers, boolean active) {
        this.serverId = serverId;
        this.serverName = serverName;
        this.ipAddress = ipAddress;
        this.port = port;
        this.accessType = accessType;
        this.maxPlayers = maxPlayers;
        this.active = active;
    }

    public ServerObject() {
    }

    public int getServerId() {
        return serverId;
    }

    public void setServerId(int serverId) {
        this.serverId = serverId;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

}
