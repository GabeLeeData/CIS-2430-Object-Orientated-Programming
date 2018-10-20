
public class MutualFund {
	
	String symbol;
	String name;
	int quantity;
	double price;
	double bookValue;
	
	
	
	public MutualFund(String msymbol, String mname, int mq, double mprice, double mbv) {
		
		this.symbol = msymbol;
		
		this.name = mname;
		
		this.quantity = mq;
		
		this.price = mprice;
		
		this.bookValue = mbv;
		
		
	}
	
	
	
	public String toString() 
	{
		return "("+this.symbol+", "+this.name+", "+this.quantity+", "+this.price+", "+this.bookValue+")";
	}
	
	
}
