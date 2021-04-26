package de.craftedcrime.infrastructure.servermanagerwe.model;
/*
 * Created by ian on 21.03.21
 * Location: de.craftedcrime.infrastructure.servermanagerwe.model
 * Created for the project servermanagerwe with the name ErrorModel
 */

import java.sql.Timestamp;

public class ErrorModel {

    private Timestamp timestamp;
    private int status;
    private String error;
    private String message;
    private String path;

}
