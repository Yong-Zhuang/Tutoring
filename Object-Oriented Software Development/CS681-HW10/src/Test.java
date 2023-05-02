import java.util.ArrayList;
public class Test {
	public static void main(String[] args) {
		File f = new File();		
		Editor e = new Editor(f);
		AutoSaver as = new AutoSaver(f);
		Thread thread1 = new Thread(e);
		Thread thread2 = new Thread(as);
		thread1.start();
		thread2.start();
		try{			
			thread1.join();
			thread2.join();
		} catch (InterruptedException es){
			System.out.println(es.getMessage());
		}
	}

}
