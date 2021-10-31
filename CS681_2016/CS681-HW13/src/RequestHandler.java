import java.nio.file.*;

public class RequestHandler implements Runnable {
	
	private AccessCounter ac;
	private Path path;
	
	public RequestHandler(AccessCounter ac, Path p) {
		this.ac = ac;
		this.path = p;
	}    
    public void run(){
		ac.increment(path);
		ac.getCount(path);
	}
}
