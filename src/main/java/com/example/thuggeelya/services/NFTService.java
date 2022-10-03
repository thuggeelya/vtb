package com.example.thuggeelya.services;

import com.example.thuggeelya.data.Transaction;
import com.example.thuggeelya.data.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NFTService {

    private TransactionRepository transactionRepository;

    @Autowired
    public NFTService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Page<Transaction> getPageOfTransactions(Integer offset, Integer limit) {
        Pageable nextPage = PageRequest.of(offset, limit);
        return transactionRepository.findAll(nextPage);
    }

    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}
