import java.io.PrintStream;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class index implements HttpServlet{
	private int length;
	private byte buf[];
	public index()
	{
		StringBuilder  sb = new StringBuilder();
		sb.append("<html lang='en'>");
		sb.append("<head>");
		sb.append("<title>Tiny HTTP Server TEST</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<h1>CS 681 Final Project.</h1>");
		sb.append("</body>");
		sb.append("</html>");
		buf = sb.toString().getBytes();
		this.length=buf.length;
	}
	@Override
	public void doGet(PrintStream out) {
		out.write(buf, 0, buf.length);
		out.flush();
	}

	@Override
	public int length() {
		return this.length;
	}

	@Override
	public Date lastModified() {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date d = sdf.parse("21/5/2016");
			return d;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
