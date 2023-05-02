
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		ArrayList<Thread> threads = new ArrayList<Thread>();
		ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
		Thread thread = null;
		int threhold = 5;
		// create paths
		Path path1 = Paths.get("a.html");
		Path path2 = Paths.get("b.html");
		Path path3 = Paths.get("c.html");
		Path path4 = Paths.get("d.html");
		Path path5 = Paths.get("e.html");
		Path path6 = Paths.get("f.html");
		Path path7 = Paths.get("g.html");
		AccessCounter accesscounter = new AccessCounter(lock);
		FileCache filecacheLRU = new FileCacheLRU(threhold,accesscounter, lock);
		FileCache filecacheLFU = new FileCacheLFU(threhold,accesscounter, lock);
		RequestHandler requesthandler1 = new RequestHandler(filecacheLRU, accesscounter, path1);
		RequestHandler requesthandler2 = new RequestHandler(filecacheLRU, accesscounter, path2);
		RequestHandler requesthandler3 = new RequestHandler(filecacheLRU, accesscounter, path3);
		RequestHandler requesthandler4 = new RequestHandler(filecacheLRU, accesscounter, path4);
		RequestHandler requesthandler5 = new RequestHandler(filecacheLFU, accesscounter, path5);
		RequestHandler requesthandler6 = new RequestHandler(filecacheLFU, accesscounter, path6);
		RequestHandler requesthandler7 = new RequestHandler(filecacheLFU, accesscounter, path7);

		for (int i = 0; i < 10; i++) {
			switch (i % 7) {
			case 1: {
				thread = new Thread(requesthandler1);
				thread.start();
				threads.add(thread);
				break;
			}
			case 2: {
				thread = new Thread(requesthandler2);
				thread.start();
				threads.add(thread);
				break;
			}
			case 3: {
				thread = new Thread(requesthandler3);
				thread.start();
				threads.add(thread);
				break;
			}
			case 4: {
				thread = new Thread(requesthandler4);
				thread.start();
				threads.add(thread);
				break;
			}
			case 5: {
				thread = new Thread(requesthandler5);
				thread.start();
				threads.add(thread);
				break;
			}
			case 6: {
				thread = new Thread(requesthandler6);
				thread.start();
				threads.add(thread);
				break;
			}
			case 0: {
				thread = new Thread(requesthandler7);
				thread.start();
				threads.add(thread);
				break;
			}
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
