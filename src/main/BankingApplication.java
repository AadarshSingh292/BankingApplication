package main;

import java.util.Scanner;

import dao.UserDao;
import model.User;
import service.BankService;
import service.BankServiceImpl;

public class BankingApplication{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UserDao userDAO = new UserDao();
        BankService service = new BankServiceImpl();

        int mainChoice;

        do {
            System.out.println("\n===== BANK APPLICATION =====");
            System.out.println("1. Login");
            System.out.println("2. Sign Up");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            mainChoice = sc.nextInt();

            switch (mainChoice) {

                // ================= LOGIN =================
                case 1:
                    System.out.print("Enter username: ");
                    String username = sc.next();

                    System.out.print("Enter password: ");
                    String password = sc.next();

                    User user = userDAO.login(username, password);

                    if (user == null) {
                        System.out.println("Invalid username or password");
                        break;
                    }

                    // -------- ADMIN MENU --------
                    if (user.getRole().equalsIgnoreCase("ADMIN")) {
                        System.out.println("\nWelcome ADMIN");

                        int adminChoice;
                        do {
                            System.out.println("\n1. View All Accounts");
                            System.out.println("2. Logout");
                            System.out.print("Enter choice: ");
                            adminChoice = sc.nextInt();

                            switch (adminChoice) {
                                case 1:
                                    service.viewAllAccounts();
                                    break;
                                case 2:
                                    System.out.println("Admin logged out");
                                    break;
                                default:
                                    System.out.println("Invalid choice");
                            }
                        } while (adminChoice != 2);

                    }
                    // -------- USER MENU --------
                    else {
                        System.out.println("\nWelcome USER");

                        int userChoice;
                        do {
                            System.out.println("\n1. Check Balance");
                            System.out.println("2. Deposit");
                            System.out.println("3. Withdraw");
                            System.out.println("4. Transfer");
                            System.out.println("5. Logout");
                            System.out.print("Enter choice: ");
                            userChoice = sc.nextInt();

                            switch (userChoice) {
                                case 1:
                                    service.checkBalance(user.getAccountNumber());
                                    break;
                                case 2:
                                    service.deposit(user.getAccountNumber());
                                    break;
                                case 3:
                                    service.withdraw(user.getAccountNumber());
                                    break;
                                case 4:
                                    service.transfer(user.getAccountNumber());
                                    break;
                                case 5:
                                    System.out.println("User logged out");
                                    break;
                                default:
                                    System.out.println("Invalid choice");
                            }
                        } while (userChoice != 5);
                    }
                    break;

                // ================= SIGNUP =================
                case 2:
                    service.signup();
                    break;

                case 3:
                    System.out.println("Thank you for using Bank Application");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (mainChoice != 3);

        sc.close();
    }
}
