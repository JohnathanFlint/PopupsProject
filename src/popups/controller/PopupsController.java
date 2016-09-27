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
		display.displayMessage("Jacob the Destroyer of Salt attacks you.");
		String firstMove = display.collectResponse("Do you run or fight?");
		if(firstMove .equalsIgnoreCase)
		/*String answer = "sample";
		while(answer != null && !answer.equals(""))
		{
		display.displayMessage("Hi there ;-)");
		
		answer = display.collectResponse("What is going on?");
		display.displayMessage(answer + " is what you said.");
		}*/
	}
}
