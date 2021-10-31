package FactoryClassEnumerationBased;

public class StudentFactory {


	private StudentFactory(){
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

}
