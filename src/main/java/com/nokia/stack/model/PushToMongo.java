package com.nokia.stack.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigInteger;

@Component
@Document(collection = "pushtomongo")
public class PushToMongo {

    //@Id
    @JsonIgnore
    private long createdtimestamp;

    private long data;

    @JsonIgnore
    @Id
    private BigInteger id;

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

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }
}