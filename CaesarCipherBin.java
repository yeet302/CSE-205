import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class CaesarCipherBin {
	private int key;

	public CaesarCipherBin(int aKey) {
		key = aKey;
	}

	public void encryptStream(InputStream in, OutputStream out) throws IOException {
		int next = in.read();
		while (next != -1) {
			int encrypted = encrypt(next);
			out.write(encrypted);
			next = in.read();
		}
	}

	public int encrypt(int b) {
		return (b + key) % 256;
	}
}