import java.util.ArrayList;
public class Test {
	public static void main(String[] args){
		ArrayList<Thread> threads = new ArrayList<Thread>();
		for (int i=0;i<10;i++)
		{
			Thread t =new Thread(new CallSingleton());
			t.start();
		}
		threads.forEach((Thread t)->{try {
			t.join();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}});
	}
}