package assignment3;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Main class for building the Gui.
 * 
 * @author Gabe
 *
 */
public class GuiMain implements ActionListener {
	public static final int WIDTH = 800;
	public static final int HEIGHT = 800;

	private JButton Intro;
	private JButton Intro1;
	private JPanel Buy;
	private JPanel Sell;
	private JPanel Update;
	private JPanel button1;
	private JPanel button2;
	private JPanel TotalGain;
	private JPanel Search;
	private JPanel Buyone;
	private JPanel Buytwo;
	private JPanel Buythree;
	private JPanel Buyscreen;
	private JPanel Sellscreen;
	private JPanel Sellone;
	private JPanel Selltwo;
	private JPanel Sellthree;
	private JPanel Updatescreen;
	private JPanel Updateone;
	private JPanel Updatetwo;
	private JPanel Updatethree;
	private JPanel updatepanel;
	private JPanel Buyscreen2;
	private JPanel sellpanel;
	private JPanel buypanel;
	private JLabel usymbol;
	private JLabel uname;
	private JLabel uprice;
	private JLabel tubutton;
	private JLabel emptybutton3;
	private JPanel getgainpanel;
	private JPanel getgainscreen;
	private JPanel searchpanel;
	private JPanel Gainone;
	private JPanel Gaintwo;

	private JLabel gaintitle;
	private JLabel gainbutton;
	private JTextField gainField;
	private JLabel gainempty;

	private JTextField puField;
	private JTextField suField;
	private JTextField nuField;
	private JButton buyb;
	private JButton resetb;
	private JLabel typebutton;
	private JLabel symbolbutton;
	private JLabel namebutton;
	private JLabel quantitybutton;
	private JLabel pricebutton;
	private JLabel titlebutton;
	private JLabel emptybutton;
	private JScrollPane scrollPane;
	private JPanel textAreaPanel;
	private JLabel sellsymbol;
	private JLabel sellquantity;
	private JLabel sellprice;
	private JLabel selltitle;
	private JButton Sellbutton;
	private JButton Sellreset;
	private double totalgains = 0;

	// Create Panels
	private JPanel sb1;
	private JPanel sb2;
	// Set Layout
	private JPanel Searchone;

	private JLabel titlesearch;
	private JLabel symbolsearch;
	private JLabel namesearch;
	private JLabel lowsearch;
	private JLabel highsearch;
	private JLabel emptysearch;
	private JPanel Searchthree;
	public JTextArea textField5;
	private JScrollPane scrollPane5;
	private JPanel Searchtwo;
	private JButton Ssearch;
	private JButton Rsearch;
	private JPanel searchbuttons;
	private JPanel searchbuttons2;

	private JTextField ssField;
	private JTextField nsField;
	private JTextField lsField;
	private JTextField hsField;

	private JPanel Searchscreen;
	private JTextArea textField4;
	private JScrollPane scrollPane4;

	// create Fields
	private JTextField sellsymbolField;
	private JTextField sellquantityField;
	private JTextField sellpriceField;
	private JTextArea textField3;
	private JTextArea textField;
	private JTextArea SellField;
	private JScrollPane scrollPane2;
	private JTextField symbolField;
	private JTextField nameField;
	private JTextField quantityField;
	private JTextField priceField;
	private JMenuItem st;
	private JMenuItem mf;
	private JMenu menu;
	private JMenuBar menuBar;
	private int q1 = 0;
	private double p1 = 0;
	private int indicator = 0;
	private int counter = 0;
	private CardLayout cardView;
	private JPanel cardPanel;
	private String SellS;
	private String QuantS;
	private String PriceS;
	private String Symbol;
	private String Name;
	private String Quantity;
	private String Price;
	private double Bookvalue;

	private InvestPortfolio inv;

	private JMenu command;
	private JMenuBar bar;

	/**
	 * Creates the main Gui and Jframe
	 */
	public GuiMain() {

		JFrame frame = new JFrame();

		frame.setTitle("Investment Portfolio");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		initComponents(frame);

		frame.pack();
		frame.setVisible(true);

	}

