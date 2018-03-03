import java.util.ArrayList;

public class Cleric extends DoorDeck{

	Cleric() //Constructor
	{
		super();
		constructCard();
	}
	
	@Override
	public void constructCard() 
	{
		setName("Cleric");
	}
	
	//Cleric class ability
	public void turning(Character pCharacter, ArrayList pPlayerHand)
	{
		System.out.println("Turning"); //For testing purposes only. Sees if button is working.
	}

}
