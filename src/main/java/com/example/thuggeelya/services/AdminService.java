package com.example.thuggeelya.services;

import com.example.thuggeelya.data.*;
import com.example.thuggeelya.data.security.LoginFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final LoginFormRepository loginFormRepository;
    private final ActivityRepository activityRepository;
    private final ManagerRepository managerRepository;
    private final TransactionRepository transactionRepository;
    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;

    @Autowired
    public AdminService(LoginFormRepository loginFormRepository, ActivityRepository activityRepository,
                        ManagerRepository managerRepository, TransactionRepository transactionRepository,
                        UserRoleRepository roleRepository, UserRepository userRepository) {
        this.loginFormRepository = loginFormRepository;
        this.activityRepository = activityRepository;
        this.managerRepository = managerRepository;
        this.transactionRepository = transactionRepository;
        this.userRoleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    public LoginForm addNewLoginForm(LoginForm loginForm) {
        LoginForm newLoginForm = loginFormRepository.save(loginForm);
        userRoleRepository.save(new UserRole(new UserRoleKey(newLoginForm.getIduser(), RoleEnum.ROLE_USER.getId())));
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

    public List<Transaction> getUserTransactionsBySenderId(Integer iduser) {
        return transactionRepository.findAllBySender_Iduser(iduser);
    }

    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction addNewTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}
