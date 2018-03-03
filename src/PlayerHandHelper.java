import java.util.ArrayList;

import javafx.scene.control.Label;
import javafx.stage.Stage;

public class PlayerHandHelper 
{
	PlayerHandHelper()
	{
		
	}
	
	public void playMonster(Character pCharacter, ArrayList pPlayerHand, int pCardChoice) //Plays a monster from the players hand
	{
		System.out.println("Monster Played"); //For testing only. Sees the button is working
	}
	
	public void sellTreasure(Character pCharacter, ArrayList pPlayerHand, int pCardChoice) //Sells treasure, removed from hand, adds to gold
	{
		System.out.println("Treasure Sold"); //For testing only. Sees the button is working
	}
	
	public void drawDoor(ArrayList pDoorCards, ArrayList pPlayerHand) //Cards are drawn and added to player hand. Removed from door deck.
	{
		System.out.println("Cards drawn"); //For testing only. Sees the button is working
	}
	
	public void useTreasure(Character pcharacter, ArrayList pPlayerHand, int pCardChoice)
	{
		System.out.println("Treasure Used"); //For testing only. Sees the button is working
	}
	
	//Used in Scene 4 and Scene 5. Discards the cards the player chose to discard. booleans will be true if they chose them.
	public void discardAbility(Character pChar, Label pInstructionLabel, int pCardsSelected, ArrayList pPlayerHand, boolean pCard1Selected, boolean pCard2Selected, boolean pCard3Selected, boolean pCard4Selected, boolean pCard5Selected, boolean pCard6Selected)
	{
		//Will run it in a loop until the player has picked the correct number of cards
		
		if(pCardsSelected < 1)
		{
			pInstructionLabel.setText("	Please choose at least one card to discard! Please choose up to three cards below to use your class ability!");
		}
		else if(pCardsSelected <= 3 && pCardsSelected > 1)
		{	
			
			//TODO Discard the cards they want and give the player +1 fight bonus for each card discarded
			
			System.out.println("Discarded"); //For testing only. Sees the button is working
		}	
		else if(pCardsSelected > 3)
		{
			pInstructionLabel.setText("	You cannot choose more than 3 cards! Please choose up to three cards below to use your class ability!");
		}

	}
	
	//Used in Scene 4. Discards the cards the player chose to discard. booleans will be true if they chose them. Has to discard at least one card.
	public void discard(int pMaxCards, Label pInstructionLabel, int pCardsSelected, Stage pSecondaryStage, ArrayList pPlayerHand, boolean pCard1Selected, boolean pCard2Selected, boolean pCard3Selected, boolean pCard4Selected, boolean pCard5Selected, boolean pCard6Selected, boolean pCard7Selected, boolean pCard8Selected)
	{
		if(pCardsSelected < 1)
		{
			pInstructionLabel.setText("	Please choose to discard at least one card!");
		}
		else if((pPlayerHand.size() - pCardsSelected) > pMaxCards) //Does this if the amount of cards they would have after the discard is less than their allowed max
		{
			System.out.println("You would still have too many cards. Please click more to discard! You can only have " + pMaxCards + " cards!");
		}
		else
		{
			//TODO Discard the cards they want from their hand
			
			System.out.println("Discarded"); //For testing only. Sees the button is working
		}
	}
}
