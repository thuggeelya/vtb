package com.example.thuggeelya.controllers;

import com.example.thuggeelya.services.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
public class MainInfoController {

    private final RestService service;

    @Autowired
    public MainInfoController(RestService service) {
        this.service = service;
    }

    @GetMapping(path = "/info/activities", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllActivities() {
        return ResponseEntity.ok(service.getActivities());
    }

    @GetMapping(path = "/info/activities/further", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getFurtherActivities() {
        return ResponseEntity.ok(service.getFurtherActivities());
    }

    @GetMapping(path = "/info/activities/current", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCurrentActivities() {
        return ResponseEntity.ok(service.getCurrentActivities());
    }

    @GetMapping(path = "/info/activities/{id}/participants", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>
    getActivityParticipants(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(service.getActivityParticipantsById(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
