import java.io.Serializable;

public class BankAccountSerial implements Serializable {  
   private int accountNumber;
   private double balance;

   public BankAccountSerial(int anAccountNumber) {   
      accountNumber = anAccountNumber;
      balance = 0;
   }

   public BankAccountSerial(int anAccountNumber, double initialBalance) {   
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