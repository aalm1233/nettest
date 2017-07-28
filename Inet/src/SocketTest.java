import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class SocketTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try (Socket socket = new Socket("time-A.timefreq.bldrdoc.gov", 13)){
			InputStream is = socket.getInputStream();
			Scanner sc = new Scanner(is);
			while(sc.hasNext()){
				String line = sc.nextLine();
				System.out.println(line);
			}
		}
	}

}
