package assignment3;

/**
 * Child Class for investments only for mutual funds
 * 
 * @author Gabe
 *
 */
public class MutualFund extends Investment {

	private double price;
	private double bookValue;

	/**
	 * Super
	 */
	public MutualFund() {
		super("", "", 0);
	}

	/**
	 * Initializing Mutual Fund Variables
	 * 
	 * @param symbol
	 *            Symbol Name
	 * @param name
	 *            Name
	 * @param quantity
	 *            The amount of stocks
	 * @param price
	 *            The price
	 * @param bookValue
	 *            The bookvalue
	 */
	public MutualFund(String symbol, String name, int quantity, double price, double bookValue) {
		super(symbol, name, quantity);
		this.price = price;
		this.bookValue = bookValue;

	}

	/**
	 * The to String method for Mutualfunds
	 */
	@Override
	public String toString() {

		return super.toString() + ",Mutualfund," + this.price + "," + this.bookValue;
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
	 * Returns the price of the mutual fund
	 * 
	 * @return the price of the mutual fund
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Returns the bookvalue of the mutual fund
	 * 
	 * @return the bookvalue of the mutual fund
	 */
	public double getBookvalue() {
		return bookValue;
	}
}
