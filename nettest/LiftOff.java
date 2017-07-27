import java.util.concurrent.CountDownLatch;

public class LiftOff implements Runnable{
	protected int countDown = 10;
	private static int taskCount = 0;
	private final int id = taskCount++;
	public LiftOff() {
		// TODO Auto-generated constructor stub
	}
	public LiftOff(int countDown){
		this.countDown = countDown;
	}
	
	public String status(){
		return "#"+id + "(" +(countDown > 0 ? countDown : "Liftoff!") + ").";
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(countDown-- >0){
			System.out.println(status());
			Thread.yield();
		}
		
	}

}
