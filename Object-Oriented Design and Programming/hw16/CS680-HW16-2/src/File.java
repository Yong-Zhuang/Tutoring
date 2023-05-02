
import java.util.Date;


public class File extends FSElement {

	public File(Directory parent, String name, String owner, Date created, int size) {
		super(parent, name, owner, created);
		this.size = size;
	}

	public boolean isLeaf() {
		return true;
	}

	public int getSize() {
		return this.size;
	}

	public FSElement getTarget(){
		return this;
	}
	public String toString() {

		StringBuffer buffer = new StringBuffer();

		buffer.append("------------------------------------------------------------------------------------------------\r\n");
		buffer.append("File: " + this.name + "  ");
		buffer.append("Parent: " + this.parent.name + "  ");
		buffer.append("Size: " + this.getSize() + "  ");
		buffer.append("Owner: " + this.owner + "  ");
		buffer.append("Created: " + this.created + "\r\n");
		return buffer.toString();
	}

}
