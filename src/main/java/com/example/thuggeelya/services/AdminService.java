package com.example.thuggeelya.services;

import com.example.thuggeelya.data.*;
import com.example.thuggeelya.data.security.LoginFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AdminService {

    private final LoginFormRepository loginFormRepository;
    private final ActivityRepository activityRepository;
    private final ManagerRepository managerRepository;
    private final TransactionRepository transactionRepository;
    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;
    private final WaletRepository waletRepository;

    @Autowired
    public AdminService(LoginFormRepository loginFormRepository, ActivityRepository activityRepository,
                        ManagerRepository managerRepository, TransactionRepository transactionRepository,
                        UserRoleRepository roleRepository, UserRepository userRepository, WaletRepository waletRepository) {
        this.loginFormRepository = loginFormRepository;
        this.activityRepository = activityRepository;
        this.managerRepository = managerRepository;
        this.transactionRepository = transactionRepository;
        this.userRoleRepository = roleRepository;
        this.userRepository = userRepository;
        this.waletRepository = waletRepository;
    }

    public LoginForm addNewLoginForm(LoginForm loginForm) {
        User user = userRepository.save(new User("", "", "", "", "",
                0, 1, new LinkedHashSet<>()));
        loginForm.setIduser(user.getIduser());
        LoginForm newLoginForm = loginFormRepository.save(loginForm);
        System.out.println(loginForm + " saved as " + newLoginForm);
        return newLoginForm;
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

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer iduser) {
        User user = userRepository.findByIduser(iduser).orElseThrow(NoSuchElementException::new);
        System.out.println("got user " + user);
        return user;
    }

    public List<Transaction> getUserTransactionsBySenderId(Integer iduser) {
        return transactionRepository.findAllBySender_Iduser(iduser);
    }

    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction addNewTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Walet addNewWalet(Walet walet, Integer iduser) {
        Walet newWalet = waletRepository.save(walet);
        User user = userRepository.findByIduser(iduser).get();
        user.setIdwalet(newWalet);
        userRepository.save(user);
        return newWalet;
    }
}
