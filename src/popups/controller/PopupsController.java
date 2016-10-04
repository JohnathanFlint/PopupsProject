package popups.controller;

import popups.view.PopupViewer;
import popups.model.Thingy;

import java.util.List;
import java.util.ArrayList;

public class PopupsController 
{
	
	private PopupViewer display;
	private List<Thingy> thingyList;
	
	public PopupsController()
	{
		display = new PopupViewer();
		thingyList = new ArrayList<Thingy>();
	}
	
	public void start()
	{
		learnLists();
		fightJacob();
	}
	
	private void testLoop()
	{
		//display.displayMessage("Jacob the Destroyer of Salt attacks you.");
				//String firstMove = display.collectResponse("Do you run or fight?");
				//if(firstMove .equalsIgnoreCase)
				String answer = "sample";
				while(answer != null && !isDouble(answer))
				{
				answer = display.collectResponse("You need to type in a number!!!!");
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
			isParseable = true;
		}
		catch(NumberFormatException notInt)
		{
			display.displayMessage(notInt.getMessage()); //Shows what error we got
			display.displayMessage("Type in an integer next time!");
			
		}
		
		return isParseable;
	}

	private void learnLists()
	{
		if(thingyList.size() > 0)
		{
			display.displayMessage(thingyList.size() + " is the size of the list.");
		}
		else if(thingyList.size() == 0)
		{
			display.displayMessage("Why do you have a list with nothing in it?");
		}
		Thingy testThingy = new Thingy();
		thingyList.add(testThingy);
		//if(thingyList.size() > 0)
		//{
			display.displayMessage(thingyList.size() + " is the size of the list.");
		//}
		//else if(thingyList.size() == 0)
		//{
			//display.displayMessage("Why do you have a list with nothing in it?");
		//}
		for (int index = 0; index < 5; index++)
		{
			Thingy addThingy = new Thingy();
			thingyList.add(addThingy);
			display.displayMessage(addThingy.getWords());
		}
		display.displayMessage(thingyList.size() + " is the size");
		
		thingyList.get(3).setWords("Look I changed a value");
		Thingy temp = thingyList.get(4);
		temp.setWords("Stuff");
		
		for ( int index = 0; index < thingyList.size(); index++)
		{
			display.displayMessage(thingyList.get(index).getWords());	
		}
		
		thingyList.add(3, new Thingy());
		
		display.displayMessage("The size is " + thingyList.size());
		
		thingyList.remove(0); //longer have access to this object because there is no = sign.
		
		display.displayMessage("The size is " + thingyList.size());
		
		Thingy deletedThingy = thingyList.remove(3);
		display.displayMessage(deletedThingy.getWords() + " and the list size is " + thingyList.size());
		
		thingyList.set(0, deletedThingy);
		
		for (int index = 0; index < thingyList.size(); index++)
		{
			display.displayMessage(thingyList.get(index).getWords());
		}
		
		for (Thingy currentThingy : thingyList)//A for each loop does this for everything in the list
		{
			display.displayMessage(currentThingy.getWords());
		}
		
		Thingy power = thingyList.get(2);
		power.setWords("OVER 9000!");
		display.displayMessage(thingyList.get(2).getWords());
	}
	
	private void fightJacob()
	{
		
	}
}
