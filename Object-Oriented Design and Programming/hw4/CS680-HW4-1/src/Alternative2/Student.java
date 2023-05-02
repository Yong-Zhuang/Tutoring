package Alternative2;

// including main method. (Important!) Reference to cs110 example firm. 
public class Student {

	private String name;
	private StudentStatus status;


	public Student(StudentStatus status, String name){
		this.status=status;
		this.name=name;	
	}


	public String getName(){

		return this.name;
	}	

	public float getTuition(){

		return this.status.getTuition();
	}

}
