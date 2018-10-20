import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * 
 * @author Gabe
 * Assignment 1 
 * Investment Portfolio
 * 
 *
 */
public class InvestPortfolio {
	//Create classes for data types of mutual and stock fund
	public ArrayList<MutualFund> mutual;
	public ArrayList<Stock> stock;
	
	/**
	 * Calculates the gain.
	 * @param prevbook previous book
	 * @param newbook new book value
	 * @return the gain 
	 */
	public double gain (double prevbook, double newbook)
	{
		double gain = 0;
	
		
		gain = newbook - prevbook;
		
		return gain;
	}
	
	/**
	 * Calculates the update price with stocks
	 * @param quantity The quantity of stocks
	 * @param price The price of the stocks
	 * @param bookv The Bookvalue
	 * @return the updated price for stocks
	 */
	public double updateprice (int quantity, double price, double bookv)
	{
		double comis = 9.99;
		double newbookv = 0;
	
		
		newbookv = ((quantity * price) - comis);
		
		
		double exact = Math.floor(newbookv * 100) / 100;
		return exact;
	}
	
	/**
	 * Calculates the update price with mutual funds
	 * @param quantity The quantity of mutual funds
	 * @param price The price of the mutual funds
	 * @param bookv The bookvalue
	 * @return the updated price for mutual funds
	 */
	public double updatepricem (int quantity, double price, double bookv)
	{
		double comis = 45.00;
		double newbookv = 0;
	
		newbookv = ((quantity * price) - comis);
		double exact = Math.floor(newbookv * 100) / 100;
		return exact;
	}
	
	/**
	 *  Calculates the bookv for selling for stocks
	 * @param quantity The quantity of the stocks
	 * @param quantity2 The quantity that you want to sell
	 * @param bookv The bookvalue
	 * @param price The price we sell at 
	 * @return the bookv after selling for stocks
	 */
	public double sellsbookv (int quantity, int quantity2, double bookv, double price)
	{
		double comis = 9.99;
		double bookvnew = 0;
		int quant3 = quantity2 - quantity;
		double salev = ((quantity * price) - comis);
		System.out.println("You have received : $" + salev);
		bookvnew = (((double)quant3/quantity2) * bookv);
		double exact = Math.floor(bookvnew * 100) / 100;

		
		return exact;
		

	}
	
	
	/**
	 * Calculates the bookv for selling for mutual funds
	 * @param quantity The quantity of the mutual funds
	 * @param quantity2 The quantity that you want to mutual funds
	 * @param bookv The bookvalue
	 * @param price The price
	 * @return the bookv after selling for mutual funds
	 */
	public double sellmbookv (int quantity, int quantity2, double bookv, double price)
	{
		double bookvnew = 0.00;
		double comis = 45.00;
		int quant3 = quantity2 - quantity;
		double salev = ((quantity * price) - comis);
		System.out.println("You have received : $" + salev);
		bookvnew = (((double)quant3/quantity2) * bookv);
		double exact = Math.floor(bookvnew * 100) / 100;

		
		return exact;
		
	}
	/**
	 * Calculates the buy function for stocks
	 * @param quantity Quantity of stocks
	 * @param price The price of stocks
	 * @return bookv for stocks
	 */
	public double buysbookv (int quantity, double price) 
	{
		
		
		double comis = 9.99;
		double bookv = (quantity * price) + comis;
		return bookv;
		
	}
	
