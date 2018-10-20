package assignment3;

/**
 * Main Class for holding different investments
 * 
 * @author Gabe
 *
 */
public class Investment {
	private String symbol;
	private String name;
	private int quantity;

	/**
	 * Public class method for investment class, initializes symbol , name and
	 * quantity to null
	 * 
	 * @param symbol
	 *            Symbol for investments
	 * @param name
	 *            Name for investments
	 * @param quantity
	 *            Quantity for investments
	 */
	public Investment(String symbol, String name, int quantity) {

		if (symbol == null) {
			this.symbol = "";
		} else {
			this.symbol = symbol;
		}

		if (name == null) {
			this.name = "";
		} else {
			this.name = name;
		}
		if (this.quantity < 0) {
			this.quantity = 0;
		} else {
			this.quantity = quantity;
		}
	}

	/**
	 * Override method for Investment class
	 */
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

	/**
	 * To String method for investment
	 */
	@Override
	public String toString() {
		return (this.symbol + "," + this.name + "," + this.quantity);
	}

	/**
	 * Returns the String Symbol
	 * 
	 * @return Symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * Returns the String Name
	 * 
	 * @return Name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the int Quantity
	 * 
	 * @return Quantity
	 */
	public int getQuantity() {
		return quantity;
	}

}
