package com.example.thuggeelya.controllers;

import com.example.thuggeelya.data.*;
import com.example.thuggeelya.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

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

    @PostMapping(value = "/loginForms", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createUser(@RequestBody LoginForm loginForm) {
        System.out.println("got to create loginform: " + loginForm);
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
    public ResponseEntity<?> getAllTransactions() {
        return ResponseEntity.ok(adminService.getTransactions());
    }

    @CrossOrigin
    @GetMapping(value = "/users", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok(adminService.getUsers());
    }

    @GetMapping("/users/{id}/transactions")
    public ResponseEntity<?> getUserTransactionsBySenderId(@PathVariable Integer id) {
        return ResponseEntity.ok(adminService.getUserTransactionsBySenderId(id));
    }

    @PutMapping("/users/{id}/wallet/new")
    public ResponseEntity<?> createWalletTo(@RequestBody Walet walet, @PathVariable Integer id) {
        return ResponseEntity.ok(adminService.addNewWalet(walet, id));
    }

    @GetMapping("/users/{id}/wallet")
    public ResponseEntity<?> getUserWalet(@PathVariable Integer id) {
        return ResponseEntity.ok(adminService.getUserById(id).getIdwalet());
    }

    @PostMapping("/users/{id}/generate/nft/{count}")
    public ResponseEntity<?> generateNfts(@PathVariable("id") Integer id, @PathVariable("count") Integer count) {
        return ResponseEntity.ok(adminService.generateNfts(id, count));
    }
}
