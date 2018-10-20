package assignment3;

/**
 * Child class for investments only for Stocks
 * 
 * @author Gabe
 *
 */
public class Stock extends Investment {
	private double price;
	private double bookValue;

	/**
	 * Super
	 */
	public Stock() {
		super("", "", 0);
	}

	/**
	 * Initializing Stock fund Variables
	 * 
	 * @param symbol
	 *            Symbol of the Stock
	 * @param name
	 *            Name of the Stock
	 * @param quantity
	 *            Quantity of the Stock
	 * @param price
	 *            Price of the stock
	 * @param bookValue
	 *            Bookvalue of the stock
	 */
	public Stock(String symbol, String name, int quantity, double price, double bookValue) {
		super(symbol, name, quantity);
		this.price = price;
		this.bookValue = bookValue;

	}

	/**
	 * the To string method for Stock
	 */
	@Override
	public String toString() {

		return super.toString() + ",Stock," + this.price + "," + this.bookValue;
	}

	/**
	 * Overriding the boolean objects
	 */
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

	/**
	 * Returns the price of Stocks
	 * 
	 * @return the price of stocks
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Return the price of Bookvalue
	 * 
	 * @return the bookvalue of Stocks
	 */
	public double getBookvalue() {
		return bookValue;
	}
}
