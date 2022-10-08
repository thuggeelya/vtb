package com.example.thuggeelya.controllers;

import com.example.thuggeelya.data.CommentRepository;
import com.example.thuggeelya.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hr")
public class HRController {

    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public HRController(UserRepository userRepository, CommentRepository commentRepository) {
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }

    @GetMapping("/users/top")
    public ResponseEntity<?> getTop3UsersByMonthrate() {
        return ResponseEntity.ok(userRepository.findTop3ByOrderByMonthrateDesc());
    }

    @GetMapping("/comments/top")
    public ResponseEntity<?> getTop3CommentByNlikes() {
        return ResponseEntity.ok(commentRepository.findTop3ByOrderByNlikesDesc());
    }

    @PutMapping("/users/reset")
    public ResponseEntity<?> resetMonthrate() {
        userRepository.findAll().forEach(user -> {
            user.setMonthrate(1);
            userRepository.save(user);
        });

        return ResponseEntity.noContent().build();
    }
}
