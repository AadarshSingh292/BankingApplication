package model;

public class Customer {

	private String name;
    private String email;
    private String contact;
    private String aadhar;
    private int accountNumber;

    public Customer(String name, String email, String contact,
                    String aadhar, int accountNumber) {
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.aadhar = aadhar;
        this.accountNumber = accountNumber;
    }

    public String getAadhar() { return aadhar; }
    public int getAccountNumber() { return accountNumber; }
	
}
