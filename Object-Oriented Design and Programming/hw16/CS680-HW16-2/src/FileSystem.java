
import java.util.*;

public class FileSystem {

	private FileSystem() {
	}

	private static FileSystem instance = null;
	private Directory root;
	private Directory current;

	public static FileSystem getFileSystem() {
		if (instance == null) {
			instance = new FileSystem();
			// instance.root=root;
			return instance;
		}
		return instance;
	}

	public Directory getRoot() {
		return this.root;
	}

	public void setRoot(Directory dir) {
		this.root = dir;
	}

	public Directory getCurrent() {
		return this.current;
	}

	public void setCurrent(Directory dir) {
		this.current = dir;
	}

	public ArrayList<FSElement> getChildren() {
		return this.current.getChildren();
	}

	public void deleteChild(String filelementName) {
		FSElement fe = null;
		for (FSElement element : this.current.getChildren()) {
			if (element.getName().equals(filelementName)) {
				fe = element;
				break;
			}
		}
		if (fe != null) {
			this.current.getChildren().remove(fe);
		}
	}

	public void showAllElements() {

		if (this.root != null) {
			System.out.println(this.root);
		} else {
			System.out.println("Empty fileSystem!");
		}
	}

}
