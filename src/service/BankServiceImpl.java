package service;

import java.util.Random;
import java.util.Scanner;

import dao.AccountDao;
import dao.CustomerDao;
import dao.UserDao;

public class BankServiceImpl implements BankService {

    private AccountDao accountDAO = new AccountDao();
    private UserDao userDAO = new UserDao();
    private CustomerDao customerDAO = new CustomerDao();

    private Scanner sc = new Scanner(System.in);

    // ================= SIGNUP =================
    @Override
    public void signup() {

        System.out.println("\n1. New Account Signup");
        System.out.println("2. Register Existing Account for Login");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        // ================= REGISTER EXISTING ACCOUNT =================
        if (choice == 2) {

            System.out.print("Enter existing account number: ");
            int accNo = sc.nextInt();

            if (!accountDAO.accountExists(accNo)) {
                System.out.println("Account number does not exist.");
                return;
            }

            if (userDAO.userExistsForAccount(accNo)) {
                System.out.println("Login already exists for this account.");
                return;
            }

            System.out.print("Enter username: ");
            String username = sc.next();

            System.out.print("Enter password: ");
            String password = sc.next();

            userDAO.createUser(username, password, accNo);
            System.out.println("Login created successfully for existing account.");
            return;
        }

        // ================= NEW ACCOUNT SIGNUP =================
        sc.nextLine(); // clear buffer

        System.out.print("Enter full name: ");
        String name = sc.nextLine();

        System.out.print("Enter email: ");
        String email = sc.next();

        System.out.print("Enter contact number: ");
        String contact = sc.next();

        System.out.print("Enter Aadhaar number: ");
        String aadhar = sc.next();

        // generate account number
        int accNo;
        Random r = new Random();
        do {
            accNo = 9000 + r.nextInt(1000);
        } while (accountDAO.accountExists(accNo));

        // NOW ask for login credentials
        System.out.print("Create username: ");
        String username = sc.next();

        System.out.print("Create password: ");
        String password = sc.next();

        // insert into all tables
        accountDAO.createAccount(accNo);
        userDAO.createUser(username, password, accNo);
        customerDAO.insertCustomer(name, email, contact, aadhar, accNo);

        System.out.println("Account created successfully!");
        System.out.println("Your Account Number: " + accNo);
    }


    // ================= CHECK BALANCE =================
    @Override
    public void checkBalance(int accNo) {
        double balance = accountDAO.getBalance(accNo);
        System.out.println("Balance: " + balance);
    }

    // ================= DEPOSIT =================
    @Override
    public void deposit(int accNo) {
        System.out.print("Enter amount to deposit: ");
        double amt = sc.nextDouble();

        if (amt <= 0) {
            System.out.println("Invalid amount");
            return;
        }

        double bal = accountDAO.getBalance(accNo);
        accountDAO.updateBalance(accNo, bal + amt);

        System.out.println("Deposit successful");
    }

    // ================= WITHDRAW =================
    @Override
    public void withdraw(int accNo) {
        System.out.print("Enter amount to withdraw: ");
        double amt = sc.nextDouble();

        if (amt <= 0) {
            System.out.println("Invalid amount");
            return;
        }

        double bal = accountDAO.getBalance(accNo);
        if (bal < amt) {
            System.out.println("Insufficient balance");
            return;
        }

        accountDAO.updateBalance(accNo, bal - amt);
        System.out.println("Withdrawal successful");
    }

    // ================= TRANSFER =================
    @Override
    public void transfer(int fromAccNo) {
        System.out.print("Enter receiver account number: ");
        int toAcc = sc.nextInt();

        if (!accountDAO.accountExists(toAcc)) {
            System.out.println("Receiver account not found");
            return;
        }

        System.out.print("Enter amount to transfer: ");
        double amt = sc.nextDouble();

        if (amt <= 0) {
            System.out.println("Invalid amount");
            return;
        }

        double senderBal = accountDAO.getBalance(fromAccNo);
        if (senderBal < amt) {
            System.out.println("Insufficient balance");
            return;
        }

        accountDAO.updateBalance(fromAccNo, senderBal - amt);
        accountDAO.updateBalance(toAcc,
                accountDAO.getBalance(toAcc) + amt);

        System.out.println("Transfer successful");
    }

    // ================= ADMIN =================
    @Override
    public void viewAllAccounts() {
        accountDAO.viewAllAccounts();
    }
}
