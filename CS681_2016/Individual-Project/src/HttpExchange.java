import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.StringTokenizer;
import java.lang.reflect.*;

public class HttpExchange {
	private Socket client;
	private ServerSocket server;
	private InetSocketAddress remoteAddress;
	private InetSocketAddress localAddress;
	private InputStream requestBody;
	private OutputStream responseBody;
	private BufferedReader in;
	private PrintStream out;
	private URI url;
	private String requestMethod;
	private AccessCounter accesscounter;

	public HttpExchange(Socket client, ServerSocket server,
			AccessCounter accesscounter) {
		this.client = client;
		this.server = server;
		this.accesscounter = accesscounter;
		// this.requestHeaders = new Headers();
		// this.responseHeaders = new Headers();
		this.localAddress = new InetSocketAddress(client.getLocalAddress(),
				client.getLocalPort());
		this.remoteAddress = new InetSocketAddress(client.getInetAddress(),
				client.getPort());
		try {
			requestBody = client.getInputStream();
			responseBody = client.getOutputStream();
			in = new BufferedReader(new InputStreamReader(requestBody));
			out = new PrintStream(responseBody);
			System.out.println("I/O setup done");
		} catch (IOException e) {
			// e.printStackTrace();
		}
	}

	public void makeSuccessfulResponse() {
		try {
			client.setSoTimeout(30000);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					client.getInputStream()));
			PrintStream out = new PrintStream(client.getOutputStream());
			System.out.println("I/O setup done");

			boolean alive = true;
			while (alive) {
				alive = false;
				try {

					System.out.println(Thread.currentThread().getId()
							+ "-----Starting to load a request");
					String line = in.readLine();
					System.out.println(Thread.currentThread().getId()
							+ "-----reading line");
					StringBuilder raw = new StringBuilder();
					raw.append("" + line);
					boolean isPost = line.startsWith("POST");
					boolean isHttpCommand = (line.startsWith("GET")
							|| line.startsWith("POST") || line
							.startsWith("HEAD"));
					boolean isHttp1_1 = line.endsWith("HTTP/1.1");
					boolean hasConnection_Header = false;
					int contentLength = 0;
					String targetUrl = null;
					if (isHttpCommand) {
						StringTokenizer st = new StringTokenizer(line);
						while (st.hasMoreElements()) {
							String n = st.nextElement().toString();
							if (n.equals("GET") || n.equals("POST")
									|| n.equals("HEAD")) {
								targetUrl = st.nextElement().toString()
										.substring(1);
							}
						}
					}
					while (!(line = in.readLine()).equals("")) {
						raw.append('\n' + line);
						if (isPost) {
							final String contentHeader = "Content-Length: ";
							if (line.startsWith(contentHeader)) {
								contentLength = Integer.parseInt(line
										.substring(contentHeader.length()));
							}
						}
						final String connection_Header = "Connection: ";
						if (line.startsWith(connection_Header)) {
							hasConnection_Header = true;
						}
					}
					StringBuilder body = new StringBuilder();
					if (isPost) {
						int c = 0;
						for (int i = 0; i < contentLength; i++) {
							c = in.read();
							body.append((char) c);
						}
						System.out.println("transmittedData: "
								+ body.toString());
						raw.append(body.toString());
					}
					boolean isPersistent = (hasConnection_Header || isHttp1_1);
					// System.out.println(file.getName() + " requested.");
					System.out
							.println("------------request detail------------");
					System.out.println(raw.toString());
					System.out
							.println("--------------------------------------");

					System.out.println(Thread.currentThread().getId()
							+ targetUrl + " requested."
							+ "-----is persistent: " + isPersistent);
					sendResponse(isHttpCommand, isPost, isPersistent, out,
							targetUrl);
					out.flush();
					alive = true;
					if (!isPersistent) {
						System.out.println("break");
						break;
					}
				} catch (Exception exception) {
					// System.out
					// .println("-------------------------------error in runnableExecuteCommand---------------------------.");
					// System.out.println(exception.getMessage());
					// System.out.println(exception.getLocalizedMessage());
					// System.out.println(exception.getStackTrace());
					alive = false;
					// alive = true;
					continue;
				}
			}
			in.close();
			out.close();
			client.close();
			System.out.println("A connection is closed.");
		} catch (Exception exception) {
		}
	}

	private void sendResponse(boolean isHttpCommand, boolean isPost,
			boolean isPersistent, PrintStream out, String targetUrl) {
		Date now = new Date();
		String osname = System.getProperty("os.name");
		int len = 0;
		try {
			if (isPost) {
				out.println("HTTP/1.0 200 OK");
				if (isPersistent)
					out.println("Connection: keep-alive");
				out.println("Date: " + now);
				out.println("Server: TinyHttpd JAVA/1.8.0_73" + osname);
				out.println("Content-Length: " + len);
				out.println("Content-Type: text/html");
				out.println("Last-Modified: ");
				out.println("");
				out.flush();
			} else if (isHttpCommand) {
				out.println("HTTP/1.0 200 OK");
				if (isPersistent)
					out.println("Connection: keep-alive");
				out.println("Date: " + now);
				out.println("Server: TinyHttpd JAVA/1.8.0_73" + osname);

				Class<?> mClass = Class.forName(targetUrl.toLowerCase().replace(".html",""));
				HttpServlet httpservlet = (HttpServlet) mClass.newInstance();

				len = (int) httpservlet.length();
				out.println("Content-Length: " + len);
				out.println("Content-Type: text/html");
				out.println("Last-Modified: " + httpservlet.lastModified());
				out.println("");

				httpservlet.doGet(out);
				accesscounter.increment(targetUrl);
				out.flush();

			}

			else {
				out.println("HTTP/1.0 501 Not Implemented)");
				if (isPersistent)
					out.println("Connection: keep-alive");
				out.println("Date: " + now);
				out.println("Server: TinyHttpd JAVA/1.8.0_73" + osname);
				out.println("Content-Length: " + len);
				out.println("Content-Type: text/html");
				out.println("Last-Modified: ");
				out.println("");
				out.flush();
			}

		} catch (Exception e) {
			out.println("HTTP/1.0 404 Not Found");
			if (isPersistent)
				out.println("Connection: keep-alive");
			out.println("Date: " + now);
			out.println("Server: TinyHttpd JAVA/1.8.0_73" + osname);

			out.println("Content-Length: 0");
			out.println("Content-Type: text/html");
			out.println("Last-Modified:");
			out.println("");
			out.flush();
			return;
		}

	}

}
