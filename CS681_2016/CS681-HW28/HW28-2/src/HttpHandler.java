import java.net.ServerSocket;
import java.net.Socket;

public class HttpHandler implements Runnable {
	private TinyHttpd httpServer;
	private Socket clientSocket;
	private ServerSocket serverSocket;
	private FileCache fileCache;
	private AccessCounter accesscounter;

	public HttpHandler(TinyHttpd httpServer, Socket clientSocket, ServerSocket serverSocket,AccessCounter accesscounter,FileCache filecache) {
		this.httpServer = httpServer;
		this.clientSocket = clientSocket;
		this.serverSocket = serverSocket;
		this.fileCache = filecache;
		this.accesscounter = accesscounter;
	}

	public void run() {
		try {

			HttpExchange ex = new HttpExchange(clientSocket, serverSocket,accesscounter,fileCache);

			try {
				if(this.httpServer.getAuthenticator().authenticate(ex))
				ex.makeSuccessfulResponse();
			}
			catch (Exception e) {
			}
		} finally {
		}
	}

}