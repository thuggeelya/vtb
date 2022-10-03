package com.example.thuggeelya.controllers;

import com.example.thuggeelya.services.RestService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<?>
    getAllActivitiesPage(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit) {
        return ResponseEntity.ok(service.getPageOfActivities(offset, limit).getContent());
    }

    @GetMapping("/activities/further")
    public ResponseEntity<?>
    getFurtherActivitiesPage(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit) {
        return ResponseEntity.ok(service.getPageOfFurtherActivities(offset, limit).getContent());
    }

    @GetMapping("/activities/current")
    public ResponseEntity<?>
    getCurrentActivitiesPage(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit) {
        return ResponseEntity.ok(service.getPageOfCurrentActivities(offset, limit).getContent());
    }

    @GetMapping("/activities/{id}/participants")
    public ResponseEntity<?>
    getActivityParticipants(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(service.getActivityParticipantsById(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
