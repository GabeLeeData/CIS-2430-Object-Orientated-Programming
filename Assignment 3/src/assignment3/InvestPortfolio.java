package assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class InvestPortfolio {

	/**
	 * Search function for indexes
	 * 
	 * @param symbol
	 * @param name
	 * @param low
	 * @param high
	 * @return the found temp
	 */

	public String searchindex(String symbol, String name, String low, String high) {
		ArrayList<Investment> temp = new ArrayList<>();
		double l = Double.parseDouble(low);
		double h = Double.parseDouble(high);

		for (int o = 0; o < this.investments.size(); o++) {
			if (symbol.toLowerCase().equals(this.investments.get(o).getSymbol().toLowerCase()) || symbol.isEmpty()) {

				if (name.toLowerCase().equals(this.investments.get(o).getName().toLowerCase()) || name.isEmpty()) {

					// look through stock
					if (this.investments.get(o) instanceof Stock) {

						double compare = ((Stock) this.investments.get(o)).getPrice();
						if ((l <= compare && h >= compare) || (low.isEmpty() && high.isEmpty())
								|| (low.isEmpty() && h >= compare) || (l <= compare && high.isEmpty())) {
							temp.add(this.investments.get(o));

							System.out.println(this.investments.get(o));

						}

					}

					// look through mutual fund
					else {

						double compare = ((Stock) this.investments.get(o)).getPrice();
						if (l <= compare || h >= compare || (low.isEmpty() && high.isEmpty())) {
							temp.add(this.investments.get(o));
							System.out.println(this.investments.get(o));
						}

					}

				}

			}

		}

		return "You have found" + temp + ".";

	}

	/**
	 * Function to calculate overral gains from portfolio
	 * 
	 * @param counter
	 * @param price
	 * @return
	 */

	public double gains(int counter, String price) {
		double p = Double.parseDouble(price);
		counter = counter - 1;
		double realgain = 0;

		if (this.investments.get(counter) instanceof Stock) {

			// previous value
			double spre = ((Stock) this.investments.get(counter)).getBookvalue();

			// update the new bookvalue
			double upbookv = updateprice(this.investments.get(counter).getQuantity(), p, spre);

			// compute the gain
			realgain = gain(spre, upbookv);

		}

		else {
			double mpre = ((MutualFund) this.investments.get(counter)).getBookvalue();

			// update the new bookvalue
			double upbookv = updateprice(this.investments.get(counter).getQuantity(), p, mpre);

			realgain = gain(mpre, upbookv);

		}

		return realgain;

	}

	/**
	 * Changes the prices of the investments
	 * 
	 * @param counter
	 * @param price
	 * @return
	 */
	public String changePrice(int counter, String price) {

		double p = Double.parseDouble(price);
		counter = counter - 1;

		if (this.investments.get(counter) instanceof Stock) {

			// find the value of bookvalue before it gets updated
			double spre = ((Stock) this.investments.get(counter)).getBookvalue();

			// update the new bookvalue
			double upbookv = updateprice(this.investments.get(counter).getQuantity(), p, spre);

			// add the new bookvalue and price
			Investment temp3 = new Stock(this.investments.get(counter).getSymbol(),
					this.investments.get(counter).getName(), this.investments.get(counter).getQuantity(), p,
					((Stock) this.investments.get(counter)).getBookvalue());

			this.investments.add(temp3);

			this.investments.remove(counter);
		}

		else {
			double mpre = ((MutualFund) this.investments.get(counter)).getBookvalue();

			// update the new bookvalue
			double upbookv = updateprice(this.investments.get(counter).getQuantity(), p, mpre);

			// add the new bookvalue and price
			Investment temp4 = new MutualFund(this.investments.get(counter).getSymbol(),
					this.investments.get(counter).getName(), this.investments.get(counter).getQuantity(), p,
					((MutualFund) this.investments.get(counter)).getBookvalue());

			this.investments.add(temp4);

			this.investments.remove(counter);

		}

		for (int i = 0; i < this.investments.size(); i++) {

			System.out.println(this.investments.get(i));

		}

		return "The Updated Investment is: " + this.investments.get(investments.size() - 1) + ".";
	}

	/**
	 * Function used for calculating sale profits for stocks
	 * 
	 * @param quantity
	 * @param price
	 * @return
	 */
	public double salepS(int quantity, double price) {
		double comis = 9.99;
		double salev = ((quantity * price) - comis);

		return salev;
	}

	/**
	 * Function used for calculating sale profits from mutual funds
	 * 
	 * @param quantity
	 * @param price
	 * @return
	 */
	public double salepM(int quantity, double price) {
		double comis = 45.00;
		double salev = ((quantity * price) - comis);

		return salev;
	}

	/**
	 * function used for selling stocks or mutual funds
	 * 
	 * @param Symbol
	 * @param Quant
	 * @param Price
	 * @return
	 */
	public String Sellcheck(String Symbol, String Quant, String Price) {
		String symbol = null;
		int q = Integer.parseInt(Quant);
		double price = Double.parseDouble(Price);
		double profit = 0;
		// match symbols within the investment class

		for (int o = this.investments.size() - 1; o >= 0; o--) {

			if (this.investments.get(o).getSymbol().equals(Symbol.toLowerCase())) {

				symbol = this.investments.get(o).getSymbol();
				if (this.investments.get(o) instanceof Stock) {

					double sellsbv = sellsbookv(q, this.investments.get(o).getQuantity(),
							((Stock) this.investments.get(o)).getBookvalue(), price);
					profit = salepS(q, price);
					int newq = this.investments.get(o).getQuantity() - q;

					if (newq <= 0 || sellsbv <= 0) {

						// remove hashmaps

						// remove instment with quantity less than 0
						this.investments.remove(o);

					}

					else {
						Investment temp2 = new Stock(this.investments.get(o).getSymbol(),
								this.investments.get(o).getName(), newq, ((Stock) this.investments.get(o)).getPrice(),
								sellsbv);
						this.investments.add(temp2);

						this.investments.remove(o);
					}

				}

				else {

					double sellmbv = sellmbookv(q, this.investments.get(o).getQuantity(),
							((MutualFund) this.investments.get(o)).getBookvalue(), price);
					profit = salepM(q, price);

					int newq2 = this.investments.get(o).getQuantity() - q;

					if (newq2 <= 0 || sellmbv <= 0) {

						// remove hashmaps

						// remove instment with quantity less than 0
						this.investments.remove(o);

					}

					else {
						Investment temp3 = new MutualFund(this.investments.get(o).getSymbol(),
								this.investments.get(o).getName(), newq2,
								((MutualFund) this.investments.get(o)).getPrice(), sellmbv);
						this.investments.add(temp3);

						this.investments.remove(o);
					}

				}

			}

		}
		for (int i = 0; i < this.investments.size(); i++) {

			System.out.println(this.investments.get(i));

		}

		return "You have sold " + symbol + " and your total profits from this sale are " + profit + ".";
	}

	/**
	 * Numbercheck
	 * 
	 * @param check
	 * @return
	 */
	public boolean numbercheck(String check) {
		if (check.matches("^[0-9]+$")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Backwards counter for symbol when hitting previous on update menu
	 * 
	 * @param counter
	 * @return
	 */
	public String backs(int counter) {

		String returner;

		returner = this.investments.get(counter - 1).getSymbol();
		return returner;
	}

	/**
	 * Backwards counter for name when hitting previous on update menu
	 * 
	 * @param counter
	 * @return
	 */
	public String backn(int counter) {
		String returner;
		returner = this.investments.get(counter - 1).getName();
		return returner;

	}

	/**
	 * Returns name when hitting next on update menu
	 * 
	 * @param counter
	 * @return
	 */
	public String updatet(int counter) {
		String returner;

		returner = this.investments.get(counter).getName();
		return returner;

	}

	/**
	 * Returns symbol when hitting next on update menu
	 * 
	 * @param counter
	 * @return
	 */
	public String updateg(int counter) {
		String returner;

		returner = this.investments.get(counter).getSymbol();
		return returner;
	}

	/**
	 * Adding mutual funds into gui
	 * 
	 * @param Symbol
	 * @param Name
	 * @param Quantity
	 * @param Price
	 * @return the statement that a mutual fund has been added.
	 */

	public String insertM(String Symbol, String Name, String Quantity, String Price) {

		int q = Integer.parseInt(Quantity);
		double price = Double.parseDouble(Price);
		double bv = MBV(q, price);
		MutualFund temporary = new MutualFund(Symbol, Name, q, price, bv);

		this.investments.add(temporary);
		System.out.println("Updated Listing: ");

		for (int i = 0; i < this.investments.size(); i++) {

			System.out.println(this.investments.get(i));

		}

		return "You have added " + this.investments.get(investments.size() - 1) + ".";

	}

	/**
	 * adding stocks to gui
	 * 
	 * @param Symbol
	 * @param Name
	 * @param Quantity
	 * @param Price
	 * @return the statement that a stock has been added
	 */
	public String insertS(String Symbol, String Name, String Quantity, String Price) {

		int q = Integer.parseInt(Quantity);
		double price = Double.parseDouble(Price);
		double bv = SBV(q, price);

		Stock temporary = new Stock(Symbol, Name, q, price, bv);

		this.investments.add(temporary);
		System.out.println("Updated Listing: ");

		for (int i = 0; i < this.investments.size(); i++) {

			System.out.println(this.investments.get(i));

		}

		return "You have added " + this.investments.get(investments.size() - 1) + ".";

	}

	/**
	 * Calculates the gain.
	 * 
	 * @param prevbook
	 *            previous book
	 * @param newbook
	 *            new book value
	 * @return the gain
	 */
	public double gain(double prevbook, double newbook) {
		double gain = 0;

		gain = newbook - prevbook;

		return gain;
	}

	/**
	 * Calculates the update price with stocks
	 * 
	 * @param quantity
	 *            The quantity of stocks
	 * @param price
	 *            The price of the stocks
	 * @param bookv
	 *            The Bookvalue
	 * @return the updated price for stocks
	 */
	public double updateprice(int quantity, double price, double bookv) {
		double comis = 9.99;
		double newbookv = 0;

		newbookv = ((quantity * price) - comis);

		double exact = Math.floor(newbookv * 100) / 100;
		return exact;
	}

	/**
	 * Calculates the bookv for selling for stocks
	 * 
	 * @param quantity
	 *            The quantity of the stocks
	 * @param quantity2
	 *            The quantity that you want to sell
	 * @param bookv
	 *            The bookvalue
	 * @param price
	 *            The price we sell at
	 * @return the bookv after selling for stocks
	 */
	public double sellsbookv(int quantity, int quantity2, double bookv, double price) {
		double comis = 9.99;
		double bookvnew = 0;
		int quant3 = quantity2 - quantity;
		double salev = ((quantity * price) - comis);
		System.out.println("You have received : $" + salev);
		bookvnew = (((double) quant3 / quantity2) * bookv);
		double exact = Math.floor(bookvnew * 100) / 100;

		return exact;

	}

	/**
	 * Calculates the bookv for selling for mutual funds
	 * 
	 * @param quantity
	 *            The quantity of the mutual funds
	 * @param quantity2
	 *            The quantity that you want to mutual funds
	 * @param bookv
	 *            The bookvalue
	 * @param price
	 *            The price
	 * @return the bookv after selling for mutual funds
	 */
	public double sellmbookv(int quantity, int quantity2, double bookv, double price) {
		double bookvnew = 0.00;
		double comis = 45.00;
		int quant3 = quantity2 - quantity;
		double salev = ((quantity * price) - comis);
		System.out.println("You have received : $" + salev);
		bookvnew = (((double) quant3 / quantity2) * bookv);
		double exact = Math.floor(bookvnew * 100) / 100;

		return exact;

	}

	/**
	 * Initialize Arraylist Investments.
	 */
	public ArrayList<Investment> investments;

	/**
	 * Default Constructor for the class and initializes the instance.
	 */
	public InvestPortfolio() {
		this.investments = new ArrayList<>();
	}

	/**
	 * 
	 * Method for scanning in strings
	 */
	public String GetScan() {
		Scanner scan = new Scanner(System.in);
		String sc = scan.nextLine();

		return sc;
	}

	/**
	 * Calculates the buy function for stocks
	 * 
	 * @param quantity
	 *            Quantity of stocks
	 * @param price
	 *            The price of stocks
	 * @return bookv for stocks
	 */
	public double SBV(int quantity, double price) {

		double comis = 9.99;
		double bookv = (quantity * price) + comis;
		double exact = Math.floor(bookv * 100) / 100;

		return exact;

	}

	/**
	 * Calculates the buy function for funds
	 * 
	 * @param quantity
	 *            Quantity of mutual funds
	 * @param price
	 *            Price of mutual funds
	 * @return The new bookvalue for mutual funds
	 */
	public double MBV(int quantity, double price) {

		double bookv = (quantity * price);

		double exact = Math.floor(bookv * 100) / 100;

		return exact;
	}

	/**
	 * 
	 * @param args
	 *            Main method to run the entire programs, starts with uploading the
	 *            files and ends with writing to the file.
	 */

	public void run(String[] args) {

		HashMap<String, ArrayList<Integer>> searchindex = new HashMap<String, ArrayList<Integer>>();
		ArrayList<Investment> templist = new ArrayList<>();
		BufferedReader reader;
		List<String> Reading = new ArrayList<String>();
		String sent;
		String placer[];
		String symbol;
		String name;

		int quantity;

		double price;

		double bookvalue;

		Investment temp;

		String temp111[] = null;
		Random rnd = new Random();
		int scounter = 0;
		int mcounter = 0;

		ArrayList<String> hash = new ArrayList<String>();

		try {
			reader = new BufferedReader(new FileReader(args[0]));
			while ((sent = reader.readLine()) != null) {
				Reading.add(sent);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Failed to read " + args[0] + ".");
		}

		// reading in file
		for (int i = 0; i < Reading.size(); i++) {
			temp111 = null;
			placer = Reading.get(i).split(",");
			symbol = placer[0];
			name = placer[1];
			temp111 = name.split(" ");

			for (int p = 0; p < temp111.length; p++) {
				hash.add(temp111[p]);

			}

			quantity = Integer.parseInt(placer[2]);
			price = Double.parseDouble(placer[4]);
			bookvalue = Double.parseDouble(placer[5]);

			if (placer[3].equals("Stock")) {
				scounter++;
				temp = new Stock(symbol, name, quantity, price, bookvalue);
			} else {

				mcounter++;
				temp = new MutualFund(symbol, name, quantity, price, bookvalue);

			}

			templist.add(temp);

		}

		this.investments = templist;
		System.out.println("You have loaded:" + scounter + " Stock Entries");
		System.out.println("You have loaded:" + mcounter + " MutualFund Entries");
		Set<String> unique = new HashSet<String>(hash);

		// count the occurrence of different names

		for (String key : unique) {

			// create hashmap for names
			if (Collections.frequency(hash, key) == 1) {
				ArrayList<Integer> location = new ArrayList<Integer>();
				location.add(rnd.nextInt(10));
				searchindex.put(key, location);

			}

			// create hashmap for names
			else {

				ArrayList<Integer> templ = new ArrayList<Integer>();
				for (int x1 = 0; x1 < Collections.frequency(hash, key); x1++) {

					templ.add(rnd.nextInt(10));

				}
				searchindex.put(key, templ);
			}

		}

		System.out.println("Hashmap Search Index: ");
		System.out.println(searchindex.toString());

	}

	public static void main(String[] args) {
		InvestPortfolio invest = new InvestPortfolio();

		// MainGui gui = new MainGui();
		// gui.setVisible(true);

		GuiMain gui = new GuiMain();

		invest.run(args);

	}

}
