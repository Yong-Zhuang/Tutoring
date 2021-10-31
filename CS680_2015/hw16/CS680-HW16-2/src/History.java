
public class History implements Command {
	private CommandHistory ch;

	public History(CommandHistory ch) {
		this.ch = ch;
	}

	public void execute() {
		System.out.println(ch);
	}
	public String toString()
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("Command line: History \n\r");
		return buffer.toString();
	}
}
