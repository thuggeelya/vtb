package com.example.thuggeelya.services;

import com.example.thuggeelya.data.*;
import com.example.thuggeelya.data.security.LoginFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final LoginFormRepository loginFormRepository;
    private final ActivityRepository activityRepository;
    private final ManagerRepository managerRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public AdminService(LoginFormRepository loginFormRepository, ActivityRepository activityRepository, ManagerRepository managerRepository, TransactionRepository transactionRepository) {
        this.loginFormRepository = loginFormRepository;
        this.activityRepository = activityRepository;
        this.managerRepository = managerRepository;
        this.transactionRepository = transactionRepository;
    }

    public LoginForm addNewLoginForm(LoginForm loginForm) {
        return loginFormRepository.save(loginForm);
    }

    public Activity addNewActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    public Manager addNewManager(Manager manager) {
        return managerRepository.save(manager);
    }

    public void deleteLoginForm(Integer id) {
        loginFormRepository.deleteById(id);
    }

    public void deleteActivity(Integer id) {
        activityRepository.deleteById(id);
    }

    public void deleteManager(Integer id) {
        managerRepository.deleteById(id);
    }

    public List<Transaction> getUserTransactionsBySenderId(Integer iduser) {
        return transactionRepository.findAllBySender_Iduser(iduser);
    }

    public Page<Transaction> getPageOfTransactions(Integer offset, Integer limit) {
        Pageable nextPage = PageRequest.of(offset, limit);
        return transactionRepository.findAll(nextPage);
    }

    public Transaction addNewTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}