	/**
	 * Calculates the buy function for funds
	 * @param quantity Quantity of mutual funds
	 * @param price Price of mutual funds
	 * @return The new bookvalue for mutual funds
	 */
	public double buymbookv (int quantity, double price)
	{
		
		double bookv = (quantity * price);
		
		return bookv;
	}
	
	
	public void run() 
	{
		//create temporary arraylist 
		ArrayList<MutualFund> templist = new ArrayList<>();
		ArrayList<Stock> templist2 = new ArrayList<>();
		int command = 0;
		InvestPortfolio invest1 = new InvestPortfolio();
		int total = 0;
		int x = 0;
		int y =0;
		int sq = 0;
		int option = 0;
		int mq = 0;
		int sellq = 0;
		int indicator = 0;
		int indicator2 = 0;
		double sellprice = 0;
		double mprice = 0;
		double mbv =0;
		double sprice = 0;
		double sbv = 0;
		double sellsbv = 0;
		double sellmbv = 0;
		double updateprice = 0;
		double updateprice2 = 0;
		double spre = 0;
		double mpre = 0;
		double gain = 0;
		double totalgain = 0;
		double tempbookv2 = 0;
		double tempbookv= 0;
		int catcher1 = 0;
		int catcher2 = 0;
		
		
		do
		{
			//command loop for menu
			System.out.println("1. Buy:");
			System.out.println("2. Sell:");
			System.out.println("3. Update:");
			System.out.println("4. getGain:");
			System.out.println("5. Search");
			System.out.println("6. Quit");
			
			
			Scanner scannerObject = new Scanner(System.in);
			String ind = scannerObject.next();
			
			if (ind.equals("1")) 
			{
				total++;
				//Check buy option for stock or mutual fund
				System.out.println("Please enter 1 For Stock or 2 for Mutual Fund");
				
				Scanner scannerObject2 = new Scanner(System.in);
				while (true) {
					try {
					option = scannerObject2.nextInt();
					break;
					} catch(InputMismatchException e) {
					System.out.println("Please enter 1 For Stock or 2 for Mutual Fund");
					scannerObject2.nextLine();
					
					}
				}	
				
				if (option == 1) 
				{	
					//stock options
					System.out.println("Stock");
					System.out.println("Enter Symbol");
					Scanner scannerObject3 = new Scanner(System.in);
					String ssymbol = scannerObject3.nextLine();
					
					
					
					System.out.println("Enter Name");
					Scanner scannerObject4 = new Scanner(System.in);
					String sname = scannerObject4.nextLine();
					
					System.out.println("Enter Quantity");
					Scanner scannerObjects = new Scanner(System.in);
					
					// This is to catch whether the value for Quantity is a integer or not
					while (true) {
						try {
						sq = scannerObjects.nextInt();
						break;
						} catch(InputMismatchException e) {
						System.out.println("please enter a Integer");
						scannerObjects.nextLine();
						
						}
					}	
					
					// This is to catch whether the value for quantity is a integer or not
					System.out.println("Enter price");
					Scanner scannerObjectx = new Scanner(System.in);
					
					while (true) {
						try {
						sprice = scannerObjectx.nextDouble();
						break;
						} catch(InputMismatchException e) {
						System.out.println("please enter a proper value");
						scannerObjectx.nextLine();
						
						}
					}	
					
					//check to see if existing symbol is present and add to the previous quantity and delete previous listing if only stocks have been added 
					if (total >1 && x >= 1)
					{
						
						for (int o = this.stock.size()-1; o >=0 ; o--) 
						{
							
							if (this.stock.get(o).symbol.toLowerCase().equals(ssymbol.toLowerCase()))
							{
								
								double temp1 = this.stock.get(o).bookValue;
								double tempp = invest1.buysbookv(sq, sprice);
								sbv = temp1 + tempp;
								sq = this.stock.get(o).quantity + sq;
								this.stock.remove(o);
								
								catcher1 = 1;
								
								
							}
							
						}
						
						// set this as the bookv price if there is no need to check for replacement 
						if (catcher1 ==0)
						{
							System.out.println("test");
							tempbookv = invest1.buysbookv(sq, sprice);
							sbv = tempbookv;
							 
						}
						
						Stock temp = new Stock (ssymbol, sname, sq, sprice, sbv);
						templist2.add(temp);
						this.stock = templist2;
						
						catcher1 = 0;
						

						//check to see if existing symbol is present and add to the previous quantity and delete previous listing if only mutual funds have been added 
						if (total >1 && y >= 1)
						{
							for(int i=0;i<this.stock.size();i++)
							{
								for (int r = 0; r<this.mutual.size();r++)
								{
									if(this.stock.get(i).symbol.toLowerCase().equals(this.mutual.get(r).symbol.toLowerCase()))
									{
										this.stock.remove(i);
										i--;
										System.out.println("Symbols already exists, Please Try again");
									}
								}
							}
						}
						
						for(int i=0; i<this.stock.size(); i++)
						{

							System.out.println(this.stock.get(i));
				        }
						
						
						x++;
						indicator = 1;
						
						if (indicator ==1 && indicator2 ==1)
						{
							indicator =3;
						}
					}
					
					// No entry has been added use this.
					else
					{
						
						sbv = invest1.buysbookv(sq, sprice);
						
						Stock temp = new Stock (ssymbol, sname, sq, sprice, sbv);
						templist2.add(temp);
						this.stock = templist2;
						
					
						for(int i=0; i<this.stock.size(); i++)
						{

							System.out.println(this.stock.get(i));
				        }
						x++;
						indicator = 1;
						//setting indicator values for sell option
						if (indicator ==1 && indicator2 ==1)
						{
							indicator =3;
						}
						//check through mutual funds to see if an exisiting symbol exists
						if (total >1 && y >= 1)
						{
							for(int i=0;i<this.stock.size();i++)
							{
								for (int r = 0; r<this.mutual.size();r++)
								{
									if(this.stock.get(i).symbol.toLowerCase().equals(this.mutual.get(r).symbol.toLowerCase()))
									{
										this.stock.remove(i);
										i--;
										System.out.println("Symbols already exists, Please try again");
									}
								}
							}
						}
					}
					
					
				}
				
				
				// Mutual stock buy options
				if (option == 2) 
				{
					System.out.println("Mutual Fund");
					System.out.println("Enter Symbol");
					Scanner scannerObject5 = new Scanner(System.in);
					String msymbol = scannerObject5.nextLine();
					
					
					System.out.println("Enter Name");
					Scanner scannerObject6 = new Scanner(System.in);
					String mname = scannerObject6.nextLine();
					
					System.out.println("Enter Quantity");
					Scanner scannerObjecto = new Scanner(System.in);
					
					//catch for only integers
					while (true) {
						try {
						mq = scannerObjecto.nextInt();
						break;
						} catch(InputMismatchException e) {
						System.out.println("please enter a Integer");
						scannerObjecto.nextLine();
						
						}
					}	
					
					//catch for only intergers
					System.out.println("Enter price");
					Scanner scannerObjectsx = new Scanner(System.in);
					while (true) {
						try {
						mprice = scannerObjectsx.nextDouble();
						break;
						} catch(InputMismatchException e) {
						System.out.println("please enter a proper value");
						scannerObjectsx.nextLine();
						
						}
					}	
					
					// run through this code if more than one mutual fund has been added 
					if (total >1 && y >= 1)
					{
						
						for (int o = this.mutual.size()-1; o >=0 ; o--) 
						{
							
							if (this.mutual.get(o).symbol.equals(msymbol))
							{
								System.out.println("Caught");
								double temp22 = this.mutual.get(o).bookValue;
								double temppp = invest1.buymbookv(mq, mprice);
								mbv = temp22 + temppp;
								mq = this.mutual.get(o).quantity + mq;
								this.mutual.remove(o);
								catcher2 = 1;
							}
							
							else
							{
								
							}
							
							
						}
						
						if (catcher2 ==0)
						{
							
							tempbookv2 = invest1.buymbookv(mq, mprice);
							mbv = tempbookv2;
							 
						}
						
						MutualFund temp2 = new MutualFund (msymbol, mname, mq, mprice, mbv);
						templist.add(temp2);
						this.mutual = templist;
					
						catcher2 = 0;
						
						//check to see if an existing symbol exists in stocks
						if (total >1 && x >= 1)
						{
							for(int i=0;i<this.mutual.size();i++)
							{
								for (int r = 0; r<this.stock.size();r++)
								{
									if(this.mutual.get(i).symbol.toLowerCase().equals(this.stock.get(r).symbol.toLowerCase()))
									{
										this.mutual.remove(i);
										i--;
										System.out.println("Symbols already exists, Please Try again");
									}
								}
							}
						}
						
						
						for(int i=0; i<this.mutual.size(); i++)
						{

							System.out.println(this.mutual.get(i));
				        }
						y++;
						indicator2 = 1;
						if (indicator ==1 && indicator2 ==1)
						{
							indicator =3;
						}
						
				
					}
					//Run through this if its the first time a mutual fund is being added 
					else 
					{
						
						mbv = invest1.buymbookv(mq, mprice);
						
						MutualFund temp2 = new MutualFund (msymbol, mname, mq, mprice, mbv);
						templist.add(temp2);
						this.mutual = templist;
					
						//check to see if an existing symbol exists in stocks
						if (total >1 && x >= 1)
						{
							for(int i=0;i<this.mutual.size();i++)
							{
								for (int r = 0; r<this.stock.size();r++)
								{
									if(this.mutual.get(i).symbol.toLowerCase().equals(this.stock.get(r).symbol.toLowerCase()))
									{
										this.mutual.remove(i);
										i--;
										System.out.println("Symbols already exists, Please Try again");
									}
								}
							}
						}
						
						for(int i=0; i<this.mutual.size(); i++)
						{

							System.out.println(this.mutual.get(i));
				        }
						y++;
						indicator2 = 1;
						//setting indicator values for sell options
						if (indicator ==1 && indicator2 ==1)
						{
							indicator =3;
						}
					}
					
					
					
				}
				
				
			}
			
			
			/*
			 * SELL
			 * 
			 * 
			 */
			
			if (ind.equals("2")) 
			{
				
				//only checks through stock list, if only stocks were added
				
				if (indicator ==1 && indicator2 ==0)
				{
					
					System.out.println("Enter Symbol for investment: ");
					Scanner scannerObjectxx = new Scanner(System.in);
					String sellsymbol = scannerObjectxx.nextLine();
					
					System.out.println("Enter Actual Price: ");
					Scanner scannerObjectxp = new Scanner(System.in);
					while (true) {
						try {
						sellprice = scannerObjectxp.nextDouble();
						break;
						} catch(InputMismatchException e) {
						System.out.println("Please enter valid price");
						scannerObjectxp.nextLine();
						
						}
					}	
					
					System.out.println("Enter a quantity value: ");
					Scanner scannerObjectxrp = new Scanner(System.in);
					while (true) {
						try {
						sellq = scannerObjectxrp.nextInt();
						break;
						} catch(InputMismatchException e) {
						System.out.println("Please enter a valid quantity");
						scannerObjectxrp.nextLine();
						
						}
					}
					
					
					//matching the symbols to find the stock that wants to be sold
					for (int o = this.stock.size() -1; o >=0 ; o--) 
					{
						
						
						if(this.stock.get(o).symbol.equals(sellsymbol)) 
						{
							
							
							sellsbv = invest1.sellsbookv(sellq, this.stock.get(o).quantity, this.stock.get(o).bookValue, sellprice);
							this.stock.get(o).bookValue = sellsbv;
							this.stock.get(o).quantity = this.stock.get(o).quantity - sellq;
							if (this.stock.get(o).bookValue <= 0)
							{
									
								this.stock.remove(o);
								
							}
							
							else if (this.stock.get(o).quantity == 0)
							{
								this.stock.remove(o);
							}
							
						 
						}
						else
						{
							System.out.println("No Stock found"); // if no stock was found 
						}
					}
					
				}
				
				//only checks through stock list, if only stocks were added
				
				
				else if (indicator2 ==1 && indicator ==0)
				{
					System.out.println("Enter Symbol for investment22: ");
					Scanner scannerObjectxx = new Scanner(System.in);
					String sellsymbol = scannerObjectxx.nextLine();
					
					System.out.println("Enter Actual Price: ");
					Scanner scannerObjectxp = new Scanner(System.in);
					while (true) {
						try {
						sellprice = scannerObjectxp.nextDouble();
						break;
						} catch(InputMismatchException e) {
						System.out.println("Please enter valid price");
						scannerObjectxp.nextLine();
						
						}
					}	
					
					System.out.println("Enter a quantity value: ");
					Scanner scannerObjectxrp = new Scanner(System.in);
					while (true) {
						try {
						sellq = scannerObjectxrp.nextInt();
						break;
						} catch(InputMismatchException e) {
						System.out.println("Please enter a valid quantity");
						scannerObjectxrp.nextLine();
						
						}
					}
					

					//matching the symbols to find the mutual fund that wants to be sold
					for (int o= this.mutual.size()-1; o >=0 ; o--) 
					{
						
						if(this.mutual.get(o).symbol.contains(sellsymbol)) 
						{
							sellmbv = invest1.sellmbookv(sellq, this.mutual.get(o).quantity , this.mutual.get(o).bookValue, sellprice);
							this.mutual.get(o).bookValue = sellmbv;
							this.mutual.get(o).quantity = this.mutual.get(o).quantity - sellq;
							
							
							if (this.mutual.get(o).bookValue <= 0)
							{
								
									this.mutual.remove(o);
		
									
								
							}
							else if (this.mutual.get(o).quantity == 0)
							{
								this.mutual.remove(o);
							}
							
						}
						else
						{
							System.out.println("No Mutual fund found "); // if no stock was found 
						}
					
					}
					
				
				}
				
				// if no entrys were added
				
				else if ((indicator ==0 && indicator2 ==0))
				{
					System.out.println("Add a new entry");
				}
				
				// parse through both array lists of stocks and mutual funds if both were added 
				else if (indicator == 3)
				{
					
					System.out.println("Enter Symbol for investment: ");
					Scanner scannerObjectxx = new Scanner(System.in);
					String sellsymbol = scannerObjectxx.nextLine();
					
					System.out.println("Enter Actual Price: ");
					Scanner scannerObjectxp = new Scanner(System.in);
					while (true) {
						try {
						sellprice = scannerObjectxp.nextDouble();
						break;
						} catch(InputMismatchException e) {
						System.out.println("Please enter valid price");
						scannerObjectxp.nextLine();
						
						}
					}	
					
					System.out.println("Enter a quantity value: ");
					Scanner scannerObjectxrp = new Scanner(System.in);
					while (true) {
						try {
						sellq = scannerObjectxrp.nextInt();
						break;
						} catch(InputMismatchException e) {
						System.out.println("Please enter a valid quantity");
						scannerObjectxrp.nextLine();
						
						}
					}
					
					
					//matching the symbol entered for stocks
					for (int o = this.stock.size() -1; o >=0 ; o--) 
					{
						if(this.stock.get(o).symbol.contains(sellsymbol))  
						{
							System.out.println(this.stock.get(o));
							sellsbv = invest1.sellsbookv(sellq, this.stock.get(o).quantity, this.stock.get(o).bookValue, sellprice);
							this.stock.get(o).bookValue = sellsbv;
							this.stock.get(o).quantity = this.stock.get(o).quantity - sellq;
							
							
							if (this.stock.get(o).bookValue <= 0)
							{
									
								this.stock.remove(o);
								
							}
							else if (this.stock.get(o).quantity == 0)
							{
								this.stock.remove(o);
							}
							
						 
						}
						
						else 
						{
							System.out.println("No stock found");
						}
					
					}
					
					
					//matching the symbol entered for stocks
					for (int o= this.mutual.size()-1; o >=0 ; o--) 
					{
						if(this.mutual.get(o).symbol.contains(sellsymbol)) 
						{
							sellmbv = invest1.sellmbookv(sellq, this.mutual.get(o).quantity , this.mutual.get(o).bookValue, sellprice);
							this.mutual.get(o).bookValue = sellmbv;
							this.mutual.get(o).quantity = this.mutual.get(o).quantity - sellq;
							
							
							if (this.mutual.get(o).bookValue <= 0)
							{
								
									this.mutual.remove(o);
		
									
								
							}
							else if (this.stock.get(o).quantity == 0)
							{
								this.mutual.remove(o);
							}
							
						 
						}
					
						else 
						{
							System.out.println("No mutual fund found");
						}
					}
					
					
					
					
					
				}
				
				
			}
			/*
			 * 
			 * Update
			 * 
			 * 
			 */
			if (ind.equals("3"))
			{
				System.out.println("******UPDATE********");
				
				//parses through stocks if a stock was added
				if (total >= 1 && x >= 1)
				{
					for (int o= this.stock.size()-1; o >=0 ; o--) 
					{
						System.out.println("Please Enter a new price for: " +this.stock.get(o).name);
						Scanner scannerObjectxp1 = new Scanner(System.in);
						while (true) {
							try {
							updateprice = scannerObjectxp1.nextDouble();
							break;
							} catch(InputMismatchException e) {
							System.out.println("Please enter valid price");
							scannerObjectxp1.nextLine();
							
							}
						}
						
						//find the value of bookvalue before it gets updated
						spre = this.stock.get(o).bookValue;
						double upbookv = invest1.updateprice(this.stock.get(o).quantity, updateprice, this.stock.get(o).bookValue);
						
						//update the new price
						this.stock.get(o).price = updateprice;
						
						gain = invest1.gain(spre, upbookv);
						totalgain = totalgain + gain;
					
						
						System.out.println("Updated Listing ");
						
						for(int i=0; i<this.stock.size(); i++)
						{

							System.out.println(this.stock.get(i));
				        }
						
					}
				}
				
				//parses through mutual funds if a mutual fund was added , same way it parses through stocks
				if (total >= 1 && y >= 1)
				{
				
					for (int o= this.mutual.size()-1; o >=0 ; o--) 
					{
						System.out.println("Please Enter a new price for: " +this.mutual.get(o).name);
						Scanner scannerObjectxp2 = new Scanner(System.in);
						while (true) {
							try {
							updateprice2 = scannerObjectxp2.nextDouble();
							break;
							} catch(InputMismatchException e) {
							System.out.println("Please enter valid price");
							scannerObjectxp2.nextLine();
							
							}
						}
						
						
						
						
						mpre = this.mutual.get(o).bookValue;
						double upbookv2 = invest1.updatepricem(this.mutual.get(o).quantity, updateprice2, this.mutual.get(o).bookValue);
						this.mutual.get(o).price = updateprice2;
						
						
						gain = invest1.gain(mpre, upbookv2);
						totalgain = totalgain + gain;
						
						System.out.println("Updated Listing ");
						
						for(int i=0; i<this.mutual.size(); i++)
						{

							System.out.println(this.mutual.get(i));
				        }
						
					}
					
					
				}
				
				else 
				{
					System.out.println("Please add a stock or mutual fund");
				}
				
				
			
				
			}
			
			//print out total gain
			if (ind.equals("4"))
			{
				if ((indicator ==0 && indicator2 ==0))
				{
					System.out.println("Add a new entry");
				}
				
				else
				{
					System.out.println("Your total gain of your portfolio is: "+totalgain);
				}
			}
				
			
			
			
			
			if (ind.equals("5"))
			{
			
				System.out.println("***********Search*************");
				
				
				// only look at stocks if only stocks were added
				
				if (total >= 0 && y == 0) 
				{
					System.out.println("Enter the Symbols: ");
					Scanner scannerObjectx11 = new Scanner(System.in);
					String sym1 = scannerObjectx11.nextLine();
					String zcase = sym1;
					
					if (sym1.equals("")) //if symbols is blank
					{
						System.out.println("Enter a keyword: ");
						Scanner scannerObjectx12 = new Scanner(System.in);
						String sym2 = scannerObjectx12.nextLine();
						String case1 = sym2;
					
						if (sym2.equals("")) //name is blank
						{
						
							System.out.println("Range of prices");
							Scanner scannero = new Scanner (System.in);
							String sym3 = scannero.nextLine();
							char[] pretest = sym3.toCharArray();
							
							
							if (sym3.equals("")) // range is blank
							{
								//prints everything if its blank
								for (int o=0; o < this.stock.size(); o++) 
								{
									
									
										System.out.println(this.stock.get(o));
								
									
								}
							}
							
							else
							{
								//looks through the range of prices entered
								if (!sym3.contains("-")) // if the string has no character
								{
								
									int c = Integer.valueOf(sym3);
									for (int o= this.stock.size()-1; o >=0 ; o--) 
									{
										
										if (this.stock.get(o).price == c)
										{
											System.out.println(this.stock.get(o));
										}
										
										
										
									}
								}
								
								else if(pretest[0] == '-') // if the first character is -
								{
								
									String[] range = sym3.split("-");
									int rx = Integer.valueOf(range[1]);
						
									for (int o= this.stock.size()-1; o >=0 ; o--) 
									{
										
										if (this.stock.get(o).price < rx)
										{
											System.out.println(this.stock.get(o));
										}
										
										
										
									}
									
									
								}
								
								else if(sym3.endsWith("-")) //if the last character is - 
								{
								
									String[] range = sym3.split("-");
									int rp = Integer.valueOf(range[0]);
									for (int o= this.stock.size()-1; o >=0 ; o--) 
									{
										
										if (this.stock.get(o).price > rp)
										{
											System.out.println(this.stock.get(o));
										}
										
										
										
									}
								}
								
								else 
								{
									//string is regular range 
									
									String[] range = sym3.split("-");
									int r1 = Integer.valueOf(range[0]);
									int r2 = Integer.valueOf(range[1]);
									for (int o= this.stock.size()-1; o >=0 ; o--) 
									{
										
										if (this.stock.get(o).price > r1 && this.stock.get(o).price < r2)
										{
											System.out.println(this.stock.get(o));
										}
										
										
										
									}
								}
								
							
								
							}
							
						}
						//searching with no symbol, only name entry
						else 
						{
							
							System.out.println("Range of prices");
							Scanner scannero1 = new Scanner (System.in);
							String sym6 = scannero1.nextLine();
							char[] pretest1 = sym6.toCharArray();
							
							if (sym6.equals(""))
							
							// if range of prices is blank print everything
							{
							
								for (int o=0; o < this.stock.size(); o++) 
								{
									Boolean correct = Arrays.asList(this.stock.get(o).name.toLowerCase().split(" ")).contains(case1.toLowerCase()); 
									if (correct)
									{
										System.out.println(this.stock.get(o));
									}
								}
							}
							else 
							{
								
								//range finder
								
								if (!sym6.contains("-")) // if the string does not contain the - character
								{
									System.out.println("nothinghere");
									int c = Integer.valueOf(sym6);
									for (int o= this.stock.size()-1; o >=0 ; o--) 
									{
										
										if (this.stock.get(o).price == c && this.stock.get(o).name.toLowerCase().equals(case1.toLowerCase()))
										{
											System.out.println(this.stock.get(o));
										}
										
										
										
									}
								}
								
								else if(pretest1[0] == '-') //if the string has the format -x 
								{
									System.out.println("caught");
									String[] range = sym6.split("-");
									int rx = Integer.valueOf(range[1]);
						
									for (int o= this.stock.size()-1; o >=0 ; o--) 
									{
										
										if (this.stock.get(o).price < rx && this.stock.get(o).name.toLowerCase().equals(case1.toLowerCase()))
										{
											System.out.println(this.stock.get(o));
										}
										
										
										
									}
									
									
								}
								
								else if(sym6.endsWith("-")) // if the string has the format x- 
								{
									System.out.println("hur");
									String[] range = sym6.split("-");
									int rp = Integer.valueOf(range[0]);
									for (int o= this.stock.size()-1; o >=0 ; o--) 
									{
										
										if (this.stock.get(o).price > rp && this.stock.get(o).name.toLowerCase().equals(case1.toLowerCase()))
										{
											System.out.println(this.stock.get(o));
										}
										
										
										
									}
								}
								
								else //if the string has a regular format of x - x 
								{
									System.out.println("working");
									String[] range = sym6.split("-");
									int r1 = Integer.valueOf(range[0]);
									int r2 = Integer.valueOf(range[1]);
									for (int o= this.stock.size()-1; o >=0 ; o--) 
									{
										
										if (this.stock.get(o).price > r1 && this.stock.get(o).price < r2 && this.stock.get(o).name.toLowerCase().equals(case1.toLowerCase()))
										{
											System.out.println(this.stock.get(o));
										}
										
										
										
									}
								}
								//end of range
							}
							
						}
						// end of blank symbol , name entry, and price entry
						
						
					}
					
					else // if symbol has a user entry 
					{
						System.out.println("Enter a keyword: ");
						Scanner scannerObjectx16 = new Scanner(System.in);
						String symx = scannerObjectx16.nextLine();
						String case2 = symx;
						
						if (symx.equals("")) //if keyword is blank
						{
					
							System.out.println("Range of prices");
							Scanner scannero1 = new Scanner (System.in);
							String symq = scannero1.nextLine();
							String case21 = symq;
							char[] pretest4 = symq.toCharArray();
							
							if (case21.equals("")) //if ranges is blank
							{
			
								for (int o=0; o < this.stock.size(); o++) 
								{
									if (this.stock.get(o).symbol.toLowerCase().equals(zcase.toLowerCase()))
									{
										System.out.println(this.stock.get(o));
									}
								}
							}
							
							else
							{
								//range finder
								//if ranges of prices are not blank 
								if (!symq.contains("-"))
								{
									
									int c = Integer.valueOf(symq);
									for (int o= this.stock.size()-1; o >=0 ; o--) 
									{
										
										if (this.stock.get(o).price == c && this.stock.get(o).symbol.toLowerCase().equals(zcase.toLowerCase()))
										{
											System.out.println(this.stock.get(o));
										}
										
										
										
									}
								}
								
								else if(pretest4[0] == '-')
								{
									System.out.println("caught");
									String[] range = symq.split("-");
									int rx = Integer.valueOf(range[1]);
							
									for (int o= this.stock.size()-1; o >=0 ; o--) 
									{
										
										if (this.stock.get(o).price < rx && this.stock.get(o).symbol.toLowerCase().equals(zcase.toLowerCase()))
										{
											System.out.println(this.stock.get(o));
										}
										
										
										
									}
									
									
								}
								
								else if(symq.endsWith("-"))
								{
									System.out.println("hur");
									String[] range = symq.split("-");
									int rp = Integer.valueOf(range[0]);
									for (int o= this.stock.size()-1; o >=0 ; o--) 
									{
										
										if (this.stock.get(o).price > rp && this.stock.get(o).symbol.toLowerCase().equals(zcase.toLowerCase()))
										{
											System.out.println(this.stock.get(o));
										}
										
										
										
									}
								}
								
								else 
								{
									System.out.println("working");
									String[] range = symq.split("-");
									int r1 = Integer.valueOf(range[0]);
									int r2 = Integer.valueOf(range[1]);
									for (int o= this.stock.size()-1; o >=0 ; o--) 
									{
										
										if (this.stock.get(o).price > r1 && this.stock.get(o).price < r2 && this.stock.get(o).symbol.toLowerCase().equals(zcase.toLowerCase()))
										{
											System.out.println(this.stock.get(o));
										}
										
										
										
									}
								}
								
							}
							
							
						}
						
						else // if the name is not blank 
						{
							System.out.println("Range of prices");
							Scanner scannero1 = new Scanner (System.in);
							String sym00 = scannero1.nextLine();
							char[] pretest5 = sym00.toCharArray();
							
							
							if (sym00.equals("")) 
							{
								for (int o=0; o < this.stock.size(); o++) 
								{
									if (this.stock.get(o).symbol.toLowerCase().equals(zcase.toLowerCase()) &&this.stock.get(o).name.toLowerCase().equals(case2.toLowerCase()))
									{
										System.out.println(this.stock.get(o));
									}
								}
							}
							
							
							else
							{
								//range finder
								if (!sym00.contains("-"))
								{
								
									int c = Integer.valueOf(sym00);
									for (int o= this.stock.size()-1; o >=0 ; o--) 
									{
										
										if (this.stock.get(o).price == c  && this.stock.get(o).symbol.toLowerCase().equals(zcase.toLowerCase()) &&this.stock.get(o).name.toLowerCase().equals(case2.toLowerCase()))
										{
											System.out.println(this.stock.get(o));
										}
										
										
										
									}
								}
								
								else if(pretest5[0] == '-')
								{
									
									String[] range = sym00.split("-");
									int rx = Integer.valueOf(range[1]);
					
									for (int o= this.stock.size()-1; o >=0 ; o--) 
									{
										
										if (this.stock.get(o).price < rx  && this.stock.get(o).symbol.toLowerCase().equals(zcase.toLowerCase()) &&this.stock.get(o).name.toLowerCase().equals(case2.toLowerCase()))
										{
											System.out.println(this.stock.get(o));
										}
										
										
										
									}
									
									
								}
								
								else if(sym00.endsWith("-"))
								{
									
									String[] range = sym00.split("-");
									int rp = Integer.valueOf(range[0]);
									for (int o= this.stock.size()-1; o >=0 ; o--) 
									{
										
										if (this.stock.get(o).price > rp  && this.stock.get(o).symbol.toLowerCase().equals(zcase.toLowerCase()) &&this.stock.get(o).name.toLowerCase().equals(case2.toLowerCase()))
										{
											System.out.println(this.stock.get(o));
										}
										
										
										
									}
								}
								
								else 
								{
									
									String[] range = sym00.split("-");
									int r1 = Integer.valueOf(range[0]);
									int r2 = Integer.valueOf(range[1]);
									for (int o= this.stock.size()-1; o >=0 ; o--) 
									{
										
										if (this.stock.get(o).price > r1 && this.stock.get(o).price < r2  && this.stock.get(o).symbol.toLowerCase().equals(zcase.toLowerCase()) &&this.stock.get(o).name.toLowerCase().equals(case2.toLowerCase()))
										{
											System.out.println(this.stock.get(o));
										}
										
										
										
									}
								}
							}
							
						}
						
					}
						
					
				}
				
				
				//Parses through mutual funds only, exact same type of code as above but only looks through mutual funds array
				
				
				if (total >= 1 && x == 0)
				{
					System.out.println("Enter the Symbol: ");
					Scanner scannerObjectx11 = new Scanner(System.in);
					String sym1 = scannerObjectx11.nextLine();
					String zcase = sym1;
					
					if (sym1.equals(""))
					{
						System.out.println("Enter a keyword: ");
						Scanner scannerObjectx12 = new Scanner(System.in);
						String sym2 = scannerObjectx12.nextLine();
						String case1 = sym2;
					
						if (sym2.equals(""))
						{
						
							System.out.println("Range of prices");
							Scanner scannero = new Scanner (System.in);
							String sym3 = scannero.nextLine();
							char[] pretest6 = sym3.toCharArray();
							
							if (sym3.equals(""))
							{
								for (int o=0; o < this.mutual.size(); o++) 
								{
									
									
										System.out.println(this.mutual.get(o));
								
									
								}
							}
							
							else
							{
								//range finder
								if (!sym3.contains("-"))
								{
							
									int c = Integer.valueOf(sym3);
									for (int o= this.stock.size()-1; o >=0 ; o--) 
									{
										
										if (this.mutual.get(o).price == c)
										{
											System.out.println(this.mutual.get(o));
										}
										
										
										
									}
								}
								
								else if(pretest6[0] == '-')
								{
						
									String[] range = sym3.split("-");
									int rx = Integer.valueOf(range[1]);
							
									for (int o= this.mutual.size()-1; o >=0 ; o--) 
									{
										
										if (this.mutual.get(o).price < rx)
										{
											System.out.println(this.mutual.get(o));
										}
										
										
										
									}
									
									
								}
								
								else if(sym3.endsWith("-"))
								{
						
									String[] range = sym3.split("-");
									int rp = Integer.valueOf(range[0]);
									for (int o= this.mutual.size()-1; o >=0 ; o--) 
									{
										
										if (this.mutual.get(o).price > rp)
										{
											System.out.println(this.mutual.get(o));
										}
										
										
										
									}
								}
								
								else 
								{
				
									String[] range = sym3.split("-");
									int r1 = Integer.valueOf(range[0]);
									int r2 = Integer.valueOf(range[1]);
									for (int o= this.mutual.size()-1; o >=0 ; o--) 
									{
										
										if (this.mutual.get(o).price > r1 && this.mutual.get(o).price < r2)
										{
											System.out.println(this.mutual.get(o));
										}
										
										
										
									}
								}
								//end of 
							}
							
						}
						else 
						{
							
							System.out.println("Range of prices");
							Scanner scannero1 = new Scanner (System.in);
							String sym6 = scannero1.nextLine();
							char[] pretestx = sym6.toCharArray();
							
							if (sym6.equals(""))
								
							{
			
								for (int o=0; o < this.mutual.size(); o++) 
								{
									Boolean correct = Arrays.asList(this.mutual.get(o).name.toLowerCase().split(" ")).contains(case1.toLowerCase()); 
									if (correct)
									{
										System.out.println(this.mutual.get(o));
									}
								}
							}
							else 
							{
								//range finder
								//range finder
								if (!sym6.contains("-"))
								{
				
									int c = Integer.valueOf(sym6);
									for (int o= this.stock.size()-1; o >=0 ; o--) 
									{
										
										if (this.mutual.get(o).price == c && this.mutual.get(o).name.toLowerCase().equals(case1.toLowerCase()))
										{
											System.out.println(this.mutual.get(o));
										}
										
										
										
									}
								}
								
								else if(pretestx[0] == '-')
								{
							
									String[] range = sym6.split("-");
									int rx = Integer.valueOf(range[1]);
								
									for (int o= this.mutual.size()-1; o >=0 ; o--) 
									{
										
										if (this.mutual.get(o).price < rx  && this.mutual.get(o).name.toLowerCase().equals(case1.toLowerCase()))
										{
											System.out.println(this.mutual.get(o));
										}
										
										
										
									}
									
									
								}
								
								else if(sym6.endsWith("-"))
								{
							
									String[] range = sym6.split("-");
									int rp = Integer.valueOf(range[0]);
									for (int o= this.mutual.size()-1; o >=0 ; o--) 
									{
										
										if (this.mutual.get(o).price > rp  && this.mutual.get(o).name.toLowerCase().equals(case1.toLowerCase()))
										{
											System.out.println(this.mutual.get(o));
										}
										
										
										
									}
								}
								
								else 
								{
					
									String[] range = sym6.split("-");
									int r1 = Integer.valueOf(range[0]);
									int r2 = Integer.valueOf(range[1]);
									for (int o= this.mutual.size()-1; o >=0 ; o--) 
									{
										
										if (this.mutual.get(o).price > r1 && this.mutual.get(o).price < r2  && this.mutual.get(o).name.toLowerCase().equals(case1.toLowerCase()))
										{
											System.out.println(this.mutual.get(o));
										}
										
										
										
									}
								}
							}
							
						}
						
						
						
					}
					
					//with symbol
					else
					{
						System.out.println("Enter a keyword: ");
						Scanner scannerObjectx16 = new Scanner(System.in);
						String symx = scannerObjectx16.nextLine();
						String case2 = symx;
						
						if (symx.equals(""))
						{
					
							System.out.println("Range of prices");
							Scanner scannero1 = new Scanner (System.in);
							String symq = scannero1.nextLine();
							String case21 = symq;
							char[] pretests = symq.toCharArray();
							
							
							if (case21.equals(""))
							{
						
								for (int o=0; o < this.mutual.size(); o++) 
								{
									if (this.mutual.get(o).symbol.toLowerCase().equals(zcase.toLowerCase()))
									{
										System.out.println(this.mutual.get(o));
									}
								}
								
							}
							
							else
							{
								
								
								//range finder
								//range finder
								if (!symq.contains("-"))
								{
							
									int c = Integer.valueOf(symq);
									for (int o= this.stock.size()-1; o >=0 ; o--) 
									{
										
										if (this.mutual.get(o).price == c && this.mutual.get(o).symbol.toLowerCase().equals(zcase.toLowerCase()))
										{
											System.out.println(this.mutual.get(o));
										}
										
										
										
									}
								}
								
								else if(pretests[0] == '-')
								{
						
									String[] range = symq.split("-");
									int rx = Integer.valueOf(range[1]);
						
									for (int o= this.mutual.size()-1; o >=0 ; o--) 
									{
										
										if (this.mutual.get(o).price < rx && this.mutual.get(o).symbol.toLowerCase().equals(zcase.toLowerCase()))
										{
											System.out.println(this.mutual.get(o));
										}
										
										
										
									}
									
									
								}
								
								else if(symq.endsWith("-"))
								{
									String[] range = symq.split("-");
									int rp = Integer.valueOf(range[0]);
									for (int o= this.mutual.size()-1; o >=0 ; o--) 
									{
										
										if (this.mutual.get(o).price > rp && this.mutual.get(o).symbol.toLowerCase().equals(zcase.toLowerCase()))
										{
											System.out.println(this.mutual.get(o));
										}
										
										
										
									}
								}
								
								else 
								{
				
									String[] range = symq.split("-");
									int r1 = Integer.valueOf(range[0]);
									int r2 = Integer.valueOf(range[1]);
									for (int o= this.mutual.size()-1; o >=0 ; o--) 
									{
										
										if (this.mutual.get(o).price > r1 && this.mutual.get(o).price < r2 && this.mutual.get(o).symbol.toLowerCase().equals(zcase.toLowerCase()))
										{
											System.out.println(this.mutual.get(o));
										}
										
										
										
									}
								}
							}
							
							
						}
						
						else
						{
							System.out.println("Range of prices");
							Scanner scannero1 = new Scanner (System.in);
							String sym6 = scannero1.nextLine();
							char[] pretesti = sym6.toCharArray();
							
							
							if (sym6.equals("")) 
							{
								for (int o=0; o < this.mutual.size(); o++) 
								{
									if (this.mutual.get(o).symbol.toLowerCase().equals(zcase.toLowerCase()) && this.mutual.get(o).name.toLowerCase().equals(case2.toLowerCase()))
									{
										System.out.println(this.mutual.get(o));
									}
								}
							}
							
							//range finder
							//range finder
							if (!sym6.contains("-"))
							{
			
								int c = Integer.valueOf(sym6);
								for (int o= this.stock.size()-1; o >=0 ; o--) 
								{
									
									if (this.mutual.get(o).price == c && this.mutual.get(o).symbol.toLowerCase().equals(zcase.toLowerCase()) && this.mutual.get(o).name.toLowerCase().equals(case2.toLowerCase()))
									{
										System.out.println(this.mutual.get(o));
									}
									
									
									
								}
							}
							
							else if(pretesti[0] == '-')
							{
					
								String[] range = sym6.split("-");
								int rx = Integer.valueOf(range[1]);
						
								for (int o= this.mutual.size()-1; o >=0 ; o--) 
								{
									
									if (this.mutual.get(o).price < rx && this.mutual.get(o).symbol.toLowerCase().equals(zcase.toLowerCase()) && this.mutual.get(o).name.toLowerCase().equals(case2.toLowerCase()))
									{
										System.out.println(this.mutual.get(o));
									}
									
									
									
								}
								
								
							}
							
							else if(sym6.endsWith("-"))
							{
					
								String[] range = sym6.split("-");
								int rp = Integer.valueOf(range[0]);
								for (int o= this.mutual.size()-1; o >=0 ; o--) 
								{
									
									if (this.mutual.get(o).price > rp && this.mutual.get(o).symbol.toLowerCase().equals(zcase.toLowerCase()) && this.mutual.get(o).name.toLowerCase().equals(case2.toLowerCase()))
									{
										System.out.println(this.mutual.get(o));
									}
									
									
									
								}
							}
							
							else 
							{
			
								String[] range = sym6.split("-");
								int r1 = Integer.valueOf(range[0]);
								int r2 = Integer.valueOf(range[1]);
								for (int o= this.mutual.size()-1; o >=0 ; o--) 
								{
									
									if (this.mutual.get(o).price > r1 && this.mutual.get(o).price < r2 && this.mutual.get(o).symbol.toLowerCase().equals(zcase.toLowerCase()) && this.mutual.get(o).name.toLowerCase().equals(case2.toLowerCase()))
									{
										System.out.println(this.mutual.get(o));
									}
									
									
									
								}
							}
						}
						
					}
				}
				
				
				// parses through both mutual and stock array lists if they exist, same code as above but checks both mutual funds and stocks funds, combined the two for loops
				if (total >1 && y >= 1 && x >=1)
				{
				
					;System.out.println("Enter the Symbols: ");
					Scanner scannerObjectx11 = new Scanner(System.in);
					String sym1 = scannerObjectx11.nextLine();
					String zcase = sym1;
					
					if (sym1.equals(""))
					{
						System.out.println("Enter a keyword: ");
						Scanner scannerObjectx12 = new Scanner(System.in);
						String sym2 = scannerObjectx12.nextLine();
						String case1 = sym2;
					
						if (sym2.equals(""))
						{
				
							System.out.println("Range of prices");
							Scanner scannero = new Scanner (System.in);
							String sym3 = scannero.nextLine();
							char[] pretest = sym3.toCharArray();
							
							
							if (sym3.equals(""))
							{
								for (int o=0; o < this.stock.size(); o++) 
								{
									
									
										System.out.println(this.stock.get(o));
								
									
								}
								
								for (int o=0; o < this.mutual.size(); o++) 
								{
									
									
										System.out.println(this.mutual.get(o));
								
									
								}
							}
							
							else
							{
								//range finder
								if (!sym3.contains("-"))
								{
							
									int c = Integer.valueOf(sym3);
									for (int o= this.stock.size()-1; o >=0 ; o--) 
									{
										
										if (this.stock.get(o).price == c)
										{
											System.out.println(this.stock.get(o));
										}
										
										
										
									}
									
									for (int o= this.mutual.size()-1; o >=0 ; o--) 
									{
										
										if (this.mutual.get(o).price == c)
										{
											System.out.println(this.mutual.get(o));
										}
										
										
										
									}
								}
								
								else if(pretest[0] == '-')
								{
							
									String[] range = sym3.split("-");
									int rx = Integer.valueOf(range[1]);
						
									for (int o= this.stock.size()-1; o >=0 ; o--) 
									{
										
										if (this.stock.get(o).price < rx)
										{
											System.out.println(this.stock.get(o));
										}
										
										
										
									}
									
									for (int o= this.mutual.size()-1; o >=0 ; o--) 
									{
										
										if (this.mutual.get(o).price < rx)
										{
											System.out.println(this.mutual.get(o));
										}
										
										
										
									}
									
									
								}
								
								else if(sym3.endsWith("-"))
								{
							
									String[] range = sym3.split("-");
									int rp = Integer.valueOf(range[0]);
									for (int o= this.stock.size()-1; o >=0 ; o--) 
									{
										
										if (this.stock.get(o).price > rp)
										{
											System.out.println(this.stock.get(o));
										}
										
										
										
									}
									
									for (int o= this.mutual.size()-1; o >=0 ; o--) 
									{
										
										if (this.mutual.get(o).price > rp)
										{
											System.out.println(this.mutual.get(o));
										}
										
										
										
									}
								}
								
								else 
								{
					
									String[] range = sym3.split("-");
									int r1 = Integer.valueOf(range[0]);
									int r2 = Integer.valueOf(range[1]);
									for (int o= this.stock.size()-1; o >=0 ; o--) 
									{
										
										if (this.stock.get(o).price > r1 && this.stock.get(o).price < r2)
										{
											System.out.println(this.stock.get(o));
										}
										
										
										
									}
									
									for (int o= this.mutual.size()-1; o >=0 ; o--) 
									{
										
										if (this.mutual.get(o).price > r1 && this.mutual.get(o).price < r2)
										{
											System.out.println(this.mutual.get(o));
										}
										
										
										
									}
								}
								
							
								
							}
							
						}
						else 
						{
					
							System.out.println("Range of prices");
							Scanner scannero1 = new Scanner (System.in);
							String sym6 = scannero1.nextLine();
							char[] pretest1 = sym6.toCharArray();
							
							if (sym6.equals(""))
								
							{
				
								for (int o=0; o < this.stock.size(); o++) 
								{
									Boolean correct = Arrays.asList(this.stock.get(o).name.toLowerCase().split(" ")).contains(case1.toLowerCase()); 
									if (correct)
									{
										System.out.println(this.stock.get(o));
									}
								}
								
								
								for (int o=0; o < this.mutual.size(); o++) 
								{
									Boolean correct = Arrays.asList(this.mutual.get(o).name.toLowerCase().split(" ")).contains(case1.toLowerCase()); 
									if (correct)
									{
										System.out.println(this.mutual.get(o));
									}
								}
							}
							else 
							{
								
								//range finder
								//
								// EMPTY SYMBOL , but name case is satisfied 
								///
								// 
								if (!sym6.contains("-"))
								{
						
									int c = Integer.valueOf(sym6);
									for (int o= this.stock.size()-1; o >=0 ; o--) 
									{
										
										if (this.stock.get(o).price == c && this.stock.get(o).name.toLowerCase().equals(case1.toLowerCase()))
										{
											System.out.println(this.stock.get(o));
										}
										
										
										
									}
									
									for (int o= this.mutual.size()-1; o >=0 ; o--) 
									{
										
										if (this.mutual.get(o).price == c && this.mutual.get(o).name.toLowerCase().equals(case1.toLowerCase()))
										{
											System.out.println(this.mutual.get(o));
										}
										
										
										
									}
								}
								
								else if(pretest1[0] == '-')
								{
							
									String[] range = sym6.split("-");
									int rx = Integer.valueOf(range[1]);
						
									for (int o= this.stock.size()-1; o >=0 ; o--) 
									{
										
										if (this.stock.get(o).price < rx && this.stock.get(o).name.toLowerCase().equals(case1.toLowerCase()))
										{
											System.out.println(this.stock.get(o));
										}
										
										
										
									}
									
									
									for (int o= this.mutual.size()-1; o >=0 ; o--) 
									{
										
										if (this.mutual.get(o).price < rx && this.mutual.get(o).name.toLowerCase().equals(case1.toLowerCase()))
										{
											System.out.println(this.mutual.get(o));
										}
										
										
										
									}
									
								}
								
								else if(sym6.endsWith("-"))
								{
						
									String[] range = sym6.split("-");
									int rp = Integer.valueOf(range[0]);
									for (int o= this.stock.size()-1; o >=0 ; o--) 
									{
										
										if (this.stock.get(o).price > rp && this.stock.get(o).name.toLowerCase().equals(case1.toLowerCase()))
										{
											System.out.println(this.stock.get(o));
										}
										
										
										
									}
									
									for (int o= this.mutual.size()-1; o >=0 ; o--) 
									{
										
										if (this.mutual.get(o).price > rp && this.mutual.get(o).name.toLowerCase().equals(case1.toLowerCase()))
										{
											System.out.println(this.mutual.get(o));
										}
										
										
										
									}
								}
								
								else 
								{
					
									String[] range = sym6.split("-");
									int r1 = Integer.valueOf(range[0]);
									int r2 = Integer.valueOf(range[1]);
									for (int o= this.stock.size()-1; o >=0 ; o--) 
									{
										
										if (this.stock.get(o).price > r1 && this.stock.get(o).price < r2 && this.stock.get(o).name.toLowerCase().equals(case1.toLowerCase()))
										{
											System.out.println(this.stock.get(o));
										}
										
										
										
									}
									
									
									for (int o= this.mutual.size()-1; o >=0 ; o--) 
									{
										
										if (this.mutual.get(o).price > r1 && this.mutual.get(o).price < r2&& this.mutual.get(o).name.toLowerCase().equals(case1.toLowerCase()))
										{
											System.out.println(this.mutual.get(o));
										}
										
										
										
									}
								}
								//end of range
							}
							
						}
						
						
						
					}
					
					//symbol not blank
					else
					{
						System.out.println("Enter a keyword: ");
						Scanner scannerObjectx16 = new Scanner(System.in);
						String symx = scannerObjectx16.nextLine();
						String case2 = symx;
						
						if (symx.equals("")) //keyword bank
						{
							
							System.out.println("Range of prices");
							Scanner scannero1 = new Scanner (System.in);
							String symq = scannero1.nextLine();
							String case21 = symq;
							char[] pretest4 = symq.toCharArray();
							
							if (case21.equals(""))
							{
							
								for (int o=0; o < this.stock.size(); o++) 
								{
									if (this.stock.get(o).symbol.toLowerCase().equals(zcase.toLowerCase()))
									{
										System.out.println(this.stock.get(o));
									}
								}
								
								for (int o=0; o < this.mutual.size(); o++) 
								{
									if (this.mutual.get(o).symbol.toLowerCase().equals(zcase.toLowerCase()))
									{
										System.out.println(this.mutual.get(o));
									}
								}
							}
							
							else
							{
								//range finder
								if (!symq.contains("-"))
								{
						
									int c = Integer.valueOf(symq);
									for (int o= this.stock.size()-1; o >=0 ; o--) 
									{
										
										if (this.stock.get(o).price == c && this.stock.get(o).symbol.toLowerCase().equals(zcase.toLowerCase()))
										{
											System.out.println(this.stock.get(o));
										}
										
										
										
									}
									
									for (int o= this.mutual.size()-1; o >=0 ; o--) 
									{
										
										if (this.mutual.get(o).price == c && this.mutual.get(o).symbol.toLowerCase().equals(zcase.toLowerCase()))
										{
											System.out.println(this.mutual.get(o));
										}
										
										
										
									}
								}
								
								else if(pretest4[0] == '-')
								{
		
									String[] range = symq.split("-");
									int rx = Integer.valueOf(range[1]);
				
									for (int o= this.stock.size()-1; o >=0 ; o--) 
									{
										
										if (this.stock.get(o).price < rx && this.stock.get(o).symbol.toLowerCase().equals(zcase.toLowerCase()))
										{
											System.out.println(this.stock.get(o));
										}
										
										
										
									}
									
									for (int o= this.mutual.size()-1; o >=0 ; o--) 
									{
										
										if (this.mutual.get(o).price < rx && this.mutual.get(o).symbol.toLowerCase().equals(zcase.toLowerCase()))
										{
											System.out.println(this.mutual.get(o));
										}
										
										
										
									}
									
								}
								
								else if(symq.endsWith("-"))
								{
						
									String[] range = symq.split("-");
									int rp = Integer.valueOf(range[0]);
									for (int o= this.stock.size()-1; o >=0 ; o--) 
									{
										
										if (this.stock.get(o).price > rp && this.stock.get(o).symbol.toLowerCase().equals(zcase.toLowerCase()))
										{
											System.out.println(this.stock.get(o));
										}
										
										
										
									}
									
									for (int o= this.mutual.size()-1; o >=0 ; o-- ) 
									{
										
										if (this.mutual.get(o).price > rp && this.mutual.get(o).symbol.toLowerCase().equals(zcase.toLowerCase()))
										{
											System.out.println(this.mutual.get(o));
										}
										
										
										
									}
								}
								
								else 
								{
							
									String[] range = symq.split("-");
									int r1 = Integer.valueOf(range[0]);
									int r2 = Integer.valueOf(range[1]);
									for (int o= this.stock.size()-1; o >=0 ; o--) 
									{
										
										if (this.stock.get(o).price > r1 && this.stock.get(o).price < r2 && this.stock.get(o).symbol.toLowerCase().equals(zcase.toLowerCase()) )
										{
											System.out.println(this.stock.get(o));
										}
										
										
										
									}
									
									for (int o= this.mutual.size()-1; o >=0 ; o--) 
									{
										
										if (this.mutual.get(o).price > r1 && this.mutual.get(o).price < r2 && this.mutual.get(o).symbol.toLowerCase().equals(zcase.toLowerCase()))
										{
											System.out.println(this.mutual.get(o));
										}
										
										
										
									}
								}
								
							}
							
							
						}
						
						else
						{
							System.out.println("Range of prices");
							Scanner scannero1 = new Scanner (System.in);
							String sym00 = scannero1.nextLine();
							char[] pretest5 = sym00.toCharArray();
							
							
							if (sym00.equals("")) 
							{
								for (int o=0; o < this.stock.size(); o++) 
								{
									if (this.stock.get(o).symbol.toLowerCase().equals(zcase.toLowerCase()) && this.stock.get(o).name.toLowerCase().equals(case2.toLowerCase()))
									{
										System.out.println(this.stock.get(o));
									}
								}
								
								for (int o=0; o < this.mutual.size(); o++) 
								{
									if (this.mutual.get(o).symbol.toLowerCase().equals(zcase.toLowerCase()) && this.mutual.get(o).name.toLowerCase().equals(case2.toLowerCase()))
									{
										System.out.println(this.mutual.get(o));
									}
								}
							}
							
							
							else
							{
								//range finder
								
							
								if (!sym00.contains("-"))
								{
						
									int c = Integer.valueOf(sym00);
									for (int o= this.stock.size()-1; o >=0 ; o--) 
									{
										
										if (this.stock.get(o).price == c && this.stock.get(o).symbol.toLowerCase().equals(zcase.toLowerCase()) && this.stock.get(o).name.toLowerCase().equals(case2.toLowerCase()))
										{
											System.out.println(this.stock.get(o));
										}
										
										
										
									}
									
									for (int o= this.mutual.size()-1; o >=0 ; o--) 
									{
										
										if (this.mutual.get(o).price == c && this.mutual.get(o).symbol.toLowerCase().equals(zcase.toLowerCase()) && this.mutual.get(o).name.toLowerCase().equals(case2.toLowerCase()))
										{
											System.out.println(this.mutual.get(o));
										}
										
										
										
									}
								}
								
								else if(pretest5[0] == '-')
								{
									String[] range = sym00.split("-");
									int rx = Integer.valueOf(range[1]);
							
									for (int o= this.stock.size()-1; o >=0 ; o--) 
									{
										
										if (this.stock.get(o).price < rx && this.stock.get(o).symbol.toLowerCase().equals(zcase.toLowerCase()) && this.stock.get(o).name.toLowerCase().equals(case2.toLowerCase()))
										{
											System.out.println(this.stock.get(o));
										}
										
										
										
									}
									
									for (int o= this.mutual.size()-1; o >=0 ; o--) 
									{
										
										if (this.mutual.get(o).price < rx && this.mutual.get(o).symbol.toLowerCase().equals(zcase.toLowerCase()) && this.mutual.get(o).name.toLowerCase().equals(case2.toLowerCase()) )
										{
											System.out.println(this.mutual.get(o));
										}
										
										
										
									}
									
								}
								
								else if(sym00.endsWith("-"))
								{
								
									String[] range = sym00.split("-");
									int rp = Integer.valueOf(range[0]);
									for (int o= this.stock.size()-1; o >=0 ; o--) 
									{
										
										if (this.stock.get(o).price > rp && this.stock.get(o).symbol.toLowerCase().equals(zcase.toLowerCase()) && this.stock.get(o).name.toLowerCase().equals(case2.toLowerCase()) )
										{
											System.out.println(this.stock.get(o));
										}
										
										
										
									}
									
									for (int o= this.mutual.size()-1; o >=0 ; o--) 
									{
										
										if (this.mutual.get(o).price > rp && this.mutual.get(o).symbol.toLowerCase().equals(zcase.toLowerCase()) && this.mutual.get(o).name.toLowerCase().equals(case2.toLowerCase()))
										{
											System.out.println(this.mutual.get(o));
										}
										
										
										
									}
								}
								
								else 
								{
							
									String[] range = sym00.split("-");
									int r1 = Integer.valueOf(range[0]);
									int r2 = Integer.valueOf(range[1]);
									for (int o= this.stock.size()-1; o >=0 ; o--) 
									{
										
										if (this.stock.get(o).price > r1 && this.stock.get(o).price < r2 && this.stock.get(o).symbol.toLowerCase().equals(zcase.toLowerCase()) &&this.stock.get(o).name.toLowerCase().equals(case2.toLowerCase()))
										{
											System.out.println(this.stock.get(o));
										}
										
										
										
									}
									
									for (int o= this.mutual.size()-1; o >=0 ; o--) 
									{
										
										if (this.mutual.get(o).price > r1 && this.mutual.get(o).price < r2 && this.mutual.get(o).symbol.toLowerCase().equals(zcase.toLowerCase()) && this.mutual.get(o).name.toLowerCase().equals(case2.toLowerCase()) )
										{
											System.out.println(this.mutual.get(o));
										}
										
										
										
									}
								}
							}
							
						}
						
					}
						
				}
				
				
				
			}
			
			
			//do this for other entrys 
			
			
			if ((ind.equals("6"))|| (ind.toLowerCase().equals("quit") || (ind.toLowerCase().equals("q") ))) //quits program
			{
				command =1 ;
				
			}
			
			else 
			{
				System.out.println("Please enter value from 1 - 6");
			}
			
		} while (command != 1);
		
		
		
	}


	public static void main (String[] args) 
	{
		InvestPortfolio invest = new InvestPortfolio();
		invest.run();
		
	}
	
}
