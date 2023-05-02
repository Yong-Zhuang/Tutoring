import java.nio.file.*;

public class RequestHandler implements Runnable {
	
	private FileCache fileCache;
	private AccessCounter accesscounter;
	private Path path;
	
	public RequestHandler(FileCache fileCache, AccessCounter accesscounter, Path path) { 	
		
		this.fileCache = fileCache;
		this.accesscounter = accesscounter;
		this.path = path;
	}
    
    public void run(){
		fileCache.fetch(path);
        accesscounter.increment(path);
		accesscounter.getCount(path);
	}
}
