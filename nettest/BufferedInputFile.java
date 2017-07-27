import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedInputFile {
	private String bif;
	public BufferedInputFile(final String filename) throws IOException {
		// TODO Auto-generated constructor stub
		bif = read(filename);
	}

	public static String read(String filename) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String s;
		StringBuffer sb = new StringBuffer();
		while((s = br.readLine())!=null){
			sb.append(s+"\n");
		}
		br.close();
		return sb.toString();
		
	}

	public String getBif() {
		return this.bif;
	}

}
