package FactoryMethodEnumerationBased;

// including main method. (Important!) Reference to cs110 example firm. 
public class Student {
	private float tuition;
	private String name;
	private int i20num;
	private String usAddr;
	private int yrsInState;
	private String foreignAddr;
	private StudentStatus status;


	private Student(float tuition, String name,int i20num,String usAddr,int yrsInState,String foreignAddr,StudentStatus status){
		this.tuition=tuition;
		this.name=name;
		this.i20num=i20num;
		this.usAddr=usAddr;
		this.yrsInState=yrsInState;
		this.foreignAddr=foreignAddr;
		this.status=status;
	}
	public static Student createInStateStudent(float tuition, String name,String usAddr,int yrsInState,StudentStatus status){
		return new Student(tuition,name,0,usAddr,yrsInState,"",status);		
	}
	public static Student createOutStateStudent(float tuition, String name,String usAddr,int yrsInState,StudentStatus status){
		return new Student(tuition,name,0,usAddr,yrsInState,"",status);		
	}
	public static  Student createIntlStateStudent(float tuition, String name,int i20num,String usAddr,int yrsInState,String foreignAddr,StudentStatus status){
		return new Student(tuition,name,i20num,usAddr,yrsInState,foreignAddr,status);		
	}

	public String getName(){

		return this.name;
	}	

	public float getTuition(){

		return this.tuition;
	}

}
