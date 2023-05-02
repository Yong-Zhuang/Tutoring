
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.StringTokenizer;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.File;

public class TinyHttpd3 {
	private static final int PORT = 8888;
	private ServerSocket serverSocket;

	public void init() {
		try {
			try {
				serverSocket = new ServerSocket(PORT);
				System.out.println("Socket created.");

				while (true) {
					System.out.println(
							"Listening to a connection on the local port " + serverSocket.getLocalPort() + "...");
					Socket client = serverSocket.accept();
					System.out.println("\nA connection established with the remote port " + client.getPort() + " at "
							+ client.getInetAddress().toString());
					// executeCommand(client);
					new Thread(new HttpHandler(client)).start();
				}
			} finally {
				serverSocket.close();
			}
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

	private class HttpHandler implements Runnable {
		private Socket client;

		public HttpHandler(Socket s) {
			this.client = s;
		}

		@Override
		public void run() {
			try {
				client.setSoTimeout(30000);
				BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				PrintStream out = new PrintStream(client.getOutputStream());
				try {
					System.out.println("I/O setup done");

					String line = in.readLine();
					StringBuilder raw = new StringBuilder();
					raw.append("" + line);
					boolean isPost = line.startsWith("POST");
					boolean isHttpCommand = (line.startsWith("GET") || line.startsWith("POST")
							|| line.startsWith("HEAD"));
					int contentLength = 0;
					String targetUrl = null;
					if (isHttpCommand) {
						StringTokenizer st = new StringTokenizer(line);
						while (st.hasMoreElements()) {
							String n = st.nextElement().toString();
							if (n.equals("GET") || n.equals("POST") || n.equals("HEAD")) {
								targetUrl = st.nextElement().toString().substring(1);
							}
						}
					}
					while (!(line = in.readLine()).equals("")) {
						raw.append('\n' + line);
						if (isPost) {
							final String contentHeader = "Content-Length: ";
							if (line.startsWith(contentHeader)) {
								contentLength = Integer.parseInt(line.substring(contentHeader.length()));
							}
						}
					}
					StringBuilder body = new StringBuilder();
					if (isPost) {
						int c = 0;
						for (int i = 0; i < contentLength; i++) {
							c = in.read();
							body.append((char) c);
						}
						System.out.println("transmittedData: " + body.toString());
						raw.append(body.toString());
					}
					File file = new File(targetUrl);
					System.out.println(file.getName() + " requested.");
					sendFile(isHttpCommand, isPost, out, file);
					out.flush();
				} finally {
					in.close();
					out.close();
					client.close();
					System.out.println("A connection is closed.");
				}
			} catch (Exception exception) {
				// exception.printStackTrace();
				// System.out.println(exception.getMessage());
			}
		}

		private void sendFile(boolean isHttpCommand, boolean isPost, PrintStream out, File file) {
			Date now = new Date();
			String osname = System.getProperty("os.name");
			int len = 0;
			try {
				FileInputStream f = new FileInputStream(file);
				DataInputStream fin = new DataInputStream(f);
				try {
					if (isPost) {
						out.println("HTTP/1.0 200 OK");
						out.println("Date: " + now);
						out.println("Server: TinyHttpd3 JAVA/1.8.0_73" + osname);
						out.println("Content-Length: " + len);
						out.println("Content-Type: text/html");
						out.println("Last-Modified: ");
						out.println("");
						out.flush();
					} else if (isHttpCommand) {
						out.println("HTTP/1.0 200 OK");
						out.println("Date: " + now);
						out.println("Server: TinyHttpd3 JAVA/1.8.0_73" + osname);
						len = (int) file.length();
						out.println("Content-Length: " + len);
						out.println("Content-Type: text/html");
						long lastM = file.lastModified();
						Date d = new Date(lastM * 1000);
						out.println("Last-Modified: " + d);// Tue, 15 Nov 1994
															// 12:45:26 GMT
						out.println("");

						byte buf[] = new byte[len];
						fin.readFully(buf);
						out.write(buf, 0, len);
						out.flush();
					}

					else {
						out.println("HTTP/1.0 501 Not Implemented)");
						out.println("Date: " + now);
						out.println("Server: TinyHttpd3 JAVA/1.8.0_73" + osname);
						out.println("Content-Length: " + len);
						out.println("Content-Type: text/html");
						out.println("Last-Modified: ");
						out.println("");
						out.flush();
					}

				} finally {
					fin.close();
				}
			} catch (IOException exception) {
				out.println("HTTP/1.0 404 Not Found");
				out.println("Date: " + now);
				out.println("Server: TinyHttpd3 JAVA/1.8.0_73" + osname);

				out.println("Content-Length: 0");
				out.println("Content-Type: text/html");
				out.println("Last-Modified:");
				out.println("");
				out.flush();
				return;
			}
		}

	}

	public static void main(String[] args) {
		TinyHttpd3 server = new TinyHttpd3();
		server.init();
	}

}
