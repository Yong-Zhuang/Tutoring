
public class Redo implements Command {
	private CommandHistory ch;
	private Command lastCommand;
	public Redo(CommandHistory ch) {
		this.ch = ch;
	}

	public void execute() {
		lastCommand=ch.pop();
		lastCommand.execute();
	}
	public String toString()
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("Command line: redo "+lastCommand.getClass().getName()+"\n\r");
		return buffer.toString();
	}
}
