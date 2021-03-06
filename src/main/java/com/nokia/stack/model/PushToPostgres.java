package com.nokia.stack.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name = "PushTable2")
public class PushToPostgres {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private long id;

    @Column
    private long data;
    @JsonIgnore
    @Column
    private long createdtimestamp;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getData() {
        return data;
    }

    public void setData(long data) {
        this.data = data;
    }

    public long getCreatedtimestamp() {
        return createdtimestamp;
    }

    public void setCreatedtimestamp(long createdtimestamp) {
        this.createdtimestamp = createdtimestamp;
    }
}