
import java.util.*;

public class Test {

	public static void main(String[] args)  {
		FileSystem fs = FileSystem.getFileSystem();// String name, String owner,
													// Date created
		Date date = new Date();
		fs.root = new Directory(null, "root", "CS680", date);
		Directory sys = new Directory(fs.root, "system", "Sue", date);
		Directory home = new Directory(fs.root, "home", "Jane", date);
		File a = new File(sys, "a", "Jack", date, 50);
		File b = new File(sys, "b", "Mary", date, 51);
		File c = new File(sys, "c", "Tom", date, 55);
		Directory pictures = new Directory(home, "pictures", "Jim", date);
		File d = new File(home, "d", "Cart", date, 65);
		File e = new File(pictures, "e", "Joe", date, 71);
		File f = new File(pictures, "f", "John", date, 85);
		fs.showAllElements();
	}

}
