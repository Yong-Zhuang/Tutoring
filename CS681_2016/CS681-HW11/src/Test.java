import java.util.ArrayList;
public class Test {
	public static void main(String[] args) {
		Guest g = new Guest();
		Thread thread1 = new Thread(g);
		Thread thread2 = new Thread(g);
		thread1.start();
		thread2.start();
		try{			
			thread1.join();
			thread2.join();
		} catch (InterruptedException e){
			System.out.println(e.getMessage());
		}
	}

}
