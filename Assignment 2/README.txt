Assignment 2 
Gabriel Lee

Use Case:

This program builds a investment portfolio which accepts stocks and mutual funds. It can keep track of what you bought, what you sold, updating pricing, the total gain from the current investments and a search function.

Assumptions and Limitations:

Assumptions for this program are that every stock and mutual fund should only have one single unique symbol. It is also assumed that getgain is calculated from the updated list of investments. Within assignment 2 it was also assumed that only one single array was used as a listing rather than two arrays that contained Stock and mutualfunds. It was also noted that there is a textfile that is ment to be read in that the user must specifiy in the command line in the fomrat as "text.txt". The program reads from the files upon launching and saves to the files up exiting. A limitation with this program is that the search index does not work in terms of the hashmap. A hashmap was created to map all the names within the array. 


How to Run:

The program begins with a menu where the user can choose what function to launch. The user can do this by entering with 1 - 6 that is outlined with the correlating function. You can also enter the first 2 letters of the function or the entire word of the function to pick the option such as B or Bu or Buy. 

Testcase:

Testcases that can be tested for this program are to add something besides a integer for the price and quanaity through the buy options. 

To see if the program works to be inteded these values should be added for a test case:

Stock - 1
TD , Toronto Dominion Bank, 500, 50

should be entered for stock option and:

Mutual fund -1 
CIG677, CI Signature Select Canadian, 450, 20

should be entered for a mutual fund option. 

The value that should be obtained from bookvalue for Stock - 1 should be 25,009.99 and for Mutual Fund - 2 should be 9,000. 

After updating the price for Stock - 1 to 69.31 , you should receive a payment of 13,852.01 for selling 200 stocks worth and after updating the price for mutual fund - 1 to 26.95 you should receive a payment of 3,997.50 after selling 150 mutual funds worth.


Alternatively if you were to find the bookvalue after the price was set to 69.31 the value should be 34,645.01 for stock option 1 and if the mutual fund - 1 price was set to 26.95 the bookvalue would be 12,082.50

A file input/output was also used in this assignment. When launching the program it should tell u whether or not you were successfully able to launch the textfile to read. It will also prompt a message that it has been successfully writen to a certain textfile when exiting the program. 

A hashmap was implemented to keep track of the different names used within all the investments. It is mapped when the program launches and keeps track of how many different names were used when entering the names of the banks. 

The hashmap will be displayed when launching the program and adding new listing to the program. It also deletes entrys from the hashmap when selling different investments. 

For searching leaving all fields blank will return all the listings and entering any parameter should work as intended.

The search function finds the values from, Symbol, the names and the price range. The hashmap for the search function does not work at this point of time within the program. 