	/**
	 * Action events for going through different cards
	 */
	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub

		String menuItem = evt.getActionCommand();

		switch (menuItem) {
		case "Buy":
			cardView.show(cardPanel, "Buy");
			break;

		case "Sell":
			cardView.show(cardPanel, "Sell");
			break;

		case "Update":
			cardView.show(cardPanel, "Update");
			break;

		case "getGain":
			cardView.show(cardPanel, "getGain");
			break;

		case "Search":
			cardView.show(cardPanel, "Search");
			break;

		case "Quit":
			System.exit(0);
			break;

		}

	}

	/**
	 * Where all the cards are loaded and made
	 * 
	 * @param frame
	 */
	private void initComponents(JFrame frame) {
		this.inv = new InvestPortfolio();

		// build the Jmenu
		bar = new JMenuBar();
		frame.setJMenuBar(bar);

		command = new JMenu("Command");

		bar.add(command);
		// The Card Choices
		JMenuItem BuyChoice = new JMenuItem("Buy");
		JMenuItem SellChoice = new JMenuItem("Sell");
		JMenuItem UpdateChoice = new JMenuItem("Update");
		JMenuItem GainChoice = new JMenuItem("getGain");
		JMenuItem SearchChoice = new JMenuItem("Search");
		JMenuItem QuitChoice = new JMenuItem("Quit");

		command.add(BuyChoice);
		command.add(SellChoice);
		command.add(UpdateChoice);
		command.add(GainChoice);
		command.add(SearchChoice);
		command.add(QuitChoice);

		cardView = new CardLayout();
		cardPanel = new JPanel(cardView);
		// Building all the different screens
		buildBuyScreen();
		buildSellScreen();
		buildUpdateScreen();
		buildGainScreen();
		buildSearchScreen();
		buypanel = Buyscreen;
		sellpanel = Sellscreen;
		updatepanel = Updatescreen;
		getgainpanel = getgainscreen;
		searchpanel = Searchscreen;

		Intro = new JButton("Welcome to Investment Portfolio, Please Click on Command to Continue. ");

		// Adding the different cards
		cardPanel.add("Start", Intro);
		cardPanel.add("Buy", buypanel);
		cardPanel.add("Sell", sellpanel);
		cardPanel.add("Update", updatepanel);
		cardPanel.add("getGain", getgainpanel);
		cardPanel.add("Search", searchpanel);
		BuyChoice.addActionListener(this);
		SellChoice.addActionListener(this);
		UpdateChoice.addActionListener(this);
		GainChoice.addActionListener(this);
		GainChoice.addActionListener(new updatingg());
		SearchChoice.addActionListener(this);
		QuitChoice.addActionListener(this);

		frame.getContentPane().add(cardPanel, BorderLayout.CENTER);
	}

	/**
	 * Updates the amount of Gains from the investments
	 * 
	 * @author Gabe
	 *
	 */
	public class updatingg implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			// Updates

			String ga = Double.toString(totalgains);

			gainField.setText(ga);

		}

	}

	/**
	 * First Panel for the Search SCreen
	 */
	public void buildSearchScreen() {

		Searchscreen = new JPanel();
		Searchscreen.setLayout(new BorderLayout());

		// build each panel
		buildSearchone();
		buildSearchtwo();
		buildSearchthree();

		// place them on overall frame for the update screen
		Searchscreen.add(Searchone, BorderLayout.LINE_START);
		Searchscreen.add(Searchtwo, BorderLayout.LINE_END);
		Searchscreen.add(Searchthree, BorderLayout.PAGE_END);

	}

	/**
	 * Third Panel for the Search Screen
	 */
	public void buildSearchthree() {

		// Create panel to hold buttons
		Searchthree = new JPanel();

		textField5 = new JTextArea(700, 400);

		textField5.setEditable(false);
		textField5.setLineWrap(true);

		scrollPane5 = new JScrollPane(textField5);
		scrollPane5.setPreferredSize(new Dimension(700, 400));

		Searchthree.add(scrollPane5);

	}

	/**
	 * Second Panel for the Search Screen
	 */

	public void buildSearchtwo() {

		// Create panel to hold buttons
		Searchtwo = new JPanel();

		// Set Layout
		Searchtwo.setLayout(new GridLayout(2, 1));

		// Create buttons
		Ssearch = new JButton("Search");
		Ssearch.setPreferredSize(new Dimension(100, 100));

		Rsearch = new JButton("Reset");
		Rsearch.setPreferredSize(new Dimension(100, 100));

		// Create Panels
		searchbuttons = new JPanel();
		searchbuttons2 = new JPanel();

		// Add buttons to pannel
		searchbuttons.add(Ssearch);
		searchbuttons2.add(Rsearch);

		searchbuttons.setPreferredSize(new Dimension(100, 100));
		searchbuttons2.setPreferredSize(new Dimension(100, 100));

		// add Button panel to GUI
		Searchtwo.add(searchbuttons);
		Searchtwo.add(searchbuttons2);

		Searchtwo.setPreferredSize(new Dimension(350, 350));

		// add action listeners
		Rsearch.addActionListener(new SRListener());
		Ssearch.addActionListener(new SSListener());

	}

	/**
	 * Action Listener for the Search Button
	 * 
	 * @author Gabe
	 *
	 */
	public class SSListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// set Variables
			String Ssymbol = ssField.getText();
			String Sname = nsField.getText();
			String Slow = lsField.getText();
			String Shigh = hsField.getText();

			// search function

			textField5.setText(inv.searchindex(Ssymbol, Sname, Slow, Shigh));

		}

	}

	/**
	 * Action Listener for the Reset button
	 * 
	 * @author Gabe
	 *
	 */
	public class SRListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			// Clear Fields
			ssField.setText("");
			nsField.setText("");
			lsField.setText("");
			hsField.setText("");

		}

	}

	/**
	 * Search Panel one
	 */
	public void buildSearchone() {

		// Create panel to hold buttons
		Searchone = new JPanel();

		// Set Layout
		Searchone.setLayout(new GridLayout(5, 2));

		// Create buttons

		titlesearch = new JLabel("Searching Investments");
		symbolsearch = new JLabel("Symbol");
		namesearch = new JLabel("Name Keywords");
		lowsearch = new JLabel("Low Price");
		highsearch = new JLabel("High Price");
		emptysearch = new JLabel();

		// Create Fields
		ssField = new JTextField(30);
		nsField = new JTextField(30);
		lsField = new JTextField(30);
		hsField = new JTextField(30);

		// Add button panel to Gui
		Searchone.add(titlesearch);
		Searchone.add(emptysearch);
		Searchone.add(symbolsearch);
		Searchone.add(ssField);
		Searchone.add(namesearch);
		Searchone.add(nsField);
		Searchone.add(lowsearch);
		Searchone.add(lsField);
		Searchone.add(highsearch);
		Searchone.add(hsField);

		Searchone.setPreferredSize(new Dimension(400, 400));

	}

	/**
	 * Building the Gain screen or card
	 */
	public void buildGainScreen() {

		getgainscreen = new JPanel();
		getgainscreen.setLayout(new BorderLayout());

		// build each panel
		buildGainone();
		buildGaintwo();

		// place them on the overral frame for the update screen
		getgainscreen.add(Gainone, BorderLayout.LINE_START);
		getgainscreen.add(Gaintwo, BorderLayout.PAGE_END);

	}

	/**
	 * Second Panel in the Gain screen
	 */
	public void buildGaintwo() {

		// Creat Panel to hold buttons;
		Gaintwo = new JPanel();

		// Set Layout
		textField4 = new JTextArea(700, 400);

		textField4.setEditable(false);
		textField4.setLineWrap(true);

		scrollPane4 = new JScrollPane(textField4);
		scrollPane4.setPreferredSize(new Dimension(700, 400));

		Gaintwo.add(scrollPane4);

	}

	/**
	 * First Panel in the Gain screen
	 */
	public void buildGainone() {

		// Create Panel to hold buttons
		Gainone = new JPanel();

		// Set Layout
		Gainone.setLayout(new GridLayout(2, 2));

		// Create buttons
		gaintitle = new JLabel("Getting total gain");
		gainbutton = new JLabel("Total Gain");
		gainField = new JTextField(30);
		gainField.setEditable(false);
		gainempty = new JLabel();
		String ga = Double.toString(totalgains);

		gainField.setText(ga);
		// Add button panel to gui and fields

		Gainone.add(gaintitle);
		Gainone.add(gainempty);
		Gainone.add(gainbutton);
		Gainone.add(gainField);

		Gainone.setPreferredSize(new Dimension(700, 200));

	}

	/**
	 * Build the update screen
	 */
	// Borderlayout for update Screen
	public void buildUpdateScreen() {

		Updatescreen = new JPanel();
		Updatescreen.setLayout(new BorderLayout());

		// build each panel
		buildUpdateone();
		buildUpdatetwo();
		buildUpdatethree();

		// place them on the overall frame for the update screen
		Updatescreen.add(Updateone, BorderLayout.LINE_START);
		Updatescreen.add(Updatetwo, BorderLayout.LINE_END);
		Updatescreen.add(Updatethree, BorderLayout.PAGE_END);

	}

	/**
	 * Build the third panel in the update screen
	 */
	public void buildUpdatethree() {

		// Create Panel
		Updatethree = new JPanel();

		textField3 = new JTextArea(700, 400);

		textField3.setEditable(false);
		textField3.setLineWrap(true);

		JScrollPane scrollPane3 = new JScrollPane(textField3);
		scrollPane3.setPreferredSize(new Dimension(700, 400));

		Updatethree.add(scrollPane3);

	}

	/**
	 * Build the second panel in the update screen
	 */
	public void buildUpdatetwo() {

		// Create panel
		Updatetwo = new JPanel();

		// Set Layout
		Updatetwo.setLayout(new GridLayout(3, 1));

		// Create Buttons
		JButton prev = new JButton("Prev");
		JButton next = new JButton("Next");
		JButton saveu = new JButton("Save");

		prev.setPreferredSize(new Dimension(100, 100));
		next.setPreferredSize(new Dimension(100, 100));
		saveu.setPreferredSize(new Dimension(100, 100));

		// create Panels
		JPanel ub1 = new JPanel();
		JPanel ub2 = new JPanel();
		JPanel ub3 = new JPanel();

		// add buttons to pannel
		ub1.add(prev);
		ub2.add(next);
		ub3.add(saveu);

		ub1.setPreferredSize(new Dimension(100, 100));
		ub2.setPreferredSize(new Dimension(100, 100));
		ub3.setPreferredSize(new Dimension(100, 100));

		// add button pannel to gui
		Updatetwo.add(ub1);
		Updatetwo.add(ub2);
		Updatetwo.add(ub3);

		// Add Listeners
		next.addActionListener(new nextListener());
		prev.addActionListener(new prevListener());
		saveu.addActionListener(new saveListener());

		Updatetwo.setPreferredSize(new Dimension(350, 350));
	}

	/**
	 * Action listener for saving on update screen
	 * 
	 * @author Gabe
	 *
	 */
	public class saveListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			String symbol2 = suField.getText();
			String name2 = nuField.getText();
			String price2 = puField.getText();

			totalgains = totalgains + inv.gains(counter, price2);

			textField3.setText(inv.changePrice(counter, price2));

		}
	}

	/**
	 * 
	 * @author Gabe Action listener for previous button, goes back previous entrys
	 *         in update screen
	 */
	public class prevListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			counter = counter - 1;
			suField.setText(inv.backs(counter));
			nuField.setText(inv.backn(counter));
			puField.setText("");

		}
	}

	/**
	 * Goes to the next listening within the update screen
	 * 
	 * @author Gabe
	 *
	 */
	public class nextListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			suField.setText(inv.updateg(counter));
			nuField.setText(inv.updatet(counter));
			puField.setText("");
			counter++;

		}

	}

	/**
	 * Build the first panel in the Update screen
	 */

	public void buildUpdateone() {

		// Create Panel to hold buttons
		Updateone = new JPanel();

		// Set Layout
		Updateone.setLayout(new GridLayout(4, 2));

		// Create buttons
		usymbol = new JLabel("Symbol");
		uname = new JLabel("Name");
		uprice = new JLabel("Price");
		tubutton = new JLabel("Updating Investments");
		emptybutton3 = new JLabel();

		// Create 1 field and 2 undeditable text areas
		puField = new JTextField(30);
		suField = new JTextField(30);
		nuField = new JTextField(30);

		suField.setEditable(false);
		nuField.setEditable(false);

		Updateone.add(tubutton);
		Updateone.add(emptybutton3);
		Updateone.add(usymbol);
		Updateone.add(suField);
		Updateone.add(uname);
		Updateone.add(nuField);
		Updateone.add(uprice);
		Updateone.add(puField);

		Updateone.setPreferredSize(new Dimension(400, 400));
	}

	/**
	 * Builds the sell screen
	 */
	public void buildSellScreen() {
		Sellscreen = new JPanel();
		Sellscreen.setLayout(new BorderLayout());

		// build each panel
		buildSellone();
		buildSelltwo();
		buildSellthree();

		// place them on the overral frame for the sell screen
		Sellscreen.add(Sellone, BorderLayout.LINE_START);
		Sellscreen.add(Selltwo, BorderLayout.LINE_END);
		Sellscreen.add(Sellthree, BorderLayout.PAGE_END);

	}

	/**
	 * Builds the first panel in the sell screen
	 */
	public void buildSellone() {

		// Create panel to hold buttons
		Sellone = new JPanel();

		// Set Layout
		Sellone.setLayout(new GridLayout(4, 2));

		// Create Buttons
		sellsymbol = new JLabel("Symbol");
		sellquantity = new JLabel("Quantity");
		sellprice = new JLabel("Price");
		selltitle = new JLabel("Selling an investment");
		JLabel emptybutton2 = new JLabel();

		// create Fields
		sellsymbolField = new JTextField(30);
		sellquantityField = new JTextField(30);
		sellpriceField = new JTextField(30);

		// Add buttons to panel
		Sellone.add(selltitle);
		Sellone.add(emptybutton2);
		Sellone.add(sellsymbol);
		Sellone.add(sellsymbolField);
		Sellone.add(sellquantity);
		Sellone.add(sellquantityField);
		Sellone.add(sellprice);
		Sellone.add(sellpriceField);
		Sellone.setPreferredSize(new Dimension(400, 400));

	}

	/**
	 * Builds the second panel in the sell screen
	 */
	public void buildSelltwo() {

		// Create Panel to hold tow buttons
		Selltwo = new JPanel();

		// Set Layout
		Selltwo.setLayout(new GridLayout(2, 1));

		// Create buttons
		Sellbutton = new JButton("Sell");
		Sellbutton.setPreferredSize(new Dimension(100, 100));

		Sellreset = new JButton("Reset");
		Sellreset.setPreferredSize(new Dimension(100, 100));

		// Create Panels
		sb1 = new JPanel();
		sb2 = new JPanel();

		// add buttons to pannel
		sb1.add(Sellbutton);
		sb2.add(Sellreset);

		// add Panels to gui
		Selltwo.add(sb1);
		Selltwo.add(sb2);

		// add listeners
		Sellreset.addActionListener(new ResetSellListener());
		Sellbutton.addActionListener(new SellButtonListener());
		Selltwo.setPreferredSize(new Dimension(350, 350));

	}

	/**
	 * Reset button for sell menu
	 * 
	 * @author Gabe
	 *
	 */
	public class ResetSellListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			// Clear fields
			sellsymbolField.setText("");
			sellquantityField.setText("");
			sellpriceField.setText("");

		}

	}

	/**
	 * Sell button for sell menu
	 * 
	 * @author Gabe
	 *
	 */
	public class SellButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			// Selling function

			SellS = sellsymbolField.getText();
			QuantS = sellquantityField.getText();
			PriceS = sellpriceField.getText();

			// if (validateQ(QuantS) && validateQ(PriceS))
			if (SellS.equals("") || QuantS.equals("") || PriceS.equals("")) {

				SellField.setText("Error, fill in the requirements");
			}

			else {
				SellField.setText(inv.Sellcheck(SellS, QuantS, PriceS));

			}

			sellsymbolField.setText("");
			sellquantityField.setText("");
			sellpriceField.setText("");

		}

	}

	/**
	 * builds Sell Panel three
	 */
	public void buildSellthree() {

		// Create Panel
		Sellthree = new JPanel();

		SellField = new JTextArea(700, 400);

		SellField.setEditable(false);
		SellField.setLineWrap(true);

		scrollPane2 = new JScrollPane(SellField);
		scrollPane2.setPreferredSize(new Dimension(700, 400));

		Sellthree.add(scrollPane2);

	}

	/**
	 * builds the Buy screen
	 */
	public void buildBuyScreen() {

		Buyscreen = new JPanel();
		Buyscreen.setLayout(new BorderLayout());
		// build each pannel
		buildBuyone();
		buildBuytwo();
		buildBuythree();

		// place them on the overral frame for the buy screen
		Buyscreen.add(Buyone, BorderLayout.LINE_START);
		Buyscreen.add(Buytwo, BorderLayout.LINE_END);
		Buyscreen.add(Buythree, BorderLayout.PAGE_END);

	}

	/**
	 * build buy panel one where you enter everything for investment
	 */
	public void buildBuyone() {

		// Create panel to hold buttons
		Buyone = new JPanel();

		// Set Layout
		Buyone.setLayout(new GridLayout(6, 2));

		// Create Buttons

		typebutton = new JLabel("Type");
		symbolbutton = new JLabel("Symbol");
		namebutton = new JLabel("Name");
		quantitybutton = new JLabel("Quantity");
		pricebutton = new JLabel("Price");
		titlebutton = new JLabel("Buying an Investment");
		emptybutton = new JLabel();

		// Create Fields
		symbolField = new JTextField(30);
		nameField = new JTextField(30);
		quantityField = new JTextField(30);
		priceField = new JTextField(30);

		// Type Menu for different modes
		mf = new JMenuItem("Mutual Fund");
		mf.addActionListener(new mutualfundselect());

		st = new JMenuItem("Stock");
		st.addActionListener(new menufundselect());

		// mf.addActionListener(new mfListener());

		menu = new JMenu("Stock");

		menu.add(mf);
		menu.add(st);

		menuBar = new JMenuBar();
		menuBar.add(menu);

		// Add button panel to Gui and fields
		Buyone.add(titlebutton);
		Buyone.add(emptybutton);
		Buyone.add(typebutton);
		Buyone.add(menuBar);
		Buyone.add(symbolbutton);
		Buyone.add(symbolField);
		Buyone.add(namebutton);
		Buyone.add(nameField);
		Buyone.add(quantitybutton);
		Buyone.add(quantityField);
		Buyone.add(pricebutton);
		Buyone.add(priceField);
		Buyone.setPreferredSize(new Dimension(400, 400));

	}

	/**
	 * Action listener for selecting mutual fund or not
	 * 
	 * @author Gabe
	 *
	 */
	public class mutualfundselect implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			indicator = 1;
			menu.setText("Mutual Fund");

		}
	}

	/**
	 * Action listener for selecting Stock or not
	 * 
	 * @author Gabe
	 *
	 */
	public class menufundselect implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			indicator = 0;
			menu.setText("Stock");

		}
	}

	/**
	 * Paneo two of the buy menu
	 */
	public void buildBuytwo() {

		// Create panel to hold two buttons
		Buytwo = new JPanel();

		// Set Layout
		Buytwo.setLayout(new GridLayout(2, 1));

		// Create Buttons
		buyb = new JButton("Buy");
		buyb.setPreferredSize(new Dimension(100, 100));
		resetb = new JButton("Reset");
		resetb.setPreferredSize(new Dimension(100, 100));

		// create panels
		button1 = new JPanel();
		button2 = new JPanel();

		// add buttons to pannel
		button1.add(buyb);
		button2.add(resetb);

		button1.setPreferredSize(new Dimension(100, 100));
		button2.setPreferredSize(new Dimension(100, 100));

		// Add button panel to GUI
		Buytwo.add(button1);
		Buytwo.add(button2);

		// add listeners
		resetb.addActionListener(new ResetBuyListener());
		buyb.addActionListener(new EntryBuyListener());

		Buytwo.setPreferredSize(new Dimension(350, 350));

	}

	/**
	 * Reset button listener
	 * 
	 * @author Gabe
	 *
	 */
	public class ResetBuyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			// Clear Fields
			symbolField.setText("");
			nameField.setText("");
			quantityField.setText("");
			priceField.setText("");

		}

	}

	/**
	 * Validate Quantity
	 * 
	 * @param Quantity
	 * @return
	 */
	public boolean validateQ(String Quantity) {
		boolean condition = false;
		int q = 0;

		q = Integer.parseInt(Quantity);

		if (inv.numbercheck(Quantity)) {
			if (q > 0) {
				condition = true;
			} else {
				textField.setText("Invalid Quantity, Please enter an int greater than 0");
				condition = false;
			}

		} else {
			textField.setText("Invalid Quantity, please enter int");
			condition = false;
		}

		return condition;

	}

	/**
	 * Validate price
	 * 
	 * @param Price
	 * @return
	 */
	public boolean validateP(String Price) {
		boolean condition = false;
		double q = 0;

		q = Double.parseDouble(Price);

		if (inv.numbercheck(Price)) {
			if (q > 0) {
				condition = true;
			} else {
				textField.setText("Invalid Price, Please enter an int greater than 0");
				condition = false;
			}

		} else {
			textField.setText("Invalid Price, please enter int");
			condition = false;
		}

		return condition;

	}

	/**
	 * Buy button listener
	 * 
	 * @author Gabe
	 *
	 */
	public class EntryBuyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (indicator == 1) {

				textField.setText("MutualFund");
				Symbol = symbolField.getText();

				Name = nameField.getText();
				Quantity = quantityField.getText();
				Price = priceField.getText();

				System.out.println(Symbol);

				if (Symbol.equals("") || Name.equals("") || Quantity.equals("") || Price.equals("")) {

					textField.setText("Error, fill in the requirements");
				}

				else if (validateQ(Quantity) && validateP(Price)) {
					textField.setText(inv.insertM(Symbol, Name, Quantity, Price));

				}

				symbolField.setText("");
				nameField.setText("");
				quantityField.setText("");
				priceField.setText("");

			}

			else {

				textField.setText("Stock");
				Symbol = symbolField.getText();
				Name = nameField.getText();
				Quantity = quantityField.getText();
				Price = priceField.getText();

				if (Symbol.equals("") || Name.equals("") || Quantity.equals("") || Price.equals("")) {

					textField.setText("Error, fill in the requirements");
				}

				else if (validateQ(Quantity) && validateQ(Price)) {
					textField.setText(inv.insertS(Symbol, Name, Quantity, Price));

				}

				symbolField.setText("");
				nameField.setText("");
				quantityField.setText("");
				priceField.setText("");

			}

		}

	}

	/**
	 * Buy panel three
	 */
	public void buildBuythree() {

		// Create Panel
		Buythree = new JPanel();

		textField = new JTextArea(700, 400);

		textField.setEditable(false);
		textField.setLineWrap(true);

		scrollPane = new JScrollPane(textField);
		scrollPane.setPreferredSize(new Dimension(700, 400));

		Buythree.add(scrollPane);

	}

}
