import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class Test {
	public static void main (String [] args) throws ParseException{

		int policyNumber1=001, policyNumber2=002, policyNumber3=003,policyNumber4=004;
		float deductible1=1000, deductible2=1500, deductible3=900,deductible4=2000;
		float annualPremium1=10000, annualPremium2=20000, annualPremium3=14000, annualPremium4=24000;
		String agentName1="John Smith", agentName2="Mary", agentName3="Tom", agentName4="Jack";
		Calendar cal = Calendar.getInstance();
		cal.set(2012,2, 2);
		Date start1 = cal.getTime();	
		cal.set(2019,2, 2);	
		Date expire1 = cal.getTime();
		cal.set(2008,12, 2);	
		Date start2 = cal.getTime();
		cal.set(2022,3, 2);
		Date expire2 = cal.getTime();	
		cal.set(2010,1, 12);
		Date start3 = cal.getTime();		
		cal.set(2031,2, 22);
		Date expire3 = cal.getTime();	
		cal.set(2000,1, 12);
		Date start4 = cal.getTime();		
		cal.set(2013,12, 22);
		Date expire4 = cal.getTime();		
	
		Insured insured1 = new Insured("Jeo", 27);
		insured1.buyPolicy(new Policy(new Product("GEICO","Car"),policyNumber1,deductible1,annualPremium1,agentName1,start1,expire1));
		insured1.buyPolicy(new Policy(new Product("AIG","Medical"),policyNumber2,deductible2,annualPremium2,agentName2,start2,expire2));
		insured1.buyPolicy(new Policy(new Product("Progressive","Property"),policyNumber3,deductible3,annualPremium3,agentName3,start3,expire3));
		insured1.buyPolicy(new Policy(new Product("GEICO","Truck"),policyNumber4,deductible4,annualPremium4,agentName4,start4,expire4));


		System.out.println(insured1);

	}
}
