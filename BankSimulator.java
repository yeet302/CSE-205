import java.io.IOException;
import java.util.Scanner;

public class BankSimulator {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		BankData data = new BankData();
		data.open("bank.dat");
		data.report();
		
		boolean done = false;
		while (!done) {
			System.out.print("Account number: ");
			int accountNumber = in.nextInt();
			System.out.print("Amount to deposit: ");
			double amount = in.nextDouble();

			int position = data.find(accountNumber);
			EnhancedBankAccount account;
			if (position >= 0) {
				account = data.read(position);
				account.deposit(amount);
				System.out.println("New balance: " + account.getBalance());
			} else {
				account = new EnhancedBankAccount(accountNumber, amount);
				position = data.size();
				System.out.println("Adding new account.");
			}
			data.write(position, account);

			System.out.print("Done? (Y/N) ");
			String input = in.next();
			if (input.equalsIgnoreCase("Y")) {
				done = true;
			}
		}
		in.close();
		data.close();
	}
}
