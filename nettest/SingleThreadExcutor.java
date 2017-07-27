import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExcutor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		for(int i = 0;i<5;i++){
			executorService.execute(new LiftOff());
		}
		executorService.shutdown();

	}

}
