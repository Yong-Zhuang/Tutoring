import java.util.*;

public class CommandHistory {
	ArrayList<Command> commands;

	public CommandHistory() {
		this.commands = new ArrayList<Command>();
	}

	public void push(Command command) {
		commands.add(command);
	}

	public Command pop() {
		if (commands.size() > 0) {
			return commands.get(commands.size()-1);
		}
		return null;
	}
	public String toString()
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("------------------------\r\n");
		for(Command c : this.commands)
		{
			buffer.append(c);
		}
		buffer.append("------------------------\r\n");
		return buffer.toString();
	}
}
