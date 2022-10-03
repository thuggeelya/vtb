package com.example.thuggeelya.controllers;

import com.example.thuggeelya.data.Activity;
import com.example.thuggeelya.data.LoginForm;
import com.example.thuggeelya.data.Manager;
import com.example.thuggeelya.data.Transaction;
import com.example.thuggeelya.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/transactions")
    public ResponseEntity<?> createTransaction(@RequestBody Transaction transaction) {
        Transaction newTransaction = adminService.addNewTransaction(transaction);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newTransaction.getIdtransaction()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PostMapping("/loginForms")
    public ResponseEntity<?> createUser(@RequestBody LoginForm loginForm) {
        LoginForm newLoginForm = adminService.addNewLoginForm(loginForm);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newLoginForm.getIduser()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PostMapping("/activities")
    public ResponseEntity<?> createActivity(@RequestBody Activity activity) {
        Activity newActivity = adminService.addNewActivity(activity);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newActivity.getIdactivity()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PostMapping("/managers")
    public ResponseEntity<?> createManager(@RequestBody Manager manager) {
        Manager newManager = adminService.addNewManager(manager);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newManager.getIduser()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/loginForms/{id}")
    public void deleteLoginForm(@PathVariable Integer id) {
        adminService.deleteLoginForm(id);
    }

    @DeleteMapping("/activities/{id}")
    public void deleteActivity(@PathVariable Integer id) {
        adminService.deleteActivity(id);
    }

    @DeleteMapping("/managers/{id}")
    public void deleteManager(@PathVariable Integer id) {
        adminService.deleteManager(id);
    }

    @GetMapping("/transactions")
    public ResponseEntity<?>
    getAllTransactions(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit) {
        return ResponseEntity.ok(adminService.getPageOfTransactions(offset, limit).getContent());
    }

    @GetMapping("/{id}/transactions")
    public ResponseEntity<?> getUserTransactionsBySenderId(@PathVariable Integer id) {
        return ResponseEntity.ok(adminService.getUserTransactionsBySenderId(id));
    }
}
