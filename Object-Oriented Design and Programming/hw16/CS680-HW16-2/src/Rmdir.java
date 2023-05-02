

public class Rmdir implements Command {
	private FileSystem fs;
	private String dir_file_name;
	public Rmdir(FileSystem fs,String name) {
		this.fs = fs;
		this.dir_file_name=name;
	}

	public void execute() {
		fs.deleteChild(this.dir_file_name);
	}
	public String toString()
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("Command line: rmdir "+this.dir_file_name+"\n\r");
		return buffer.toString();
	}
}
