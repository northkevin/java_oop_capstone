import java.util.ArrayList;
import java.util.Random;

public class Curse extends DoorDeck {

	int curseNum;

	Curse() // Constructor
	{
		super();
		constructCard();
	}

		// 1-2:Loosing the same number of items as the number picked
		// 3:Losing race and become human
		// 4-5:Losing race and draw a random new race card
		// 6-7:Losing class
		// 8-10:Losing a level
	
	@Override
	public void constructCard() 
	{
		setCurseName(); //Sets the name of the cursecard
		setCurseNum();
	}
	
	
	public void setCurseNum() //Generates a random number between 1 and 10 for the curse number
	{
		Random rand = new Random();
		int n = rand.nextInt((10 - 1) + 1) + 1; //Generates a number between 1 and 10
		curseNum = n;
	}
	
	public void setCurseName() //Will generate a random name from a list of curses
	{
		String[] CurseNames = {"Hex of Grief", "Curse of Imbalance", "The Shaking Cure", "Curse of the Waste", "Heart of Stone", "Curse of the Sad Mummy", "Soul Shackles", "Haunting Light", "Drained Life" };
		int index = (int) (Math.random() * CurseNames.length);
		String name = CurseNames[index];
		 
		setName(name); //Using the extended method from DoorDeck
		
	}
	
	public int getCurseNum()
	{
		return curseNum;
	}
	
	//Already has a getName since it extends DoorDeck
}
