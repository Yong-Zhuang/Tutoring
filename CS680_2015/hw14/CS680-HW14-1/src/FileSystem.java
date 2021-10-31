
import java.util.*;



public class FileSystem {

	
	private FileSystem() {
	}

	private static FileSystem instance = null;
	public Directory root;

	
	public static FileSystem getFileSystem() {
		if (instance == null) {
			instance = new FileSystem();
			// instance.root=root;
			return instance;
		}
		return instance;
	}

	public void showAllElements() {

		if (this.root != null) {
			System.out.println(this.root);
		} else {
			System.out.println("Empty fileSystem!");
		}
	}

	

}
