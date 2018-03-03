package model.card;

public class Curse extends Card
{

	Curse() //Constructor
	{
		super();
		constructCard();
	}
	
	@Override
	public void constructCard() 
	{
		setName(randomCurseName());
		
	}

	public String randomCurseName() //Will generate a random name from a list of curses
	{
		String[] CurseNames = {"Hex of Grief", "Curse of Imbalance", "The Shaking Cure", "Curse of the Waste", "Heart of Stone", "Curse of the Sad Mummy", "Soul Shackles", "Haunting Light", "Drained Life" };
		int index = (int) (Math.random() * CurseNames.length);
		String name = CurseNames[index];
		 
		return(name);
		
	}
}
