package Alternative1;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student s1 = new Student(new InState(),"John Smith");
		Student s2 = new Student(new OutState(),"Mary");
		Student s3 = new Student(new Intl(),"Tom");

		System.out.println("Student name: "+s1.getName()+"; \n Tuition: "+ s1.getTuition()+". \n.............."
				+"\nStudent name: "+s2.getName()+"; \nTuition: "+ s2.getTuition()+". \n.............."
				+"\nStudent name: "+s3.getName()+"; \nTuition: "+ s3.getTuition()+". \n..............");
	}

}
