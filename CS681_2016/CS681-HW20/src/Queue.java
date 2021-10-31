
public interface Queue {
	public int size();
	public void put(Runnable obj);
	public Runnable get();
}

