package service;

public interface BankService {

    void signup();   // handles BOTH new + existing
    void checkBalance(int accNo);
    void deposit(int accNo);
    void withdraw(int accNo);
    void transfer(int fromAccNo);

    void viewAllAccounts(); // admin
}

