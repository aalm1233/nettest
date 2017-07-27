
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static String getResult(long ulDataInput){
		StringBuffer sb = new StringBuffer();
		while(ulDataInput!=1){
			for(int i = 2;i<ulDataInput;i++){
				if(ulDataInput %i == 0){
					ulDataInput/=i;
					sb.append(i+" ");
					break;
				}
			}
		}
		return sb.toString();
		
	}
	public static void main(String[] args) throws IOException {
	}
	

}

