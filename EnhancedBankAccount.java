public class EnhancedBankAccount {
	private int accountNumber;
	private double balance;

	public EnhancedBankAccount(int anAccountNumber) {
		accountNumber = anAccountNumber;
		balance = 0;
	}

	public EnhancedBankAccount(int anAccountNumber, double initialBalance) {
		accountNumber = anAccountNumber;
		balance = initialBalance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void deposit(double amount) {
		double newBalance = balance + amount;
		balance = newBalance;
	}

	public void withdraw(double amount) {
		double newBalance = balance - amount;
		balance = newBalance;
	}

	public double getBalance() {
		return balance;
	}
}
