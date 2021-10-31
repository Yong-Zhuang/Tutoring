import java.util.ArrayList;

public class Dir implements Command {
	public String path;
	private FileSystem fs;
	public ArrayList<String> fileElementsNames;

	public Dir(FileSystem fs) {
		this.fileElementsNames = new ArrayList<String>();
		this.fs = fs;
	}

	public void execute() {
		if (this.path.equals("..")) {
			if (fs.getCurrent().getParent() != null) {
				for (FSElement fe : fs.getCurrent().getParent().getChildren())
					System.out.println(fe.toString());
			}
			return;
		}
		if (this.path.equals(".")||this.path.equals("")) {
			for (FSElement fe : fs.getChildren())
				System.out.println(fe.toString());
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
				break;
			}
		}
		if (fe != null) {
			if (fe instanceof Directory) {
				if(((Directory) fe).getChildren().size()>0)
				{
					for (FSElement f : ((Directory) fe).getChildren())
						System.out.println(f.toString());
				}
				else{
					System.out.println("No dir/file under this directory.");
				}
			} else {
				System.out.println(fe.toString());
			}
		}
		else{
			System.out.println("Cannot find this dir/file");
		}
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Command line: dir " + this.path + "\n\r");
		return buffer.toString();
	}
}