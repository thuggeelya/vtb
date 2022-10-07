package com.example.thuggeelya.controllers;

import com.example.thuggeelya.data.UserRepository;
import com.example.thuggeelya.services.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagerController {

    private final RestService restService;
    private final UserRepository userRepository;

    @Autowired
    public ManagerController(RestService restService, UserRepository userRepository) {
        this.restService = restService;
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @GetMapping("/users/balance/{balance}")
    public ResponseEntity<?> getUsersByBalance(@PathVariable Integer balance) {
        return ResponseEntity.ok(restService.findByBalanceIs(balance));
    }

    @GetMapping("/users/balance/between/{start}/{end}")
    public ResponseEntity<?>
    getUsersByBalanceBetween(@PathVariable("start") Integer balanceStart, @PathVariable("end") Integer balanceEnd) {
        return ResponseEntity.ok(restService.findByBalanceBetween(balanceStart, balanceEnd));
    }

    @PostMapping("/users/{id}")
    public ResponseEntity<?> updateUserBalance(Integer balance, @PathVariable Integer id) {
        return ResponseEntity.ok(restService.updateUserBalance(balance, id));
    }
}
