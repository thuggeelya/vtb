package com.example.thuggeelya.controllers;

import com.example.thuggeelya.data.Comment;
import com.example.thuggeelya.services.WhateverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/whatever")
public class WhateverController {

    private final WhateverService whateverService;

    @Autowired
    public WhateverController(WhateverService whateverService) {
        this.whateverService = whateverService;
    }

    @GetMapping("/cases")
    public ResponseEntity<?> getAllCases() {
        return ResponseEntity.ok(whateverService.getCases());
    }

    @GetMapping("/cases/{id}")
    public ResponseEntity<?> getCaseById(@PathVariable Integer id) {
        return ResponseEntity.ok(whateverService.findCaseById(id));
    }

    @PostMapping("/cases/{id}")
    public ResponseEntity<?> commentCase(@PathVariable Integer id, @RequestBody Comment comment) {
        return ResponseEntity.ok(whateverService.comment(comment));
    }

    @PutMapping("/cases/{id}")
    public ResponseEntity<?> likeComment(@PathVariable Integer id, @RequestBody Comment comment) {
        whateverService.likeComment(comment);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/cases/{id}")
    public ResponseEntity<?> closeCase(@PathVariable Integer id) {
        return whateverService.closeCase(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();

    }
}
