import java.util.*;

public class Directory extends FSElement {

	private ArrayList<FSElement> children;

	public Directory(Directory parent, String name, String owner, Date created) {
		super(parent, name, owner, created);
		this.size = 0;
		children = new ArrayList<FSElement>();
	}

	public ArrayList<FSElement> getChildren() {
		return this.children;
	}

	public void appendChild(FSElement newChild) {
		Date date = new Date();
		this.children.add(newChild);
		this.lastModified = date;
		if (this.parent != null) {
			this.parent.lastModified = date;
		}
	}

	public boolean isLeaf() {

		if (this.children.isEmpty()) {
			return true;
		} else {
			return false;

		}

	}

	public int getSize() {

		this.size = 0;
		for(FSElement f:this.children){
			if(f.getClass().getName()!="Link")
			this.size+=f.getSize();
		}
		return this.size;
	}

	public String toString() {

		StringBuffer buffer = new StringBuffer();
		buffer.append("------------------------\r\n");
		buffer.append("Directory: " + this.name + "\r\n");
		String parent = "null";
		if (this.parent != null)

		{
			parent = this.parent.name;
		}
		buffer.append("Parent: " + parent + "\r\n");
		buffer.append("Size: " + this.getSize() + "\r\n");
		buffer.append("Owner: " + this.owner + "\r\n");
		buffer.append("Created: " + this.created + "\r\n");
		for (FSElement f : this.children) {
			buffer.append(f);
		}
		return buffer.toString();

	}

}
