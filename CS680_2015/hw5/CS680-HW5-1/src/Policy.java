
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Policy {

	private Product product;
	private int policyNumber;
	private double deductible;
	private double annualPremium;
	private double monthlyPayment;
	private double ytdPayment;
	private String agentName;
	private String insuredName;
	private Date [] policyTerm =new Date [2];		

	public Policy (Product product, int policyNumber, double deductible, double annualPremium, String agentName, Date start, Date expire){

		this.product=product;
		this.policyNumber=policyNumber;
		this.deductible= deductible;
		this.annualPremium=annualPremium;
		this.monthlyPayment=annualPremium/12;
		this.agentName=agentName;
		this.policyTerm [0]=start;
		this.policyTerm [1]=expire;		

	}
	public void setInsured(String insured)
	{
		this.insuredName=insured;
	}
	public int getPolicyNumber()
	{
		return this.policyNumber;
	}
	public double getDeductible()
	{
		return this.deductible;
	}
	public double getAnnualPremium()
	{
		return this.annualPremium;
	}
	public double getMonthlyPayment()
	{
		return this.monthlyPayment;
	}
	public double getYTDPayment()
	{
		Calendar c = Calendar.getInstance();
		this.ytdPayment=monthlyPayment*c.get(Calendar.MONTH);	
		return this.ytdPayment;
	}
	public String getAgentName()
	{
		return this.agentName;
	}
	public boolean isAvailable()
	{
		Date now = new Date(System.currentTimeMillis());
		if(now.after(this.policyTerm [0]))
		{
			return now.before(this.policyTerm [1]);
		}
		return false;
	}
	public String getInfo(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("..........\r\n");
		buffer.append("Insurer Name: "+ this.product.getInsurerName()+"\r\n");
		buffer.append("Product Name: "+ this.product.getProductName()+"\r\n");
		buffer.append("Available? "+ this.isAvailable()+"\r\n");
		buffer.append("Deductible: "+ this.deductible+"\r\n");
		buffer.append("Annual Premium: "+ this.annualPremium+"\r\n");
		buffer.append("Monthly Payment: "+ this.monthlyPayment+"\r\n");
		buffer.append("Agent Name: "+ this.agentName+"\r\n");
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		buffer.append("Policy Term: from "+ format.format(this.policyTerm [0])+" to "+format.format(this.policyTerm [1])+"\r\n");
		buffer.append("..........\r\n");
		return buffer.toString();
	}  

}
