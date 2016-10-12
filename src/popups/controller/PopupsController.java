package popups.controller;

import popups.view.PopupViewer;
import popups.model.Thingy;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class PopupsController
{

    private PopupViewer display;
    private List<Integer> thingyList;
    private Random rand;

    public PopupsController()
    {
	display = new PopupViewer();
	thingyList = new ArrayList<Integer>();
	rand = new Random();
    }

    public void start()
    {
	fightJacob();
	// learnLists();
    }

    private void testLoop()
    {
	// display.displayMessage("Jacob the Destroyer of Salt attacks you.");
	// String firstMove = display.collectResponse("Do you run or fight?");
	// if(firstMove .equalsIgnoreCase)
	String answer = "sample";
	while (answer != null && !isDouble(answer))
	{
	    answer = display
		    .collectResponse("You need to type in a number!!!!");
	}
    }

    /**
     * Checks if the supplied string can be parsed to a double value.
     * 
     * @param potentialValue
     *            The String to test.
     * @return Whether the value could parsed, false otherwise.
     */
    private boolean isDouble(String potentialValue)
    {
	boolean isParseable = false;

	try
	{
	    double test = Double.parseDouble(potentialValue);
	    isParseable = true;
	}
	catch (NumberFormatException notDouble)
	{
	    display.displayMessage("This is not a double value >:-(");
	}

	return isParseable;
    }

    /**
     * Checks that the supplied String is parseable to an integer value.
     * 
     * @param potentialNumber
     *            The String to test for parsing.
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
	catch (NumberFormatException notInt)
	{
	    display.displayMessage(notInt.getMessage()); // Shows what error we
							 // got
	    display.displayMessage("Type in an integer next time!");

	}

	return isParseable;
    }

    /*
     * private void learnLists() { if(thingyList.size() > 0) {
     * display.displayMessage(thingyList.size() + " is the size of the list.");
     * } else if(thingyList.size() == 0) {
     * display.displayMessage("Why do you have a list with nothing in it?"); }
     * Thingy testThingy = new Thingy(); thingyList.add(testThingy);
     * //if(thingyList.size() > 0) //{ display.displayMessage(thingyList.size()
     * + " is the size of the list."); //} //else if(thingyList.size() == 0) //{
     * //display.displayMessage("Why do you have a list with nothing in it?");
     * //} for (int index = 0; index < 5; index++) { Thingy addThingy = new
     * Thingy(); thingyList.add(addThingy);
     * display.displayMessage(addThingy.getWords()); }
     * display.displayMessage(thingyList.size() + " is the size");
     * 
     * thingyList.get(3).setWords("Look I changed a value"); Thingy temp =
     * thingyList.get(4); temp.setWords("Stuff");
     * 
     * for ( int index = 0; index < thingyList.size(); index++) {
     * display.displayMessage(thingyList.get(index).getWords()); }
     * 
     * thingyList.add(3, new Thingy());
     * 
     * display.displayMessage("The size is " + thingyList.size());
     * 
     * thingyList.remove(0); //longer have access to this object because there
     * is no = sign.
     * 
     * display.displayMessage("The size is " + thingyList.size());
     * 
     * Thingy deletedThingy = thingyList.remove(3);
     * display.displayMessage(deletedThingy.getWords() +
     * " and the list size is " + thingyList.size());
     * 
     * thingyList.set(0, deletedThingy);
     * 
     * for (int index = 0; index < thingyList.size(); index++) {
     * display.displayMessage(thingyList.get(index).getWords()); }
     * 
     * for (Thingy currentThingy : thingyList)//A for each loop does this for
     * everything in the list {
     * display.displayMessage(currentThingy.getWords()); }
     * 
     * Thingy power = thingyList.get(2); power.setWords("OVER 9000!");
     * display.displayMessage(thingyList.get(2).getWords()); }
     */

    private void fightJacob()
    {
	/*
	 * for (int index = 0; index < 10; index++) { Integer addHealth = new
	 * Health(); healthList.add(addHealth); }
	 * 
	 * if(thingyList.get(0)==null) { thingyList.set(1, 0); }
	 * 
	 * if (healthList.get(0)==null) { healthList.set(1, 0); }
	 */

	int saltLevel = 0;
	int health = 10;
	boolean alive = true;

	display.displayMessage("Your health is " + Integer.toString(health));
	display.displayMessage(
		"Your salt level is " + Integer.toString(saltLevel));
	for (int count = 0; count < 10; count++)
	{
	    health = movement(health);
	}
	
	display.displayMessage("You win with a score of " + (health - saltLevel));

    }

    public int movement(int health)
    {
	int dynamicRestChanges = 0;
	boolean hasMoved = false;
	while (!hasMoved)
	{
	    String response = display
		    .collectResponse("Do you want to move or rest?");
	    if (response.equalsIgnoreCase("move"))
	    {
		dynamicRestChanges = 0;
		hasMoved = true;
		int encounterChance = rand.nextInt(100) + 1;
		if (encounterChance <= 35)
		{
		    health = Encounter(rand.nextInt((4) + 1), health,
			    "Stock Monster");
		}

		else
		{
		    display.displayMessage(
			    "You move foreward without incident.");
		}
	    }
	    else if (response.equalsIgnoreCase("rest"))
	    {
		dynamicRestChanges++;
		int restEncounterRand = (rand.nextInt(50) + 1)
			- dynamicRestChanges * 5;
		if (restEncounterRand <= 1)
		{
		    int randHealth = rand.nextInt(3) + dynamicRestChanges;
		    if (randHealth == 0)
		    {
		    }
		    else
		    {
			health = Encounter(randHealth, health, "Stock Monster");
		    }
		}
		else
		{
		    health++;
		    display.displayMessage(
			    "Your health is " + Integer.toString(health));

		}
	    }

	    if (response == null)
	    {
		System.exit(0);
	    }

	}
	return health;
    }

    public int Encounter(int monsterHealth, int health, String monsterName)
    {
	display.displayMessage("A " + monsterName + " attacks you");

	display.displayMessage("The monster's health is " + monsterHealth);
	display.displayMessage("Your health is " + health);

	while (monsterHealth != 0)
	{
	    String response = display
		    .collectResponse("do you  wish to attack or run");
	    if (response == null)
	    {
		System.exit(0);
	    }
	    else
	    {
		if (response.equalsIgnoreCase("attack"))
		{
		    int EncounterRand = rand.nextInt(10) + 1;
		    if (EncounterRand < 5)
		    {
			display.displayMessage("You hit the " + monsterName);
			monsterHealth--;
			if (monsterHealth > 0)
			{
			    display.displayMessage(
				    "the " + monsterName + " health is "
					    + Integer.toString(monsterHealth));
			}
			else
			{
			    display.displayMessage(
				    "The " + monsterName + "is dead");
			}
		    }
		    else
		    {
			display.displayMessage("Your attack fails and the "
				+ monsterName + " hits you");
			health--;
			if (health > 0)
			{
			    display.displayMessage("Your health is "
				    + Integer.toString(health));
			}
			else
			{
			    display.displayMessage("You died");
			    System.exit(0);
			}
		    }

		}
		else if (response.equalsIgnoreCase("run"))
		{
		    int EncounterRand = rand.nextInt(10) + 1;
		    if (EncounterRand < 5)
		    {
			display.displayMessage("you got away");
			monsterHealth = 0;
		    }
		    else
		    {
			display.displayMessage(
				"you failed to run away, The monster hit you with its backstabbing bonus.");
			health = health - monsterHealth;
			if (health < 0)
			{
			    display.displayMessage("You are dead");
			    System.exit(0);
			}
			else
			{
			    display.displayMessage("Your health is "
				    + Integer.toString(health));

			}
		    }
		}
	    }
	}
	return health;
    }
}
