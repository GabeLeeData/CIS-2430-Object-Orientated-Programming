
public class Stock {
	
	
	String symbol;
	String name;
	int quantity;
	double price;
	double bookValue;
	
	
	public Stock(String ssymbol, String sname, int sq, double sprice, double bv) {
		
		this.symbol = ssymbol;
		
		this.name = sname;
		
		this.quantity = sq;
		
		this.price =sprice;
		
		this.bookValue =bv;
		
		
	}


	public String toString() 
	{
		return "("+this.symbol+", "+this.name+", "+this.quantity+", "+this.price+", "+this.bookValue+")";
	}
	
	
}
