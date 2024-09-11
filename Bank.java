import java.io.Serializable;
import java.util.ArrayList;

public class Bank implements Serializable {   
   private ArrayList<BankAccountSerial> accounts;

   public Bank() {
      accounts = new ArrayList<>();
   }

   public void addAccount(BankAccountSerial a) {
      accounts.add(a);
   }
   
   public BankAccountSerial find(int accountNumber) {
      for (BankAccountSerial a : accounts) {
         if (a.getAccountNumber() == accountNumber) {
            return a;
         }
      } 
      return null;
   }
}