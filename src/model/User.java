package model;

public class User {

	private String username;
    private String password;
    private String role;
    private int accountNumber;

    public User(String username, String password,
                String role, int accountNumber) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.accountNumber = accountNumber;
    }

    public String getRole()
    { 
    	return role; 
    }
    public int getAccountNumber()
    { 
    	return accountNumber; 
    }
	
}