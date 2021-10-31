import java.util.*;

public class Mkdir implements Command {
	private FileSystem fs;
	private String dir_file_name;

	public Mkdir(FileSystem fs, String name) {
		this.fs = fs;
		this.dir_file_name = name;
	}

	public void execute() {// (Directory parent, String name, String owner, Date
							// created
		Date date = new Date();
		new Directory(fs.getCurrent(), this.dir_file_name, "", date);

	}

	public String toString()
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("Command line: mkdir "+this.dir_file_name+"\n\r");
		return buffer.toString();
	}
}
