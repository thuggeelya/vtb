package com.example.thuggeelya.controllers;

import com.example.thuggeelya.data.Transaction;
import com.example.thuggeelya.services.NFTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/nft")
public class NFTController {

    private final NFTService nftService;

    @Autowired
    public NFTController(NFTService nftService) {
        this.nftService = nftService;
    }

    @PostMapping
    public ResponseEntity<?> createTransaction(@RequestBody Transaction transaction) {
        Transaction newTransaction = nftService.saveTransaction(transaction);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(transaction.getIdtransaction()).toUri();
        return ResponseEntity.created(location).build();
    }
}
