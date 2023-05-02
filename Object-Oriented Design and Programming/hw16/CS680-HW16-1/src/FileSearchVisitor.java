import java.util.ArrayList;


public class FileSearchVisitor implements FSVisitor {
	
	private String extension;
	private ArrayList<File> foundFiles;
	//FSElement file;
	

	public FileSearchVisitor (String extension) {
		this.extension=extension;
		foundFiles =new ArrayList<File>();
	}

	
	public void visit(Link link){

		return;
	}

	public void visit(File file){
		//this.file=file;

		if(file.getName().contains(this.extension)){
			this.foundFiles.add(file);
		}
	}
	
	public void visit(Directory directory){

		return;
	}
	
	public ArrayList<File> getFoundFiles(){


		return this.foundFiles;

	}

}
