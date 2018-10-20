package assignment2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;



public class InvestPortfolio {
	
	
	
	
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
	 * Creates array-list for all investments 
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
	 * @param quantity Quantity of stocks
	 * @param price The price of stocks
	 * @return bookv for stocks
	 */
	public double SBV (int quantity, double price) 
	{
		
		
		double comis = 9.99;
		double bookv = (quantity * price) + comis;
		double exact = Math.floor(bookv * 100) / 100;
		
		return exact;
		
	}
	
	/**
	 * Calculates the buy function for funds
	 * @param quantity Quantity of mutual funds
	 * @param price Price of mutual funds
	 * @return The new bookvalue for mutual funds
	 */
	public double MBV (int quantity, double price)
	{
		
		double bookv = (quantity * price);
		
		double exact = Math.floor(bookv *100 ) / 100;
		
		return exact;
	}
	
	/**
	 * 
	 * @param args
	 * Main method to run the entire programs, starts with uploading the files and ends with writing to the file.
	 */
	
	
	
	
	public void run (String[] args) 
	{
		
		HashMap<String, ArrayList<Integer>> searchindex = new HashMap<String, ArrayList<Integer>> ();
		ArrayList<Investment> templist = new ArrayList<>();
		InvestPortfolio inv = new InvestPortfolio();
		 BufferedReader reader;
		 List<String> Reading = new ArrayList<String>();
		 String sent;
         String placer[];
         String symbol;
         String name;
         String ssymbol = null;
         String msymbol = null;
         String[] pricelist;
         int squant = 0;
     	 int quantity;
     	 int option; 
     	 int sellq = 0;
     	 int x = 0;
     	 int mquant = 0;
     	 int r = 0;
     	 int ssellq = 0;
     	 int msellq = 0;
     	 int indic = 0;
     	 double price;
      	 double onep = 0;
		 double lessthan = 0;
		 double morethan = 0;
     	 double mprice = 0;
     	 double sprice =0;
     	 double sellp = 0;
     	 double bookvalue;
     	 double sellsbv = 0;
     	 double sellmbv = 0;
     	 double spre = 0;
     	 double mpre = 0;
     	 double updateprice = 0;
     	 double gain = 0;
     	 double totalgain = 0;
     	 double low = 0;
		 double high = 0;
         Investment temp;
         boolean tester = true;
         boolean end=false;
         String temp111[] = null;
         Random rnd = new Random();
         int scounter = 0;
         int mcounter = 0;
        
         ArrayList<String> hash = new ArrayList<String>();
         ArrayList<String> hashb1 = new ArrayList<String>();
         ArrayList<String> hashb2 = new ArrayList<String>();
         
         try {
             reader = new BufferedReader(new FileReader(args[0]));
             while ((sent = reader.readLine()) != null) {
            	 Reading.add(sent);
             }
             reader.close();
         } catch (IOException e) {
             System.out.println("Failed to read " + args[0] + ".");
         }
     
         
         //reading in file
         for (int i = 0; i < Reading.size(); i++) 
         {
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
        		 scounter ++;
                 temp = new Stock(symbol, name, quantity, price, bookvalue);
             } else {
            	 
            	 mcounter ++;
            	 temp = new MutualFund (symbol, name, quantity, price, bookvalue);
            	 
             }
        	 
        	 templist.add(temp);
        	 
         }
         
         
         this.investments = templist;
         System.out.println("You have loaded:" +scounter+ " Stock Entries");
         System.out.println("You have loaded:" +mcounter+ " MutualFund Entries");
      	 Set<String> unique = new HashSet<String>(hash);
      	 
