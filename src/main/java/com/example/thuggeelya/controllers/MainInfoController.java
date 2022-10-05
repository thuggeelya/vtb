package com.example.thuggeelya.controllers;

import com.example.thuggeelya.services.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/info")
public class MainInfoController {

    private final RestService service;

    @Autowired
    public MainInfoController(RestService service) {
        this.service = service;
    }

    @GetMapping("/activities")
    public ResponseEntity<?> getAllActivities() {
        return ResponseEntity.ok(service.getActivities());
    }

    @GetMapping("/activities/further")
    public ResponseEntity<?> getFurtherActivities() {
        return ResponseEntity.ok(service.getFurtherActivities());
    }

    @GetMapping("/activities/current")
    public ResponseEntity<?> getCurrentActivities() {
        return ResponseEntity.ok(service.getCurrentActivities());
    }

    @GetMapping("/activities/{id}/participants")
    public ResponseEntity<?>
    getActivityParticipants(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(service.getActivityParticipantsById(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
