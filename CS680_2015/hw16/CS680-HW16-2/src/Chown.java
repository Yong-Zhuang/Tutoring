import java.util.ArrayList;



public class Chown implements Command {
	public String path;
	private FileSystem fs;
	private String ownName;
	public ArrayList<String> fileElementsNames;

	public Chown(FileSystem fs, String ownName) {
		this.fs = fs;
		this.ownName = ownName;
		this.fileElementsNames = new ArrayList<String>();
	}

	public void execute() {
		
		if (this.path.equals("..")) {
			if (fs.getCurrent().getParent() != null) {
				fs.getCurrent().getParent().setOwner(this.ownName);
			}
			return;
		}
		if (this.path.equals(".")||this.path.equals("")) {
			fs.getCurrent().setOwner(this.ownName);
			return;
		}
		Directory cur = fs.getCurrent();
		FSElement fe = null;
		if (path.startsWith("/"))
			cur = fs.getRoot();
		for (int i = 0; i < fileElementsNames.size(); i++) {
			String name = fileElementsNames.get(i);
			boolean isFind = false;
			for (FSElement child : cur.getChildren()) {
				if (isFind) {
					break;
				}
				if (child.getName().equals(name)) {
					if (i == fileElementsNames.size() - 1) {
						fe = child;
						isFind = true;
					} else {
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
					}
				}
			}
			if (!isFind) {
				System.out.println("Cannot find this target address");
			}
		}
		fe.setOwner(this.ownName);
	}

	public String toString()
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("Command line: chown "+this.ownName+" "+this.path+"\n\r");
		return buffer.toString();
	}
}
