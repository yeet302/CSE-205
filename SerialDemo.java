import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerialDemo {
   public static void main(String[] args)
         throws IOException, ClassNotFoundException {     
      Bank firstBankOfJava;
      
      File f = new File("javabank.dat");
      if (f.exists()) {
         try (ObjectInputStream in = new ObjectInputStream(
               new FileInputStream(f))) {
            firstBankOfJava = (Bank) in.readObject();
         }
      }
      else {
         firstBankOfJava = new Bank();
         firstBankOfJava.addAccount(new BankAccountSerial(1001, 20000));
         firstBankOfJava.addAccount(new BankAccountSerial(1015, 10000));
      }

      BankAccountSerial a = firstBankOfJava.find(1001);
      a.deposit(100);
      System.out.println(a.getAccountNumber() + ": " + a.getBalance());
      a = firstBankOfJava.find(1015);
      System.out.println(a.getAccountNumber() + ": " + a.getBalance());

      try (ObjectOutputStream out = new ObjectOutputStream(
            new FileOutputStream(f))) {
         out.writeObject(firstBankOfJava);
      }
   }
}