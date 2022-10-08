package com.example.thuggeelya.controllers;

import com.example.thuggeelya.data.User;
import com.example.thuggeelya.services.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    private final RestService service;

    @Autowired
    public ActivityController(RestService service) {
        this.service = service;
    }

    @GetMapping(value = {"/search/{searchWord}", "/search"})
    public ResponseEntity<?>
    getActivitiesBySearch(@PathVariable(value = "searchWord", required = false) String searchWord) {
        return searchWord == null ?
                ResponseEntity.ok(service.getActivities()) :
                ResponseEntity.ok(service.getSearchResultActivities(searchWord));
    }

    @GetMapping("/{id}/participants")
    public ResponseEntity<List<User>>
    getActivityParticipants(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(service.getActivityParticipantsById(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>
    getActivity(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(service.getActivity(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
