package de.ianfd.infrastructure.servermanagerwe.model;
/*
 * Created by ian on 19.03.21
 * Location: de.ianfd.infrastructure.servermanagerwe.model
 * Created for the project servermanagerwe with the name ServerEdit
 */

public class ServerEdit {

    private EditAction editAction;
    private ServerObject serverObject;

    public ServerEdit(EditAction editAction, ServerObject serverObject) {
        this.editAction = editAction;
        this.serverObject = serverObject;
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
}
