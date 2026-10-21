package com.telephony.shared;

import java.io.Serializable;

public class Room implements Serializable {
    private long id;
    private String name;

    public Room() {
    }
    public Room(long id, String name) {
        this.id = id;
        this.name = name;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}