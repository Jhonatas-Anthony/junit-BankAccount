package Class;

public class BankAccountClass {
    private int accountNumber;
    public double value;
    private String accountType;
    
    public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

    public BankAccountClass() {}

    public BankAccountClass(int accountNumber, double value, String accountType) {
        this.accountNumber = accountNumber;
        this.value = value;
        this.accountType = accountType;
    }

    public void deposit(double amount) {
        // Add the deposited amount to the monetary value
        this.value += amount;
    }

    public void withdraw(double amount) {
        // Subtract the withdrawn amount from the monetary value
        this.value -= amount;
    }

    public void transfer(BankAccountClass recipientAccount, double amount) {
        // Withdraw the amount from the current account and deposit it into the recipient's account
        this.withdraw(amount);
        recipientAccount.deposit(amount);
    }
}
