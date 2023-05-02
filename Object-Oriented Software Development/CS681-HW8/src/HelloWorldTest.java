import java.util.Date;

public class HelloWorldTest{

	public static void main(String[] args){
		String greeting ="Hello World";
		Thread thread = new Thread(()->{
			try{
				for( int i=0; i<10; i++ ){
					Date now = new Date();
					System.out.println(now + " " + greeting);
					Thread.sleep(1000);
				}
			}
			catch(InterruptedException ex){}
		});
		thread.start();
		try{			
			thread.join();
		} catch (InterruptedException e){
			System.out.println(e.getMessage());
		}
	}

}
