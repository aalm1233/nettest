import java.io.IOException;
import java.io.RandomAccessFile;

public class UsingRandomAccessFile {
	static String file = "rtest.dat";
	static void display() throws IOException{
		RandomAccessFile raf = new RandomAccessFile(file, "r");
		for(int i = 0;i<7;i++){
			System.out.println("Value" + i + " :"+ raf.readDouble());
		}
		System.out.println(raf.readUTF());
		raf.close();
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		RandomAccessFile rf = new RandomAccessFile(file, "rw");
		for(int i = 0;i<7;i++){
			rf.writeDouble(i*1.414);
		}
		rf.writeUTF("The end of file");
		rf.close();
		display();
		rf = new RandomAccessFile(file, "rw");
		rf.seek(5*8);
		rf.writeDouble(45612.23);
		rf.close();
		display();
	}

}
