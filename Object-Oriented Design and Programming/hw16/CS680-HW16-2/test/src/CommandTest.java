import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

import java.util.Arrays;

import org.junit.Test;
import org.junit.Before;

import java.util.Date;



public class CommandTest {

	private FileSystem fs;
	private CommandHistory history ;
	private String path;
	private Shell shell;
	@Before
	public void CommandTest()
	{
		fs = FileSystem.getFileSystem();
		Date date = new Date();
		fs.setRoot(new Directory(null, "/", "CS680", date));
		fs.setCurrent(fs.getRoot());
		Directory sys = new Directory(fs.getRoot(), "system", "Sue", date);
		File a = new File(sys, "a", "Jack", date, 50);
		File b = new File(sys, "b", "Mary", date, 51);
		File c = new File(sys, "c", "Tom", date, 55);
		Directory home = new Directory(fs.getRoot(), "home", "Jane", date);
		File d = new File(home, "d", "Cart", date, 65);
		Link x = new Link(home, "x", "Peter", date, sys);
		Directory pictures = new Directory(home, "pictures", "Jim", date);
		File e = new File(pictures, "e", "Joe", date, 71);
		File f = new File(pictures, "f", "John", date, 85);
		Link y = new Link(pictures, "y", "Lame", date, e);
		history = new CommandHistory();
		this.path = "/home/pictures";
		this.shell = new Shell();
	}
	@Test
	public void testCdExecute() {
		Cd cd = new Cd(fs);
		cd.path=this.path;
		cd.fileElementsNames = shell.parse(cd.path,"/");
		cd.execute();
		this.history.push(cd);
		assertThat(fs.getCurrent().getName(), is("pictures"));
	}
	@Test
	public void testCdRootExecute() {
		Cd cd = new Cd(fs);
		cd.path="";
		cd.fileElementsNames = shell.parse(cd.path,"/");
		cd.execute();
		this.history.push(cd);
		assertThat(fs.getCurrent().getName(), is("/"));
	}
	@Test
	public void testMkdirExecute() {
		int c = fs.getChildren().size();
		Mkdir mkdir = new Mkdir(fs,"test1");
		mkdir.execute();
		this.history.push(mkdir);
		assertThat(fs.getChildren().size(), is(c+1));
	}
	@Test
	public void testRmdirExecute() {
		int c = fs.getChildren().size();
		Rmdir rmdir = new Rmdir(fs,"home");
		rmdir.execute();
		this.history.push(rmdir);
		assertThat(fs.getChildren().size(), is(c-1));
	}
	@Test
	public void testLnExecute() {
		int c = fs.getChildren().size();
		Ln ln = new Ln(fs,"testLink1");
		ln.path = "/home";
		ln.fileElementsNames = shell.parse(ln.path,"/");
		ln.execute();
		this.history.push(ln);
		assertThat(fs.getChildren().size(), is(c+1));
	}
	@Test
	public void testChownExecute() {
		Chown chown = new Chown(fs,"TTD");
		chown.path = "";
		chown.fileElementsNames = shell.parse(chown.path,"/");
		chown.execute();
		this.history.push(chown);
		assertThat(fs.getCurrent().getOwner(), is("TTD"));
	}
}
