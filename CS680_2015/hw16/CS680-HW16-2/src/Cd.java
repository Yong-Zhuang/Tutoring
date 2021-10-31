import java.util.ArrayList;

public class Cd implements Command {
	public String path;
	private FileSystem fs;
	public ArrayList<String> fileElementsNames;

	public Cd(FileSystem fs) {
		this.fileElementsNames = new ArrayList<String>();
		this.fs = fs;
	}

	public void execute() {
		if (this.path.equals("..")) {
			if (fs.getCurrent().getParent() != null) {
				fs.setCurrent(fs.getCurrent().getParent());
			}
			return;
		}
		if (this.path.equals("")) {
			fs.setCurrent(fs.getRoot());
			return;
		}
		if (this.path.equals(".")) {
			return;			
		}
		Directory cur = fs.getCurrent();
		if (path.startsWith("/"))
			cur = fs.getRoot();
		for (String name : fileElementsNames) {
			boolean isFind = false;
			for (FSElement child : cur.getChildren()) {
				if (isFind) {
					break;
				}
				if (child.getName().equals(name)) {
					switch (child.getClass().getName()) {
					case "Directory": {
						cur = (Directory) child;
						isFind = true;
						break;
					}
					case "Link": {
						FSElement target = child.getTarget();
						if (target instanceof Directory) {
							cur = (Directory) target;
							isFind = true;
							break;
						} else {
							continue;
						}
					}
					default: {
						continue;
					}
					}
				} else {
					continue;
				}
			}
			if (!isFind) {
				System.out.println("Don't have this directory.");
			}
		}
		fs.setCurrent(cur);
	}

	public String toString()
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("Command line: cd "+this.path+"\n\r");
		return buffer.toString();
	}
}
