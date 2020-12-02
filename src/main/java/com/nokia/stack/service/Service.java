package com.nokia.stack.service;
import com.nokia.stack.model.PushData;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface Service {
    public void push(PushData pushData);
    public ResponseEntity get(String db);
    public ResponseEntity pop(String db);
}
