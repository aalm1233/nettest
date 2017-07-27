import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class TextFile extends ArrayList<String>{
	public static String read(String filename) {
		StringBuilder sb = new StringBuilder();
		try{
			BufferedReader in = new BufferedReader(new FileReader(new File(filename).getAbsoluteFile()));
			try{
				String s;
				while((s = in.readLine())!=null){
					sb.append(s);
					sb.append("\n");
					
				}
			}finally {
				in.close();
			}
		}catch (IOException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		return sb.toString();
	}
	public static void write(String filename,String text){
		try{
			PrintWriter out = new PrintWriter(new File(filename).getAbsoluteFile());
			try{
				out.print(text);
			}finally {
				out.close();
			}
		}catch (IOException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	public TextFile(String filename , String splitter) {
		// TODO Auto-generated constructor stub
		super(Arrays.asList(read(filename).split(splitter)));
		if(get(0).equals("")){
			remove(0);
		}
	}
	public TextFile(String filename) {
		// TODO Auto-generated constructor stub
		this(filename,"\n");
	}
	public void write(String filename){
		try{
			PrintWriter out = new PrintWriter(new File(filename).getAbsoluteFile());
			try{
				for(String item:this){
					out.println(item);
				}
			}finally {
					out.close();
				}
		}catch (IOException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
}
