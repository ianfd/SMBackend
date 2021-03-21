package de.craftedcrime.infrastructure.servermanagerwe.model;
/*
 * Created by ian on 19.03.21
 * Location: de.craftedcrime.infrastructure.servermanagerwe.model
 * Created for the project servermanagerwe with the name ConfigEdit
 */

import java.util.List;

public class ConfigEdit {

    private List<ServerEdit> serverEdits;
    private String bungeeMODT;
    private int bungeeMaxServerSlots;

    public ConfigEdit(List<ServerEdit> serverEdits, String bungeeMODT, int bungeeMaxServerSlots) {
        this.serverEdits = serverEdits;
        this.bungeeMODT = bungeeMODT;
        this.bungeeMaxServerSlots = bungeeMaxServerSlots;
    }

    public List<ServerEdit> getServerEdits() {
        return serverEdits;
    }

    public void setServerEdits(List<ServerEdit> serverEdits) {
        this.serverEdits = serverEdits;
    }

    public String getBungeeMODT() {
        return bungeeMODT;
    }

    public void setBungeeMODT(String bungeeMODT) {
        this.bungeeMODT = bungeeMODT;
    }

    public int getBungeeMaxServerSlots() {
        return bungeeMaxServerSlots;
    }

    public void setBungeeMaxServerSlots(int bungeeMaxServerSlots) {
        this.bungeeMaxServerSlots = bungeeMaxServerSlots;
    }
}
