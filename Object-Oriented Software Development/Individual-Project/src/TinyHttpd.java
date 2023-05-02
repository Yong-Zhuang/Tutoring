import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.File;

public class TinyHttpd {
	private static final int PORT = 8888;
	private ServerSocket serverSocket;
	private Authenticator authenticator;
	private ReentrantReadWriteLock lock;
	private AccessCounter accesscounter;
	public TinyHttpd(String authenticatorType){
		this(authenticatorType,"lfu");
	}
	public TinyHttpd(String authenticatorType,String fileCacheType){
		System.out.println(authenticatorType);
		switch(authenticatorType)
		{
			case "b":
			{
				authenticator = new BasicAuthenticator();
				break;				
			}
			case "d":
			{
				authenticator = new DigestAuthenticator();
			}
			default:
			{
				authenticator=null;
			}
		}
		lock = new ReentrantReadWriteLock();
		accesscounter = new AccessCounter(lock);

	}
	public Authenticator getAuthenticator ()
	{
		return this.authenticator;
	}
	public void init() throws InterruptedException {
		try {
			try {
				StaticThreadPool pool = StaticThreadPool.getInstance(4, true);
				serverSocket = new ServerSocket(PORT);
				System.out.println("Socket created.");

				while (true) {
					System.out.println(
							"Listening to a connection on the local port " + serverSocket.getLocalPort() + "...");
					Socket client = serverSocket.accept();
					System.out.println("\nA connection established with the remote port " + client.getPort() + " at "
							+ client.getInetAddress().toString());
					pool.execute(new HttpHandler(this,client,serverSocket,this.accesscounter));

				}
			} finally {
				serverSocket.close();
			}
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}
	public static void main(String[] args) throws InterruptedException {
		TinyHttpd server;
		if(args==null||args.length==0){
			 server = new TinyHttpd("b");
		}
		else{
			 server = new TinyHttpd(args[0]);
		}
		server.init();
	}

}
