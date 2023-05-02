
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
	public static void main(String[] args)  {
		
		ArrayList<Thread> threads= new  ArrayList<Thread>();
		
		//init_filesystem
		FileSystem fs = FileSystem.getFileSystem();	
		Date date = new Date();
		fs.root = new Directory(null, "root", "CS680", date);
		Directory sys = new Directory(fs.root, "system", "Sue", date);
		File a = new File(sys, "a.txt", "Jack", date, 50);
		File b = new File(sys, "b.doc", "Mary", date, 51);
		File c = new File(sys, "c.php", "Tom", date, 55);
		Directory home = new Directory(fs.root, "home", "Jane", date);
		File d = new File(home, "d.txt", "Cart", date, 65);
		Link x = new Link(home, "x", "Peter", date,sys);
		Directory pictures = new Directory(home, "pictures", "Jim", date);
		File e = new File(pictures, "e.txt", "Joe", date, 71);
		File f = new File(pictures, "f.html", "John", date, 85);
		Link y = new Link(pictures, "y", "Lame", date,e);
		//fs.showAllElements();
		System.out.println("root");
		System.out.println("sys						|		home");
		System.out.println("a.txt	b.doc	c.php				|		d.txt	x(link_sys)	 pictures");
		System.out.println("                                                    					 e.txt	f.html	y(link_e.txt)");
		
		
		//init_threads
		System.out.println("Create 2 threads for file crawler, one crawls the folder sys, which includes file a,b,c, the other crawls the folder home, which has file d,e,f.");
		FileQueue fq = new FileQueue(3);
		Thread thread = null;
		ArrayList<FileCrawler> fcList=new ArrayList<FileCrawler>();
		FileCrawler fc1 = new FileCrawler(sys,fq);
		fcList.add(fc1);
		thread = new Thread(fc1);
		thread.start();
		threads.add(thread);
		FileCrawler fc2 =new FileCrawler(home,fq);
		fcList.add(fc2);
		thread = new Thread(fc2);
		thread.start();
		threads.add(thread);		

		System.out.println("Create 4 threads for file indexer.");
		ArrayList<FileIndexer> fiList=new ArrayList<FileIndexer>();
		for(int i = 0;i<4;i++)
		{
			FileIndexer fi = new FileIndexer(fq);
			fiList.add(fi);
			thread = new Thread(fi);
			thread.start();
			threads.add(thread);		
		}
		try{
			System.out.println("Main thread sleep 5 seconds!");
			Thread.sleep(5000);
		}catch(InterruptedException error){
			System.out.println("err1");
		}
		System.out.println("Start setting done on every thread.");		
		fcList.forEach((FileCrawler fc)->{fc.setDone();});
		fiList.forEach((FileIndexer fi)->{fi.setDone();});
		System.out.println("Start interrupting every thread.");
		threads.forEach((Thread t)->{
			t.interrupt();			
		});
	}

}
