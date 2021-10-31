import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {

		ArrayList<Thread> threads = new ArrayList<Thread>();
	
		Path path1 = Paths.get("a.html");
		Path path2 = Paths.get("b.html");

		AccessCounter accesscounter = new AccessCounter();
		
		Thread thread;
		RequestHandler requesthandler1 = new RequestHandler(accesscounter, path1);
		RequestHandler requesthandler2 = new RequestHandler(accesscounter, path2);
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0) {
				thread = new Thread(requesthandler1);
				thread.start();
				threads.add(thread);
			} else {
				thread = new Thread(requesthandler2);
				thread.start();
				threads.add(thread);
			}
		}
		threads.forEach((Thread t) -> {
			try {
				t.join();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

}
