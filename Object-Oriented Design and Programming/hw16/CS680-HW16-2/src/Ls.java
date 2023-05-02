
public class Ls implements Command {
	private FileSystem fs;

	public Ls(FileSystem fs) {
		this.fs = fs;
	}

	public void execute() {
		for (FSElement fe : fs.getChildren())
			System.out.println(fe.getName()+"-----------"+fe.getClass().getName());
	}

	public String toString()
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("Command line: ls "+this.fs.getCurrent().getName()+"\n\r");
		return buffer.toString();
	}
}
