import java.util.ArrayList;

import javafx.scene.control.Button;

public class Halfling extends DoorDeck
{

	Halfling() //Constructor
	{
		super();
		constructCard();
	}
	
	@Override
	public void constructCard() 
	{
		setName("Halfling");
	}
	
	public void sellDouble(Button pbHalflingSell, ArrayList pPlayerHand, Character pCharacter, int pCardChoice) //Sells the card picked for twice it's value and sets gold
	{
		pbHalflingSell.setDisable(true); //Since the player has already used their ability
		System.out.println("Treasure Sold for double"); //For testing only. Sees the button is working
	}

}
