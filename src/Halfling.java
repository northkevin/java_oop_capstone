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
		int goldWorth = 0;
		
		pbHalflingSell.setDisable(true); //Since the player has already used their ability
		
		goldWorth = ((Treasure) pPlayerHand.get(pCardChoice)).getValue(); //Retrieves the gold value of the treasure
		pCharacter.setGold(pCharacter.getGold() + goldWorth*2); //Adds the twice the gold to the player's current
		
		pPlayerHand.remove(pCardChoice); //Removes the treasure card from the player's hand
	}

}
