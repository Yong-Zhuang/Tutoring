import java.io.PrintStream;
import java.util.Date;
public interface HttpServlet {
	public void doGet(PrintStream out);
	public int length();
	public Date lastModified();
}
