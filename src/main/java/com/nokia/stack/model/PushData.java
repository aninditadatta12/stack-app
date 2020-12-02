package com.nokia.stack.model;

import org.springframework.stereotype.Component;

@Component
public class PushData {

    private long data;
    private String db;


    public long getData() {
        return data;
    }

    public void setData(long data) {
        this.data = data;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }
}