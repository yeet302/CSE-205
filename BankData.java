import java.io.IOException;
import java.io.RandomAccessFile;

public class BankData implements AutoCloseable {
	private RandomAccessFile file;

	public static final int INT_SIZE = 4;
	public static final int DOUBLE_SIZE = 8;
	public static final int RECORD_SIZE = INT_SIZE + DOUBLE_SIZE;

	public BankData() {
		file = null;
	}

	public void open(String filename) throws IOException {
		if (file != null) {
			file.close();
		}
		file = new RandomAccessFile(filename, "rw");
	}

	public int size() throws IOException {
		return (int) (file.length() / RECORD_SIZE);
	}

	public void close() throws IOException {
		if (file != null) {
			file.close();
		}
		file = null;
	}

	public EnhancedBankAccount read(int n) throws IOException {
		file.seek(n * RECORD_SIZE);
		int accountNumber = file.readInt();
		double balance = file.readDouble();
		return new EnhancedBankAccount(accountNumber, balance);
	}

	public int find(int accountNumber) throws IOException {
		for (int i = 0; i < size(); i++) {
			file.seek(i * RECORD_SIZE);
			int a = file.readInt();
			if (a == accountNumber) {
				return i;
			}
		}
		return -1;
	}

	public void write(int n, EnhancedBankAccount account) throws IOException {
		file.seek(n * RECORD_SIZE);
		file.writeInt(account.getAccountNumber());
		file.writeDouble(account.getBalance());
	}
	
	public void report() throws IOException {
		System.out.println("-------------------\n   Bank Accounts\n-------------------");
		
		for (int i = 0; i < size(); i++) {
			file.seek(i * RECORD_SIZE);
			int accountNum = file.readInt();
			double balance = file.readDouble();
			System.out.printf("%6d : $%8.2f\n", accountNum, balance);
		}
		
		System.out.println("-------------------\n");
	}
}
