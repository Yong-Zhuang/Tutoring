import java.util.*;

public class AutoSaver implements Runnable{
	private File file;
	public AutoSaver(File file)
	{
		this.file=file;
	}
	public void run(){
		try{
			this.file.save();
			Thread.sleep(2000);
		} catch (InterruptedException e){
			System.out.println(e.getMessage());}
	}
}
