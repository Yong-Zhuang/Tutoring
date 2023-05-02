package FactoryClassEnumerationBased;

public class Student {
	private float tuition;
	private String name;
	private int i20num;
	private String usAddr;
	private int yrsInState;
	private String foreignAddr;
	private StudentStatus status;


	protected Student(float tuition, String name,int i20num,String usAddr,int yrsInState,String foreignAddr,StudentStatus status){
		this.tuition=tuition;
		this.name=name;
		this.i20num=i20num;
		this.usAddr=usAddr;
		this.yrsInState=yrsInState;
		this.foreignAddr=foreignAddr;
		this.status=status;
	}

	public String getName(){

		return this.name;
	}	

	public float getTuition(){

		return this.tuition;
	}

}
