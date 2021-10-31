import java.net.ServerSocket;
import java.net.Socket;

public class HttpHandler implements Runnable {
	private TinyHttpd httpServer;
	private Socket clientSocket;
	private ServerSocket serverSocket;
	private AccessCounter accesscounter;

	public HttpHandler(TinyHttpd httpServer, Socket clientSocket, ServerSocket serverSocket,AccessCounter accesscounter) {
		this.httpServer = httpServer;
		this.clientSocket = clientSocket;
		this.serverSocket = serverSocket;
		this.accesscounter = accesscounter;
	}

	public void run() {
		try {

			HttpExchange ex = new HttpExchange(clientSocket, serverSocket,accesscounter);

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