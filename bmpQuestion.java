import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class bmpQuestion {

	public static void main(String[] args) {
		String file_name;
		if(args.length != 1)
			System.out.println("Enter your file name");
		else
			file_name = args[0];
		try(RandomAccessFile fa = new RandomAccessFile(file_name,"rw")){
			int offsetv = 10;
			fa.seek(offsetv);
			int power_2 = (int)Math.pow(256,2);
			int power_3 = (int)Math.pow(256,3);
			int first_Pix = fa.read() + 256*fa.read() + power_2*fa.read() + power_3 * fa.read();
			fa.seek(18);
			int widthv = fa.read() + 256*fa.read() + power_2*fa.read() + power_3 * fa.read();
			int heightv = fa.read() + 256*fa.read() + power_2*fa.read() + power_3 * fa.read();
			int numPadding_Bytes = widthv % 4;
			fa.seek(first_Pix);
			int neg_Red, neg_Blue, neg_Green;
				for(int row=0; row<heightv; row++) {
					neg_Red = 255 - fa.read();
					neg_Green = 255 - fa.read();
					neg_Blue = 255 - fa.read();
					fa.seek(fa.getFilePointer()-3);
					fa.write(neg_Red);
					fa.write(neg_Green);
					fa.write(neg_Blue);				
				}
			fa.seek(fa.getFilePointer()+numPadding_Bytes);			
			}
			fa.close();
			catch(FileNotFoundException e) {
				System.out.println(e);
			catch(IOException e) {
				System.out.println(e);
			}
		}
	}
}
