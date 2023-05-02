import java.util.ArrayList;

public class MCTest{
  public static void main(String[] args) throws Exception {
    ArrayList<Thread> threads = new ArrayList<Thread>();

    final long nTimes  = Long.parseLong(args[0]);
    final int nThread = Integer.parseInt(args[1]);

    for (int i = 0; i < nThread; i++) {
      Thread t = new Thread(
				()-> {int n = 25;
    		  		for (long j = 0; j < nTimes; j++) {
    		  			n *= 25;
    		  			System.out.println(Thread.currentThread().getName()+" result: " +n);
    		  		}
    		  });
      threads.add(t);
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
