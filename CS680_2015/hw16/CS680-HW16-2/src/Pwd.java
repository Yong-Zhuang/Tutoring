

public class Pwd implements Command {
	private FileSystem fs;

	public Pwd(FileSystem fs) {
		this.fs = fs;
	}

	public void execute() {
		System.out.println(fs.getCurrent().toString());
	}
	public String toString()
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("Command line: pwd "+this.fs.getCurrent().getName()+"\n\r");
		return buffer.toString();
	}
}
