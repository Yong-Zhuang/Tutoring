
public class SizeCountingVisitor implements FSVisitor {

	private int totalSize = 0;

	public void visit(Link link){

		this.totalSize += link.getDiskUtil();
	}

	public void visit(File file){

		this.totalSize += file.getDiskUtil();
	}
	public void visit(Directory directory){

		this.totalSize += directory.getDiskUtil();
	}

	public int getTotalSize(){
		return this.totalSize;

	}

}
