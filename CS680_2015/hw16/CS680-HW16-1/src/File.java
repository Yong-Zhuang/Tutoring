
import java.util.Date;


public class File extends FSElement {

	public File(Directory parent, String name, String owner, Date created, int size) {
		super(parent, name, owner, created);
		this.size = size;
	}

	public boolean isLeaf() {
		return true;
	}


	public void accept (FSVisitor v) {
		v.visit(this);
	}

	public String toString() {

		StringBuffer buffer = new StringBuffer();

		buffer.append("------------------------\r\n");
		buffer.append("File: " + this.name + "\r\n");
		buffer.append("Parent: " + this.parent.name + "\r\n");
		buffer.append("Size: " + this.getDiskUtil() + "\r\n");
		buffer.append("Owner: " + this.owner + "\r\n");
		buffer.append("Created: " + this.created + "\r\n");
		return buffer.toString();
	}

}
