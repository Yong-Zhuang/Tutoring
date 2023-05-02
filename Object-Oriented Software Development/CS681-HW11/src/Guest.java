import java.util.*;

public class Guest implements Runnable{
	private SecurityGate gate;
	public Guest(){
		gate = SecurityGate.getInstance();
	}
	public void run(){
		gate.enter();
		gate.exit();
		gate.getCount();
	}
}
