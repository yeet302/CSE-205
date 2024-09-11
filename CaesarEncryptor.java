import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class CaesarEncryptor {  
   public static void main(String[] args) {  
      Scanner in = new Scanner(System.in);
      System.out.print("Input file: ");
      String inFile = in.next();
      System.out.print("Output file: ");
      String outFile = in.next();
      System.out.print("Encryption key: ");
      int key = in.nextInt();
      in.close();
                           
      OutputStream outStream;
      InputStream inStream;

      try {  
         CaesarCipherBin cipher = new CaesarCipherBin(key);
         outStream = new FileOutputStream(outFile);
         inStream = new FileInputStream(inFile);
         cipher.encryptStream(inStream, outStream);
         outStream.close();
         inStream.close();
      }
      catch (IOException exception) {  
         System.out.println("Error processing file: " + exception);
      }
   }
}

