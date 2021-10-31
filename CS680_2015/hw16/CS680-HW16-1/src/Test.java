
import java.util.*;

public class Test {

	public static void main(String[] args)  {
		FileSystem fs = FileSystem.getFileSystem();// String name, String owner,
													// Date created
		Date date = new Date();
		fs.root = new Directory(null, "root", "CS680", date);
		Directory sys = new Directory(fs.root, "system", "Sue", date);
		File a = new File(sys, "a.txt", "Jack", date, 50);
		File b = new File(sys, "b.doc", "Mary", date, 51);
		File c = new File(sys, "c.php", "Tom", date, 55);
		Directory home = new Directory(fs.root, "home", "Jane", date);
		File d = new File(home, "d.txt", "Cart", date, 65);
		Link x = new Link(home, "x", "Peter", date,sys);
		Directory pictures = new Directory(home, "pictures", "Jim", date);
		File e = new File(pictures, "e.txt", "Joe", date, 71);
		File f = new File(pictures, "f.html", "John", date, 85);
		Link y = new Link(home, "y", "Lame", date,e);
		fs.showAllElements();
		
		
		
		CountingVisitor cv = new CountingVisitor();
		fs.root.accept(cv);
		
		System.out.println("The filesystem fs has:"+"\n");

		System.out.println(cv.getDirNum()+ " Diretories" + "\n");
		System.out.println(cv.getFileNum()+" Files" + "\n");
		System.out.println(cv.getLinkNum()+" Links" + "\n");


		SizeCountingVisitor scv = new SizeCountingVisitor();
		fs.root.accept(scv);
		System.out.println("Total size of fs:" + scv.getTotalSize()+"\n");
		
		FileSearchVisitor fsv = new FileSearchVisitor (".txt");
		fs.root.accept(fsv);
		//fsv.gotFoundFiles().size();
		System.out.println("The number of files with the extension of \".txt\" in fs: " + fsv.getFoundFiles().size());
	}

}
