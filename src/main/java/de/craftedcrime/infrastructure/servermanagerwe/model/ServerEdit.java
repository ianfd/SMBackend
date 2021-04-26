package de.craftedcrime.infrastructure.servermanagerwe.model;
/*
 * Created by ian on 19.03.21
 * Location: de.craftedcrime.infrastructure.servermanagerwe.model
 * Created for the project servermanagerwe with the name ServerEdit
 */

public class ServerEdit {

    private EditAction editAction;
    private ServerObject serverObject;
    private boolean isLobby;

    public ServerEdit(EditAction editAction, ServerObject serverObject, boolean isLobby) {
        this.editAction = editAction;
        this.serverObject = serverObject;
        this.isLobby = isLobby;
    }

    public EditAction getEditAction() {
        return editAction;
    }

    public void setEditAction(EditAction editAction) {
        this.editAction = editAction;
    }

    public ServerObject getServerObject() {
        return serverObject;
    }

    public void setServerObject(ServerObject serverObject) {
        this.serverObject = serverObject;
    }

    public boolean isLobby() {
        return isLobby;
    }

    public void setLobby(boolean lobby) {
        isLobby = lobby;
    }
}
