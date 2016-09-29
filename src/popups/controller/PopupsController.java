package popups.controller;

import popups.view.PopupViewer;

public class PopupsController 
{
	
	private PopupViewer display;
	
	public PopupsController()
	{
		display = new PopupViewer();
	}
	
	public void start()
	{
		//display.displayMessage("Jacob the Destroyer of Salt attacks you.");
		//String firstMove = display.collectResponse("Do you run or fight?");
		//if(firstMove .equalsIgnoreCase)
		String answer = "sample";
		while(answer != null && !answer.equals(""))
		{
		display.displayMessage("Hi there ;-)");
		
		answer = display.collectResponse("What is going on?");
		display.displayMessage(answer + " is what you said.");
		}
	}
	/**
	 * Checks if the supplied string can be parsed to a double value.
	 * @param potentialValue The String to test.
	 * @return Whether the value could  parsed, false otherwise.
	 */
	private boolean isDouble(String potentialValue)
	{
		boolean isParseable = false;
		
		try
		{
			double test = Double.parseDouble(potentialValue);
			isParseable = true;
		}
		catch(NumberFormatException notDouble)
		{
			display.displayMessage("This is not a double value >:-(");
		}
		
		return isParseable;
	}
	
	/**
	 * Checks that the supplied String is parseable to an integer value.
	 * @param potentialNumber The String to test for parsing.
	 * @return Whether is could be parsed as an integer.
	 */
	private boolean isInteger(String potentialNumber)
	{
		boolean isParseable = false;
		
		try
		{
			int test = Integer.parseInt(potentialNumber);
		}
		catch(NumberFormatException notInt)
		{
			display.displayMessage(notInt.getMessage()); //Shows what error we got
			display.displayMessage("Type in an integer next time!");
			
		}
		
		return isParseable;
	}
	
}
