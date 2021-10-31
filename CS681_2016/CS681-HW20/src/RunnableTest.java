
public class RunnableTest implements Runnable{
	private String output;
	
	public RunnableTest(String str){
		this.output = str;
	}

	public void run(){
		System.out.println("Thread: "+ Thread.currentThread().getId() +" output: "+output);
	}

}