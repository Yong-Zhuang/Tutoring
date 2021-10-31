
import java.util.*;

public abstract class FSElement {
	protected String name;
	protected String owner;
	protected Date created;
	protected Date lastModified;
	protected FSElement targrt;
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
	public void setOwner(String name)
	{
		this.owner=name;
	}
	public String getOwner()
	{
		return this.owner;
	}
	public Directory getParent() {
		return this.parent;
	}

	public String getPath() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(this.name);
		FSElement fe = this.parent;
		while(fe!=null)
		{
			buffer.insert(0, fe.getName()+"/");
			fe=fe.parent;
		}
		return buffer.toString().substring(1);
	}

	public String getName() {
		return this.name;
	}

	abstract public boolean isLeaf();

	abstract public int getSize();
	abstract public FSElement getTarget();
}
