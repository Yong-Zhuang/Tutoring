
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.File;

public class TinyHttpd2 {
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
					executeCommand(client);
				}
			} finally {
				serverSocket.close();
			}
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

	private void executeCommand(Socket client) {
		try {
			client.setSoTimeout(30000);
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintStream out = new PrintStream(client.getOutputStream());
			try {
				System.out.println("I/O setup done");

				String line = in.readLine();
				StringBuilder raw = new StringBuilder();
				raw.append("" + line);
				boolean isHttpCommand = (line.startsWith("GET") || line.startsWith("POST") || line.startsWith("HEAD"));
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
				while (line != null) {
					if (line.equals(""))
						break;
					raw.append('\n' + line);
					line = in.readLine();
				}
				File file = new File(targetUrl);
				System.out.println(file.getName() + " requested.");
				sendFile(out, file);

				out.flush();
			} finally {
				in.close();
				out.close();
				client.close();
				System.out.println("A connection is closed.");
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	private void sendFile(PrintStream out, File file) {
		try {
			DataInputStream fin = new DataInputStream(new FileInputStream(file));
			try {
				out.println("HTTP/1.0 200 OK");
				out.println("Content-Type: text/html");

				int len = (int) file.length();
				out.println("Content-Length: " + len);
				out.println("");

				byte buf[] = new byte[len];
				fin.readFully(buf);
				out.write(buf, 0, len);
				out.flush();
			} finally {
				fin.close();
			}
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TinyHttpd2 server = new TinyHttpd2();
		server.init();
	}

}
