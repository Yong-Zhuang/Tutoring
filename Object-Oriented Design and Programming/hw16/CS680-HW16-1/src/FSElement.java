
import java.util.*;

public abstract class FSElement {
	protected String name;
	protected String owner;
	protected Date created;
	protected Date lastModified;
	protected int size;
	protected Directory parent;

	
	public FSElement(Directory parent, String name, String owner, Date created) {
		this.parent = parent;
		if (parent != null) {
			this.parent.appendChild(this);
		}
		this.created = created;
		this.lastModified = created;
		this.owner = owner;
		this.name = name;
	}

	public Directory getParent() {
		return this.parent;
	}
	public String getName() {
		return this.name;
	}

	abstract public boolean isLeaf();

	public int getDiskUtil(){
		return this.size;
	}
	abstract public void accept (FSVisitor v);
}