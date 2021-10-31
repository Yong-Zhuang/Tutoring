
import java.util.Date;


public class Link extends FSElement {

	private FSElement target;
	public Link(Directory parent, String name, String owner, Date created,FSElement target) {
		super(parent, name, owner, created);
		this.size = 0;
		this.target=target;
	}

	public boolean isLeaf() {
		return true;
	}

	public int getSize() {
		return this.target.getSize();
	}
	public FSElement getTarget()
	{
		return this.target.getTarget();
	}
	public String toString() {

		StringBuffer buffer = new StringBuffer();

		buffer.append("------------------------------------------------------------------------------------------------\r\n");
		buffer.append("Link: " + this.name + "  ");
		buffer.append("Parent: " + this.parent.name + "  ");
		buffer.append("Target: " + this.target.name + "  ");
		buffer.append("Size: " + this.getSize() + "  ");
		buffer.append("Owner: " + this.owner + "  ");
		buffer.append("Created: " + this.created + "\r\n");
		return buffer.toString();
	}

}