      	 // count the occurrence of different names
    
  		
      	 for (String key : unique) {
      		
      		
      		//create hashmap for names
      		if (Collections.frequency(hash, key) == 1) {
      			 ArrayList<Integer> location = new ArrayList<Integer>();
      			location.add(rnd.nextInt(10));
      			searchindex.put(key, location);
      			
      			
      		}
      		
      		//create hashmap for names
      		else
      		{
    
      			ArrayList<Integer> templ = new ArrayList<Integer>();
      			for (int x1 = 0; x1 < Collections.frequency(hash, key) ; x1++){
      		   
      				templ.add(rnd.nextInt(10));
      				
      			}
      			searchindex.put(key,templ);
      		}
      		
      		
      		
      		
      	
    
      	 }
      	 
    
      	 System.out.println("Hashmap Search Index: ");
      	 System.out.println(searchindex.toString());
      	 
      	 
      	 
      	 
      	 
      	 
		//menu option
		while (!end)
		{
			System.out.println("\n");
			System.out.println("**************");
			System.out.println("1. Buy:");
			System.out.println("2. Sell:");
			System.out.println("3. Update:");
			System.out.println("4. getGain:");
			System.out.println("5. Search");
			System.out.println("6. Quit");
			
			Scanner scannerObject = new Scanner(System.in);
			String answer = scannerObject.nextLine();
			String ans = answer.toLowerCase();
			
			if (ans.equals("1") || ans.equals("2") || ans.equals("3") || ans.equals("4") || ans.equals("5") || ans.equals("buy") || ans.equals("sell") || ans.equals("update") || ans.equals("getgain") || ans.equals("search") || ans.equals("b") || ans.equals("sel") || ans.equals("u") || ans.equals("g") || ans.equals("sea") || ans.equals("bu") || ans.equals("up") || ans.equals("ge") ) 
			{
                
				//buy option
				if (ans.equals("1") || (ans.equals("buy"))) 
				{
					
					//Entering Stock or mutual fund
					System.out.println("Please enter 1 For Stock or 2 for Mutual Fund");
					x++;
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
					
					//stock option
					if (option == 1) 
					{
						System.out.println("Stock");
						int p = 0;
						tester=true;
						
						//while loop to find if stock already exists
						while (tester == true) {
							System.out.println("Enter Symbol");
							ssymbol = GetScan();
						
							for (int o = 0; o < this.investments.size(); o++) 
							{
								
								if (ssymbol.toLowerCase().equals(this.investments.get(o).getSymbol().toLowerCase()) && this.investments.get(o).getClass().getCanonicalName().equals("assignment2.MutualFund"))
								{
									
							
								System.out.println("Already Exists in mutual fund");
								r = 1;
											
														
								}
			
							}
							if (r == 1)
							{
								p =1; 
							}
							r = 0;

							if (p == 1)
							{
								tester=true;
								p =0;
							}
							else 
							{
								tester=false;
								break;
							}							
						}
						
						
						
						
						System.out.println("Enter a Name");
						String sname = GetScan();
					
						
						//hashmap order book sequence
						temp111 = sname.split(" ");
			        	
						
			        	 for (int p1 = 0; p1 < temp111.length; p1++) {
			        		 hashb1.add(temp111[p1]);
			        		
			        		 
			        	 }
			        	 

			          	 Set<String> unique2 = new HashSet<String>(hashb1);
			       
			          	 
			          	 for (String key : unique2) {
			          		
			          	
			          		
			          		//create hashmap for names
			          		if (Collections.frequency(hashb1, key) == 1) {
			          			ArrayList<Integer> location = new ArrayList<Integer>();
			          			location.add(rnd.nextInt(10));
			          			
			          		
			          			
			          			//if exisiting key is found
			          			if (searchindex.containsKey(key)) {
			          		
			          					location.add(rnd.nextInt(10));
			          					searchindex.put(key, location);
			          					
			          			}
			          			
			          			// if no existing key is found 
			          			else
			          			{
			          				searchindex.put(key, location);
			          			}
			          			
			          	
			          			
			          			
			          		}
			          		
			          		//create hashmap for names
			          		else
			          		{
			          			
			          			ArrayList<Integer> templ = new ArrayList<Integer>();
			          			for (int x1 = 0; x1 < Collections.frequency(hashb1, key) ; x1++){
			          		   
			          				templ.add(rnd.nextInt(10));
			          				
			          			}
			          			
			          			
			          			//if exisiting key is found
			          			if (searchindex.containsKey(key)) {
			          		
			          					templ.add(rnd.nextInt(10));
			          					searchindex.put(key, templ);
			          					
			          			}
			          			
			          			// if no existing key is found 
			          			else
			          			{
			          				searchindex.put(key, templ);
			          			}
			          			
			          		}
			          		
			        
			          	 }
			        	 
			          	 System.out.println("****UPDATED HASHMAP ******");
			          	 System.out.println(searchindex.toString());
			          	 
			          	 
						System.out.println("Quantity");
						tester = true;
						
						// Loop to see if user enters the correct quantity
						while (tester == true) {
							try {
								System.out.println("Enter the Quantity:");
								squant = Integer.parseInt(GetScan());
								// catch to see if the quantity is greater than zero
								if (squant > 0) {
									tester = false;
								} else {
									throw new NumberFormatException();
								}
							} catch (NumberFormatException ee1) {
								System.out.println("Please Enter a number greater than 0");
								tester = true;
								
							}
								
						}
						
						
						
						tester = true;
						
						// Check price
						
						while (tester == true) {
							try {
								System.out.println("Enter the price");
								sprice = Double.parseDouble(GetScan());
								
								if (sprice > 0) {
									tester = false;
								} else {
									throw new NumberFormatException();
								}
							} catch (NumberFormatException ee1) {
								System.out.println("Please Enter a number greater than 0");
								tester = true;
									
							}
						}
						
						double tempbv = inv.SBV(squant, sprice);
						
					
						int testcase= 0 ;
						//check to see if the existing symbol exists in stocks and add to it if its the same symbol / entry
						
						for (int o = this.investments.size()-1; o >= 0; o--) 
						{
								
							if (ssymbol.toLowerCase().equals(this.investments.get(o).getSymbol().toLowerCase()) && this.investments.get(o).getClass().getCanonicalName().equals("assignment2.Stock"))
							{
									
								
								System.out.println("*****Adding to an existing entry ***** ");
								double temp11 = ((Stock)this.investments.get(o)).getBookvalue();
								double temp22 = inv.SBV(squant, sprice);
								squant = this.investments.get(o).getQuantity() + squant;
								
								Stock tem2 = new Stock (ssymbol, sname, squant, sprice, temp22);
								
								this.investments.add(tem2);
								
								this.investments.remove(o);
								testcase = 1;
														
							}
							
							
			
						}
						
						if (testcase == 0) {
							Stock tem = new Stock (ssymbol, sname, squant, sprice, tempbv);
							
							this.investments.add(tem);
						}
						
						testcase = 0;
						
					
					}
					
					//mutual fund option
					if (option ==2)
					{
						System.out.println("Mutual Fund");
		
						int p = 0;
						tester=true;
						while (tester == true) {
							System.out.println("Enter Symbol");
							msymbol = GetScan();
						
							for (int o = 0; o < this.investments.size(); o++) 
							{
								
								if (msymbol.toLowerCase().equals(this.investments.get(o).getSymbol().toLowerCase()) && this.investments.get(o).getClass().getCanonicalName().equals("assignment2.Stock"))
								{
									
							
								System.out.println("Already Exists in mutual fund");
								r = 1;
											
														
								}
			
							}
							if (r == 1)
							{
								p =1; 
							}
							r = 0;

							if (p == 1)
							{
								tester=true;
								p =0;
							}
							else 
							{
								tester=false;
								break;
							}							
						}
						
					
				
					
						
						
						System.out.println("Enter a Name");
						String mname = GetScan();
						
						//hashmap order book sequence
						temp111 = mname.split(" ");
			        	
						
			        	 for (int p1 = 0; p1 < temp111.length; p1++) {
			        		 hashb2.add(temp111[p1]);
			        		
			        		 
			        	 }
			        	 

			          	 Set<String> unique3 = new HashSet<String>(hashb2);
			          
			          	 
			          	 for (String key : unique3) {
			          		
			       
			          		
			          		//create hashmap for names
			          		if (Collections.frequency(hashb2, key) == 1) {
			          			ArrayList<Integer> location = new ArrayList<Integer>();
			          			location.add(rnd.nextInt(10));
			          			searchindex.put(key, location);
			          			
			          			
			          			
			          			//if exisiting key is found
			          			if (searchindex.containsKey(key)) {
			          		
			          					location.add(rnd.nextInt(10));
			          					searchindex.put(key, location);
			          					
			          			}
			          			
			          			// if no existing key is found 
			          			else
			          			{
			          				searchindex.put(key, location);
			          			}
			          			
			          			
			          			
			          		}
			          		
			          		//create hashmap for names
			          		else
			          		{
			          			
			          			ArrayList<Integer> templ = new ArrayList<Integer>();
			          			for (int x1 = 0; x1 < Collections.frequency(hashb1, key) ; x1++){
			          		   
			          				templ.add(rnd.nextInt(10));
			          				
			          			}
			          			
			          			
			          			//if exisiting key is found
			          			if (searchindex.containsKey(key)) {
			          		
			          					templ.add(rnd.nextInt(10));
			          					searchindex.put(key, templ);
			          					
			          			}
			          			
			          			// if no existing key is found 
			          			else
			          			{
			          				searchindex.put(key, templ);
			          			}
			          
			          		}
			          		
			        
			          	 }
			          	
			        	System.out.println("****UPDATED HASHMAP ******");
			          	System.out.println(searchindex.toString());
						
						System.out.println("Quantity");
						tester = true;
						
						// Loop to see if user enters the correct quantity
						while (tester == true) {
							try {
								System.out.println("Enter the Quantity:");
								mquant = Integer.parseInt(GetScan());
								// catch to see if the quantity is greater than zero
								if (mquant > 0) {
									tester = false;
								} else {
									throw new NumberFormatException();
								}
							} catch (NumberFormatException ee1) {
								System.out.println("Please Enter a number greater than 0");
								tester = true;
								
							}
								
						}
						
						tester = true;
						
						// Check price
						
						while (tester == true) {
							try {
								System.out.println("Enter the price");
								mprice = Double.parseDouble(GetScan());
								
								if (mprice > 0) {
									tester = false;
								} else {
									throw new NumberFormatException();
								}
							} catch (NumberFormatException ee1) {
								System.out.println("Please Enter a number greater than 0");
								tester = true;
									
							}
						
						}
						
						double tempbv = inv.MBV(mquant, mprice);
						
						//check to see if the existing symbol exists in stocks and add to it if its the same symbol / entry
						
						int testcase = 0;
						
						for (int o = this.investments.size()-1; o >= 0; o--) 
						{
								
							if (msymbol.toLowerCase().equals(this.investments.get(o).getSymbol().toLowerCase()) && this.investments.get(o).getClass().getCanonicalName().equals("assignment2.MutualFund"))
							{
									
								
								System.out.println("*****Adding to an Exisiting Entry***");
								double temp11 = ((MutualFund)this.investments.get(o)).getBookvalue();
								double temp22 = inv.SBV(mquant, mprice);
								mquant = this.investments.get(o).getQuantity() + mquant;
								
								MutualFund tem2 = new MutualFund (msymbol, mname, mquant, mprice, temp22);
								
								this.investments.add(tem2);
								
								this.investments.remove(o);
								testcase = 1;
									
														
							}
			
						}
						
						
						if (testcase == 0) {
							MutualFund tem = new MutualFund (msymbol, mname, mquant, mprice, tempbv);
							
							this.investments.add(tem);
						
						}
						
						testcase = 0;
						
						
					
					
					
				}
				}
				
				
				if (ans.equals("2"))
				{
					System.out.println("Enter Symbol for Investment:");
					String sellsymbol = GetScan();
					
					

					tester = true;
					
					// User enter the price to sell.
					
					while (tester == true) {
						try {
							System.out.println("Enter Price to sell:");
							sellp = Double.parseDouble(GetScan());
							
							if (sellp > 0) {
								tester = false;
							} else {
								throw new NumberFormatException();
							}
						} catch (NumberFormatException ee1) {
							System.out.println("Please Enter a number greater than 0");
							tester = true;
								
						}
					
					}
					
					//Obtaining a quantity value.
					tester = true;
					while (tester == true) {
						try {
							System.out.println("Enter the Quantity:");
							sellq = Integer.parseInt(GetScan());
							// catch to see if the quantity is greater than zero
							if (sellq > 0) {
								tester = false;
							} else {
								throw new NumberFormatException();
							}
						} catch (NumberFormatException ee1) {
							System.out.println("Please Enter a number greater than 0");
							tester = true;
							
						}
							
					}
					
					//matching the symbols within the investment class
					
					for (int o = this.investments.size() -1; o >= 0; o--) {
						
						if (this.investments.get(o).getSymbol().equals(sellsymbol.toLowerCase())) {
							System.out.println("***SELLING***");
							System.out.println(this.investments.get(o));
							if (this.investments.get(o) instanceof Stock)
							{
								System.out.println("Stock");
								sellsbv = inv.sellsbookv(sellq, this.investments.get(o).getQuantity(), ((Stock)this.investments.get(o)).getBookvalue() , sellp);
								System.out.println("The New Bookvalue is :" +sellsbv);
								
								ssellq = this.investments.get(o).getQuantity() - sellq;
								
								System.out.println("The New Quantity is :" +ssellq);
								
								// if quant or bookvalue is 0 then delete
								if (ssellq <= 0 || sellsbv <= 0 )
								{
									
									
									//remove place holder within hashmap
									
									String tempnames = this.investments.get(o).getName();
									
									String tempnames2[] = tempnames.split(" ");
									
									System.out.println(tempnames2.toString());
									for (int m = 0; m < tempnames2.length; m++) {
										System.out.println("forloop");
										if (searchindex.containsKey(tempnames2[m])) {
											searchindex.remove(tempnames2[m]);
											
											
										}
										
									}
									
									//remove investment with quantity less than 0
									this.investments.remove(o);
									
								}
								
								else
								{
									//add and delete the old entry with the new updated entry 
									Investment temp2 = new Stock (this.investments.get(o).getSymbol(), this.investments.get(o).getName(), ssellq, ((Stock)this.investments.get(o)).getPrice(), sellsbv);
									
									this.investments.add(temp2);
									
									this.investments.remove(o);
								}
							
								
								
						
							}
							
							else
							{
								System.out.println("Mutual Fund");
								
								sellmbv = inv.sellsbookv(sellq, this.investments.get(o).getQuantity(), ((MutualFund)this.investments.get(o)).getBookvalue() , sellp);
								System.out.println("The New Bookvalue is :" +sellsbv);
								
								ssellq = this.investments.get(o).getQuantity() - sellq;
								
								System.out.println("The New Quantity is :" +ssellq);
								
								// if quant or bookvalue is 0 then delete
								if (ssellq == 0 || sellsbv == 0 )
								{
									this.investments.remove(o);
								}
								
								else
								{
									//add and delete the old entry with the new updated entry 
									Investment temp2 = new Stock (this.investments.get(o).getSymbol(), this.investments.get(o).getName(), ssellq, ((MutualFund)this.investments.get(o)).getPrice(), sellsbv);
									
									this.investments.add(temp2);
									
									this.investments.remove(o);
								}
								
							}
						}
						
						
					}
					
				}
				
				if (ans.equals("3"))
				{
					System.out.println("hell");
					
					System.out.println("***UPDATE***");
					
					//parses through investments
					
					for (int o = this.investments.size() -1; o >= 0 ; o--)
					{
						
						System.out.println("Please Enter a new price for: " +this.investments.get(o).getName());
						
						
						tester = true;
						
						// User enter the price to sell.
						
						while (tester == true) {
							try {
								System.out.println("Enter new updated price:");
								updateprice = Double.parseDouble(GetScan());
								
								if (updateprice > 0) {
									tester = false;
								} else {
									throw new NumberFormatException();
								}
							} catch (NumberFormatException ee1) {
								System.out.println("Please Enter a number greater than 0");
								tester = true;
									
							}
						
						}
						
						if (this.investments.get(o) instanceof Stock)
						{
							
							//find the value of bookvalue before it gets updated
							spre = ((Stock)this.investments.get(o)).getBookvalue();
							System.out.println(spre);
							
							//update the new bookvalue
							double upbookv = inv.updateprice(this.investments.get(o).getQuantity(), updateprice, spre);
							
							//add the new bookvalue and price
							Investment temp3 = new Stock (this.investments.get(o).getSymbol(), this.investments.get(o).getName(), this.investments.get(o).getQuantity(), updateprice, ((Stock)this.investments.get(o)).getBookvalue());
							
							this.investments.add(temp3);
							
							this.investments.remove(o);
							
							//compute the gain
							gain = inv.gain(spre, upbookv);
							
							totalgain = totalgain + gain;
							
							
							
						}
						
						
						else
						{
							//find the value of bookvalue before it gets updated
							mpre = ((MutualFund)this.investments.get(o)).getBookvalue();
							System.out.println(spre);
							
							//update the new bookvalue
							double upbookv = inv.updateprice(this.investments.get(o).getQuantity(), updateprice, mpre);
							
							//add the new bookvalue and price
							Investment temp3 = new Stock (this.investments.get(o).getSymbol(), this.investments.get(o).getName(), this.investments.get(o).getQuantity(), updateprice, ((MutualFund)this.investments.get(o)).getBookvalue());
							
							this.investments.add(temp3);
							
							this.investments.remove(o);
							
							//compute the gain
							gain = inv.gain(spre, upbookv);
							
							totalgain = totalgain + gain;
							
						}
						
						//printing out the updated listing
						System.out.println("Updated Listing: ");
						
						for (int i =0; i<this.investments.size(); i++) 
						{
							
							System.out.println(this.investments.get(i));
							
						}
						
						
					}
				}
				
				
				if (ans.equals("4"))
				{
					//printing out the total gain of the portfolio
					
					System.out.println("Your total gain of your portfolio is : " +totalgain);
					
				}
            
				
				if (ans.equals("5"))
				{
					System.out.println("all entrys");
					
					for (int i =0; i<this.investments.size(); i++)
					{
						System.out.println(this.investments.get(i));
					}
					
					
					System.out.println("**Searching**");
					System.out.println("Enter the Symbol:");
					
					String searchs = GetScan();
					
					System.out.println("Enter the keywords: ");
					
					String searchn = GetScan();
					
					System.out.println("Enter the price range: ");
					
					String searchp = GetScan();
					
					searchp.replaceAll("\\s+", "");
					
					if (this.investments.isEmpty()) {
						System.out.println("There are no entries added");
					}
					
				
		
					
					// check to see if theres a "-" in between two letters
					
					if (searchp.matches("^(\\d+\\.\\d+)-(\\d+\\.\\d+)$") || searchp.matches("^(\\d+)-(\\d+)$"))
					{
					
						// if - is in between two letters set a high and low price
						
						pricelist = searchp.split("-");
						low = Double.parseDouble(pricelist[0]);
						high = Double.parseDouble(pricelist[1]);
						indic = 1;
					}
					
					// if the format has no - 
					
					if (searchp.matches("^\\d+$") || searchp.matches("\\d+(\\.\\d+)?"))
					{
						onep = Double.parseDouble(searchp);
						indic = 2;
					}
					
				
					// if the format has - number
					
					if (searchp.matches("-(\\d+(\\.\\d+)?)"))
					{
						searchp = searchp.replace("-", "");
						lessthan = Double.parseDouble(searchp);
						indic = 3;
					}
					
					// if the format has number - 
					if (searchp.matches("(\\d+(\\.\\d+)?)-"))
					{
						searchp = searchp.replace("-", "");
						morethan = Double.parseDouble(searchp);
						indic = 4;
					}
					
				
					for (int o =0 ; o < this.investments.size(); o++)
					{
						
				
						if (searchs.toLowerCase().equals(this.investments.get(o).getSymbol().toLowerCase()) || searchs.isEmpty()) 
						{
					
							
							if (searchn.toLowerCase().equals(this.investments.get(o).getName().toLowerCase()) || searchn.isEmpty())
							{
								
								if (indic == 1) {
									
									//look through stock
									if(this.investments.get(o) instanceof Stock) {
								
										double compare = ((Stock)this.investments.get(o)).getPrice();
										if (low <= compare && high >= compare || searchp.isEmpty()) 
										{
											System.out.println(this.investments.get(o));
										}
										
									}
									
									//look through mutual fund
								
									else {
										double compare2 = ((MutualFund)this.investments.get(o)).getPrice();
										if (low <= compare2 && high >= compare2 || searchp.isEmpty()) 
										{
											System.out.println(this.investments.get(o));
										}
									}
									
									
								}
								else if (indic == 2)
								{
					
									//look through stock
									if(this.investments.get(o) instanceof Stock) {
										double compare = ((Stock)this.investments.get(o)).getPrice();
										if (onep == compare || searchp.isEmpty()) 
										{
											System.out.println(this.investments.get(o));
										}
										
									}
									
									//look through mutual fund
								
									else {
										double compare2 = ((MutualFund)this.investments.get(o)).getPrice();
										if (onep ==compare2  || searchp.isEmpty()) 
										{
											System.out.println(this.investments.get(o));
										}
									}
								}
								else if (indic == 3) 
								{
									//look through stock
									if(this.investments.get(o) instanceof Stock) {
										double compare = ((Stock)this.investments.get(o)).getPrice();
										if (lessthan >= compare  || searchp.isEmpty()) 
										{
											System.out.println(this.investments.get(o));
										}
										
									}
									
									//look through mutual fund
								
									else {
										double compare2 = ((MutualFund)this.investments.get(o)).getPrice();
										if (lessthan >= compare2  || searchp.isEmpty()) 
										{
											System.out.println(this.investments.get(o));
										}
									}
								}
								
								else if (indic == 4){
									
									//look through stock
									if(this.investments.get(o) instanceof Stock) {
										double compare = ((Stock)this.investments.get(o)).getPrice();
										if (morethan <= compare  || searchp.isEmpty()) 
										{
											System.out.println(this.investments.get(o));
										}
										
									}
									
									//look through mutual fund
								
									else {
										double compare2 = ((MutualFund)this.investments.get(o)).getPrice();
										if (morethan <= compare2  || searchp.isEmpty()) 
										{
											System.out.println(this.investments.get(o));
										}
									}
									
								}
								
								else
								{
									System.out.println(this.investments.get(o));
								}
							}
							
						}
						
						
					}
					
					
					
				}
				
				
		
			}
			
			else if(ans.equals("6") || ans.equals("quit") || ans.equals("q") || ans.equals("qu")  )
					
				{
					// quit program and read to file
					System.out.println("Quiting Program");
					
					BufferedWriter save;
					
					try {
						System.out.println("Saving to: " + args[0]);
						save = new BufferedWriter(new FileWriter(args[0]));
						
						for (int o = 0; o < this.investments.size(); o++) {
							save.write(this.investments.get(o).toString());
							save.newLine();
						}
						save.close();
						
					} catch (IOException e) {
						System.out.println("Failed to write to " + args[0] + ".");
						
					}
					
					break;
					
				}
			else
			{
				System.out.println("Please Try Again");
			}
		
			
		}
		
	
	}
		
		
		
	
	
	public static void main (String[] args) 
	{
		InvestPortfolio invest = new InvestPortfolio();
	
		invest.run(args);
		
	}
	
	
	
	
}
