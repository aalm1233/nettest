import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ThreadEchoServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			int i = 1;
			ServerSocket serverSocket = new ServerSocket(8189);
			Scanner scanner = new Scanner(System.in);
			while(!scanner.nextLine().equals("stop")){
				Socket incoming = serverSocket.accept();
				System.out.println("Spawning "+i);
				Runnable r = new ThreadEchoHandler(incoming);
				Thread t = new Thread(r);
				t.start();
				i++;
			}
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}

class ThreadEchoHandler implements Runnable {
	private Socket incoming;

	public ThreadEchoHandler(Socket i) {
		// TODO Auto-generated constructor stub
		this.incoming = i;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			try {
				InputStream inStream = incoming.getInputStream();
				OutputStream outStream = incoming.getOutputStream();

				Scanner in = new Scanner(inStream);
				PrintWriter out = new PrintWriter(outStream, true);

				out.println("Hello! Enter BYE to exit.");
				boolean done = false;
				while (!done && in.hasNext()) {
					String line = in.nextLine();
					out.println("Echo:" + line);
					if (line.trim().equals("BYE"))
						done = true;
				}
			} finally {
				incoming.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}