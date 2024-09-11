import java.util.Scanner;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.InputMismatchException;


public class BMPEditor {
	
	private static int littleToBig(int v) {
		int num;
		num = (v >>> 24)+((v & 0x00ff0000)>>>8)+((v & 0x0000ff00)<<8)+(v<<24);		
		return num;
	}

	public static void main(String[] args){
		try{
		Scanner in = new Scanner(System.in);
		System.out.println("Sepia-o-Matic - Jongyoun Woo\n");
		System.out.println("Warning: Your file will be modified !");
		System.out.print("Filename: ");
		String inputFileName = in.nextLine(); 
		File inputFile = new File(inputFileName);
		RandomAccessFile f = new RandomAccessFile(inputFile,"rw");
			
		
		
		int headerInfo1 = f.read();	
		int headerInfo2 = f.read();
		String headerInfo = Integer.toHexString(headerInfo1)+Integer.toHexString(headerInfo2);
		if(headerInfo1 != 66 || headerInfo2 !=77) {
			throw new FileNotFoundException("BMP file not found");
		}
		System.out.println("\nFile");
		System.out.printf("%20s: 0x%-4s (BMP File)\n","HeaderField",headerInfo);
		
		f.seek(2);
		int size = littleToBig(f.readInt());
		System.out.printf("%20s: %,-10dbytes\n","Size",size);
		
		f.seek(6);
		int reserve_1 = f.readByte();
		System.out.printf("%20s: 0x%02d\n","Reserve-1",reserve_1);
		
		f.seek(8);
		int reserve_2 = f.readByte();
		System.out.printf("%20s: 0x%02d\n","Reserve-2",reserve_2);
		
		f.seek(10);
		int offset = littleToBig(f.readInt());		
		System.out.printf("%20s: %-10d\n","Offset",offset);
		
		System.out.println("\nDIB");
		f.seek(14);
		int dibHeaderSize = littleToBig(f.readInt());		
		System.out.printf("%20s: %02d bytes\n","dibHeaderSize",dibHeaderSize);
		
		f.seek(18);		
		int width = littleToBig(f.readInt());
		System.out.printf("%20s: %,2d pixels\n","Picture Width",width);
		
		f.seek(22);
		int height = littleToBig(f.readInt());
		System.out.printf("%20s: %,2d pixels\n","Picture Height",height);
		
		f.seek(26);
		int numColorPlanes = f.readShort();		
		System.out.printf("%20s: %2d\n","# Color Planes",numColorPlanes);
		
		int colorDepth = f.readShort();
		System.out.printf("%20s: %,d colors\n","Color Depth",colorDepth);
		
		int compression = f.readInt();
		System.out.printf("%20s: %,d\n","Compression",compression);
		
		int imageSize = f.readInt();
		System.out.printf("%20s: %,d pixels\n","Image Size",imageSize);
		
		int hResolution = littleToBig(f.readInt());
		System.out.printf("%20s: %,d pixels/meter\n","Horiz. Res.",hResolution);

		int vResolution = littleToBig(f.readInt());
		System.out.printf("%20s: %,d pixels/meter\n","Vert. Res.",vResolution);
		
		int colorsInPalette = f.readInt();
		System.out.printf("%20s: %,d\n","Colors in Palette",colorsInPalette);
		
		int importantColors = f.readInt();
		System.out.printf("%20s: %,d\n","Important Colors",importantColors);
		for(int j=0; j<height;j++) {
		for(int i=0; i<width;i++) {
			int b = f.readByte();
			int g = f.readByte();
			int r = f.readByte();
			double newRed = 0.393*r + 0.769*g+0.189*b;
			if(newRed > 255) newRed = 255;
			double newGreen = 0.349*r + 0.686*g+0.168*b;
			if(newGreen > 255) newGreen = 255;
			double newBlue = 0.272*r + 0.534*g+0.131*b;
			if(newBlue > 255) newBlue = 255;
			f.seek(f.getFilePointer()-3);
			f.writeByte((byte) newBlue);
			f.writeByte((byte) newGreen);
			f.writeByte((byte) newRed);
		}
		}
		f.close();
		}	
//		catch(FileNotFoundException fnfe) {
//			System.out.println("File not found");
//		}
		catch(InputMismatchException ime) {
			System.out.println("Input Mismatch");
		}
		catch(IOException e) {
			System.out.println(e);
		}
		catch(ClassCastException e) {
			System.out.println(e);
		}
				
		}
}
