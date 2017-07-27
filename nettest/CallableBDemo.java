import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.lang.model.type.ExecutableType;

public class CallableBDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executorService = Executors.newCachedThreadPool();
		ArrayList<Future<String>> results = new ArrayList<Future<String>>();
		for(int i = 0;i<5;i++){
			results.add(executorService.submit(new TaskWithResult(i)));
		}for(Future<String> future :results){
			try{
				if(future.isDone())System.out.println(future.get());
			}catch (InterruptedException e) {
				// TODO: handle exception
				System.err.println(e);
				return;
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				System.err.println(e);
			}finally {
				executorService.shutdown();
			}
		}

	}

}
