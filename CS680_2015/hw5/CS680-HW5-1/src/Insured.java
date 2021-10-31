
import java.util.*;

public class Insured {

	public ArrayList<Policy> policies;
	private String name;
	private int age;

	public Insured (String name, int age){

		this.name=name;
		this.age=age;
		policies=new ArrayList<Policy>();
	}

	public String getName(){

		return this.name;
	}
	public int getAge(){

		return this.age;
	}	
	public void buyPolicy (Policy policy){
		policy.setInsured(this.name);
		policies.add(policy);
	} 
	public double totalMonthlyPayment(){
		double pay = 0;
		for(Policy p :policies)
		{
			if(p.isAvailable())
			pay+=p.getMonthlyPayment();
		}
		return pay;
	}
	public double totalYTDPayment(){
		double pay = 0;
		for(Policy p :policies)
		{
			if(p.isAvailable())
			pay+=p.getYTDPayment();
		}
		return pay;
	}
	public String toString () {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Insured: "+ this.name+"\r\n");
		buffer.append("Age: "+ this.age+"\r\n");
		buffer.append("Monthly total payment: "+ this.totalMonthlyPayment()+"\r\n");
		buffer.append("YTD total payment: "+ this.totalYTDPayment()+"\r\n");
		for(Policy p :policies)
		{
			buffer.append("Policy: "+ p.getPolicyNumber()+"\r\n");
			buffer.append(p.getInfo());
		}
		return buffer.toString();
	}
}
