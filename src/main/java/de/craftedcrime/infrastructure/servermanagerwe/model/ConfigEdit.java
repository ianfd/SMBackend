package de.craftedcrime.infrastructure.servermanagerwe.model;
/*
 * Created by ian on 19.03.21
 * Location: de.craftedcrime.infrastructure.servermanagerwe.model
 * Created for the project servermanagerwe with the name ConfigEdit
 */

import java.util.List;

public class ConfigEdit {

    private List<ServerEdit> editList;
    private String motdBungee;
    private int maxPlayerBungee;

    public ConfigEdit(List<ServerEdit> editList, String motdBungee, int maxPlayerBungee) {
        this.editList = editList;
        this.motdBungee = motdBungee;
        this.maxPlayerBungee = maxPlayerBungee;
    }

    public List<ServerEdit> getEditList() {
        return editList;
    }

    public void setEditList(List<ServerEdit> editList) {
        this.editList = editList;
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
}
