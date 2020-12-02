package com.nokia.stack.controller;

import com.nokia.stack.model.PushData;
import com.nokia.stack.service.Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
public class Controller {

    @Autowired
    Service service;

    @ApiOperation(value = "To push data to Stack", tags = "Push Operation")
    @PostMapping(value = "/push")
    public ResponseEntity push(@RequestBody PushData pushData){
        service.push(pushData);
        return new ResponseEntity("Data Pushed To Stack", HttpStatus.OK);
    }

    @ApiOperation(value = "To get all data from Stack", tags = "Get Operation")
    @GetMapping(value = "/get")
    public ResponseEntity get(@RequestParam(name="db") String db) {
        return service.get(db);
    }

    @ApiOperation(value = "To Pop data from Stack", tags = "Pop Operation")
    @DeleteMapping(value = "/pop")
    public ResponseEntity pop(@RequestParam(name="db") String db) {
        return service.pop(db);
    }

}
