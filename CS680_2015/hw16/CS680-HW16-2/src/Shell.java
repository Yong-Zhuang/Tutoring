
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Shell {

	public ArrayList<String> parse(String input,String sign) {
		ArrayList<String> res = new ArrayList<>();
		if (input.startsWith(sign)) {
			input = input.substring(1);
		}
		res.addAll(Arrays.asList(input.split(sign)));
		return res;
	}

	private CommandHistory history = new CommandHistory();
	public CommandHistory getCommandHistory()
	{
		return this.history;
	}

	public static void main(String[] args) throws IOException {
		Shell shell = new Shell();
		FileSystem fs = FileSystem.getFileSystem();
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



		
		System.out.println("___________________Commands Menu___________________\r");
		System.out.println("- pwd  Print the current working directory\n"); 
		System.out.println("- cd <dir name>  Change the current directory to the specified directory \n"); 
		System.out.println("        <..> Change the current directory to its parent directory\n");
		System.out.println("- cd  Change the current directory to the root directory \n");
		System.out.println("- ls  Print the name of every file, directory and link in the current directory\n");
		System.out.println("- dir  Print the information\n");
		System.out.println("- dir<dir/file name> Print the specified directory's/file's information \n");
		System.out.println("- mkdir <dir name> Make the specified directory in the current directory\n"); 
		System.out.println("- rmdir <dir name> Remove the specified directory in the current direcotry\n"); 
		System.out.println("- ln <link name><target>  Make a link\n");
		System.out.println("- history  Print a sequence of previous-executed commands\n");
		System.out.println("- redo  Redo the most recently-executed command \n");
		System.out.println("- sort <type> Sort directories and files in the current directory\n");
		System.out.println("        <-a> sort by Alphabeta (default)\n");
		System.out.println("        <-r> sort by Reversed Alphabeta\n");
		System.out.println("- chown <owner><dir/file name>  Change the owner of a file/directory\n");
		System.out.println("- quit quit the terminal");
		System.out.println("____________________________________________________\n\r");
		
		System.out.print(fs.getCurrent().getPath() + ">");
		while (true) {
			BufferedReader bf = new BufferedReader(new InputStreamReader (System.in)) ;
			String commandLine = bf.readLine();
			ArrayList<String> commands =shell.parse( commandLine," ");
			if (commands.size() == 0) {
				return;
			}
			switch (CommandName.valueOf(commands.get(0).toUpperCase(Locale.ENGLISH))) {

			case QUIT: {
				return;
			}
			case CD: {
				Cd cd = new Cd(fs);
				if (commands.size() >= 2) {
					cd.path = commands.get(1);
				} else {
					cd.path = "";
				}
				cd.fileElementsNames = shell.parse(cd.path,"/");
				cd.execute();
				shell.history.push(cd);
				break;

			}
			case PWD: {
				Pwd pwd = new Pwd(fs);
				pwd.execute();
				shell.history.push(pwd);
				break;
			}
			case LS: {
				Ls ls = new Ls(fs);
				ls.execute();
				shell.history.push(ls);
				break;
			}
			case DIR: {
				Dir dir = new Dir(fs);
				if (commands.size()  >= 2) {
					dir.path = commands.get(1);
				} else {
					dir.path = "";
				}
				dir.fileElementsNames = shell.parse(dir.path,"/");
				dir.execute();
				shell.history.push(dir);
				break;
			}
			case MKDIR: {
				if (commands.size() < 2) {
					break;
				} 
				Mkdir mk = new Mkdir(fs,commands.get(1));
				mk.execute();
				shell.history.push(mk);
				break;
			}
			case RMDIR: {
				if (commands.size() < 2) {
					break;
				} 
				Rmdir rm = new Rmdir(fs,commands.get(1));
				rm.execute();
				shell.history.push(rm);
				break;
			}
			case LN: {
				if (commands.size() < 2) {
					break;
				} 
				Ln ln = new Ln(fs,commands.get(1));
				if (commands.size() > 2) {
					ln.path = commands.get(2);
				} else {
					ln.path = "";
				}
				ln.fileElementsNames = shell.parse(ln.path,"/");
				ln.execute();
				shell.history.push(ln);
				break;
			}
			case HISTORY: {
				History h = new History(shell.getCommandHistory());
				h.execute();
				shell.history.push(h);
				break;
			}
			case REDO: {
				Redo redo = new Redo(shell.getCommandHistory());
				redo.execute();
				break;
			}
			case SORT: {
				Comparator cmparator =new AlphabeticalComparator();;
				if (commands.size()>= 2) {
					switch(commands.get(1)){
					case "-a":
					{
						cmparator = new AlphabeticalComparator();
						break;
					}
					case "-r":
					{
						cmparator = new ReverseAlphabeticalComparator();
						break;
					}
					default:
					{
						cmparator = new AlphabeticalComparator();
						break;
					}
					}					
				}
				Sort sort = new Sort(fs,cmparator);
				sort.execute();
				shell.history.push(sort);
				break;
			}
			case CHOWN: {
				if (commands.size() < 2) {
					break;
				} 
				Chown chown = new Chown(fs,commands.get(1));
				if (commands.size() > 2) {
					chown.path = commands.get(2);
				} else {
					chown.path = "";
				}
				chown.fileElementsNames = shell.parse(chown.path,"/");
				chown.execute();
				shell.history.push(chown);
				break;
			}
			default: {
				break;
			}
			}
			System.out.print(fs.getCurrent().getPath() + ">");
		}
	}

}
