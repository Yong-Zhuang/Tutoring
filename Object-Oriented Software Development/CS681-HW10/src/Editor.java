import java.util.*;

public class Editor implements Runnable{
	private File file;
	public Editor(File file)
	{
		this.file=file;
	}
	public void run(){
		try{
			this.file.change();
			this.file.save();
			Thread.sleep(1000);
		} catch (InterruptedException e){
			System.out.println(e.getMessage());}
	}
}
