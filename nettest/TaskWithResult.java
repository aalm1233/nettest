import java.util.concurrent.Callable;

public class TaskWithResult implements Callable<String>{
	private int id;
	public TaskWithResult(int id) {
		// TODO Auto-generated constructor stub
		this.id = id;
		
	}

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return "reslut of TaskWithResult "+ this.id;
	}

}
