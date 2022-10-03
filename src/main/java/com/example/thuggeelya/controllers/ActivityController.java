package com.example.thuggeelya.controllers;

import com.example.thuggeelya.services.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    getActivitiesBySearch(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit,
                          @PathVariable(value = "searchWord", required = false) String searchWord) {
        return searchWord == null ?
                ResponseEntity.ok(service.getPageOfActivities(offset, limit).getContent()) :
                ResponseEntity.ok(service.getPageOfSearchResultActivities(searchWord, offset, limit).getContent());
    }

    @GetMapping("/{id}/participants")
    public ResponseEntity<?>
    getActivityParticipants(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(service.getActivityParticipantsById(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
