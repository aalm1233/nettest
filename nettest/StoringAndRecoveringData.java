import java.io.*;

public class StoringAndRecoveringData {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Data.txt")));
		out.writeDouble(3.1415);
		out.writeUTF("That is pi");
		out.close();
		DataInputStream in = new DataInputStream( new BufferedInputStream(new FileInputStream("Data.txt")));
		System.out.println(in.readDouble());
	}

}
