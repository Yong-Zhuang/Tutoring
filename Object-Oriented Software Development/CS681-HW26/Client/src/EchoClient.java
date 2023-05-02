

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.io.*;

public class EchoClient{
	private static final int BANKPORT = 8888;
	private Socket socket;
	private Scanner in;
	private PrintWriter out;

	public void init(){
		try{
			try{
				socket = new Socket( "localhost", BANKPORT );
				System.out.println( "Socket created on the local port " +
									socket.getLocalPort() );
				System.out.println( "A connection established with the remote port " +
									socket.getPort() + " at " +
									socket.getInetAddress().toString() );
	
				in = new Scanner( socket.getInputStream() );
				out = new PrintWriter( socket.getOutputStream() );
				System.out.println( "I/O setup done." );
				sendCommands();
			}finally{
				socket.close();
			}
		}catch(IOException exception){}
	}
	
	public void sendCommands(){
		sendCommand( "Client_Test\n" );	
		System.out.println( getResponse() );	
		sendCommand( "QUIT\n" );		
	}
	
	public void sendCommand( String command ){
		System.out.print( "Sending " + command );
		out.print( command );
		out.flush();
		if( command.equals("QUIT") ){
			try{
				socket.close();
				System.out.println( "A connection closed." );
			}
			catch (IOException exception){
				exception.printStackTrace();
			}
		}
	}
	
	public String getResponse(){
		return in.nextLine();
	}

	public static void main(String[] args){
		EchoClient client = new EchoClient();
		client.init();
	}
}
