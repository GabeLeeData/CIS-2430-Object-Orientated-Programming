package assignment2;

public class MutualFund extends Investment{
	
	
	private double price;
	private double bookValue;
	
	
	public MutualFund() {
        super("", "", 0);
    }
	
	
	 public MutualFund(String symbol, String name, int quantity, double price, double bookValue) {
	    super(symbol, name, quantity);
	    this.price = price;
	    this.bookValue = bookValue;
	        
	}
	 
	 @Override
	 public String toString() {
		 
	    return super.toString() + ",Mutualfund," + this.price + "," + this.bookValue;
	}
	
	 @Override
	    public boolean equals(Object o) {
	        if (o == this) {
	            return true;
	        }
	        if (!(this.getClass().equals(o.getClass()))) {
	            return false;
	        }
	        Stock wb = (Stock) o;
	        return (this.getPrice() == (wb.getPrice())) && (this.getBookvalue() == (wb.getBookvalue())) && super.equals(o);
	}
	 
	 public double getPrice() {
		 return price;
	 }
	 
	 public double getBookvalue() {
		 return bookValue;
	 }
}
