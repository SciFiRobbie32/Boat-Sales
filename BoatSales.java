	/*This is a boat sales Receipt generator, it calculates the cost of a boat ordered by someone.
	 *By Robert Hannah
	 *	12/6/2018 
	 */

    import java.text.*;
	import java.util.*;
	
public class BoatSales {
	
	static String iString;
	static String iBoat;
	static String StringInt;
	static int iQty;
	static int iInt;
	static double cBoatCost;
	static double cPrepCost;
	static double cAcc;
	static double percent;
	static double MarkUp;
	static double Subtotal;
	static double Tax;
	static double Total;
	static String oTotal;
	static String oTax;
	static String oSub;
	static String oMark;
	static String oPrep;
	static String oCost;
	static String inputNext = "Y";
	static Scanner myScanner;
	static NumberFormat nf;
	
public static void main(String[] args) {
		
			//Call init
			init();
		
			while (inputNext.equals("Y")) {
			//call input
			input();
			
			//call calculations
			calcs();
			
			//call output
			output();
			//Prompt for next receipt
			System.out.print("Enter another Boat Receipt? Y or N: ");
			inputNext = myScanner.next().toUpperCase();
			}
		
		System.out.println("Program ended, have a good Day!");
		
	}

public static void init() {
	//set scanner to the Console
	myScanner = new Scanner(System.in);
	//change delimiter from blank space to Enter key
	//to allow spaces in strings
	myScanner.useDelimiter(System.getProperty("line.separator"));
	
	//set formatter to use U.S. currency format
	nf = NumberFormat.getCurrencyInstance(java.util.Locale.US);
}
public static void input() {
	//get the boat cost and make sure it isn't invalid
	try {
	System.out.println("Please enter Boat cost: ");
	iString = myScanner.next();
	cBoatCost = Double.parseDouble(iString);
		}
	catch (Exception e) {
		System.out.println("Choice invalid, default 25,000");
		cBoatCost = 25000.00;
	}
	if (cBoatCost <2500.00 || cBoatCost > 150000.00) {
		cBoatCost = 25000.00;
		System.out.println("Price is to large/low, default 25,000");
	}
	//get prep cost and also make sure the unit is valid and isn't invalid
	try {
	System.out.println("Please enter Prep cost: ");
	iString = myScanner.next();
	cPrepCost = Double.parseDouble(iString);
		}
	catch (Exception e) {
		System.out.println("Choice invalid, default 25,000");
		cPrepCost = 5000.00;
	}
	if (cPrepCost < 100.00 || cPrepCost > 9999.99) {
		cPrepCost = 5000.00;
		System.out.println("Choice invalid, default 25,000");
	}
	//get quantity and make sure that the value isnt invalid
	try {
	System.out.println("Please enter quantity '1-25 only' ");
	iString = myScanner.next();
	iQty = Integer.parseInt(iString);
	}
	catch (Exception e) {
		System.out.println("Choice invalid, choosing default '1' ");
		iQty = 1;
	}
	
	if (iQty < 25 || iQty > 1) {
		System.out.println("Choice invalid, choosing default '1' ");
		iQty = 1;
	}
	//get the boat type and make sure that it isn't invalid
	System.out.println("Please Enter Boat type  'B'  'P'  'S'  'C'  :  ");
	iString = myScanner.next().toUpperCase();
	//case structure to see what is selected, using a string as char doesn't easily work here.
	switch(iString) {
	case "B":
		iBoat = "Bass";
		percent = 0.33;
		break;
	case "P":
		iBoat = "Pontoon";
		percent = 0.25;
		break;
	case "S":
		iBoat = "Ski";
		percent = 0.425;
		break;
	case "C":
		iBoat = "Canoe";
		percent = 0.20;
		break;
	}
	//get accessories value and make sure its valid
	try {
	System.out.println("Please Enter Boat Accesory  1 electronics, 2 ski package, 3 fishing package  :  ");
	iString = myScanner.next();
	iInt = Integer.parseInt(iString);
	}
	catch (Exception e) {
		System.out.println("Choice invalid, choosing default '1' ");
		iInt = 1;
		StringInt = "Electronics";
		cAcc = 5415.30	;
	}
	try {
	switch (iInt) {
	case 1:
		StringInt = "Electronics";
		cAcc = 5415.30	;
		break;
	case 2:
		StringInt = "Ski Package";
		cAcc = 3980.00;
		break;
	case 3:
		StringInt = "Fishing Package";
		cAcc = 345.45;
		break;
	default:
		System.out.println("Choice invalid, choosing default '1' ");
		iInt = 1;
		StringInt = "Electronics";
		cAcc = 5415.30	;
		break;
	}
		}
	catch (Exception e) {
		System.out.println("Choice invalid, choosing default '1' ");
		iInt = 1;
		StringInt = "Electronics";
		cAcc = 5415.30	;
	}
		
}
public static void calcs() {
	MarkUp = percent * cBoatCost;
	Subtotal = cBoatCost + cAcc + cPrepCost + MarkUp * iQty;
	Tax = Subtotal * 0.07;
	Total = Subtotal + Tax;
	
}
public static void output() {
	MarkUp = Math.round(MarkUp);
	Tax = Math.round(Tax);
	
	oTotal = nf.format(Total);
	oTax = nf.format(Tax);
	oSub = nf.format(Subtotal); 
	oMark = nf.format(MarkUp);
	oPrep = nf.format(cPrepCost); 
	oCost = nf.format(cBoatCost);
	
	System.out.println("Boat Type: " + iBoat);
	System.out.println("Accesories: " + StringInt);
	System.out.println("Qauntity: " + iQty);
	System.out.println("Boat Cost: " + oCost);
	System.out.println("Accesories Cost: " + cAcc);
	System.out.println("Prep Cost: " + oPrep);
	System.out.println("Mark Up: " + oMark);
	System.out.println("Subtotal: " + oSub);
	System.out.println("Tax: " + oTax);
	System.out.println("Total: " + oTotal);
	
 }

}
