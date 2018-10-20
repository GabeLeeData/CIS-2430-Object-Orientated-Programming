package assignment2;


public class Investment {
	private String symbol;
	private String name;
	private int quantity; 
	
	
	public Investment (String symbol, String name, int quantity)
	{
			
		 if (symbol == null)
		 {	            
			 this.symbol = "";
		 } 
		 else 
		 {
			 this.symbol = symbol;   
		 }
	        
		 if (name == null) 
		 {
			 this.name = "";	        
		 } 
		 else
		 {	            
			 this.name = name;	        
		 }	        
		 if (this.quantity < 0) 
		 {	            
			 this.quantity = 0;	        
		 } 
		 else 
		 {	            
			 this.quantity = quantity;
		 }
	}
	
	

	
	
	@Override
    public boolean equals(Object o) {
        if (!(o instanceof Investment)) {
            return false;
        } else {
        	Investment b = (Investment) o;
            if (!(this.getSymbol().equals(b.getSymbol()))) {
                return false;
            }
            if (!(this.getName().equals(b.getName()))) {
                return false;
            }
            if (!(this.getQuantity() == b.getQuantity())) {
                return false;
            }
           
            return true;
        }
    }
	
	 @Override
	    public String toString() {
	        return (this.symbol + "," + this.name + "," + this.quantity);
	    }

	    public String getSymbol() {
	        return symbol;
	    }

	    public String getName() {
	        return name;
	    }

	    public int getQuantity() {
	        return quantity;
	    }
	    
	    

	
}
