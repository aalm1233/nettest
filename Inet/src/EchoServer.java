import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		try(ServerSocket serverSocket = new ServerSocket(8189)){
			try(Socket incoming = serverSocket.accept()){
				InputStream inStream = incoming.getInputStream();
				OutputStream outStream = incoming.getOutputStream();
				
				try(Scanner scanner = new Scanner(inStream)){
					PrintWriter pw = new PrintWriter(outStream, true);
					
					pw.println("Hello! Enter BYE to exit.");
					
					boolean done = false;
					while(!done&&scanner.hasNext()){
						String line =  scanner.nextLine();
						pw.println("Echo:"+line);
						if(line.trim().equals("BYE"))done = true;
					}
				}
			}
		}

	}

}
