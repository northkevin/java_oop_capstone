import java.util.ArrayList;

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
	public void discard(Stage pSecondaryStage, ArrayList pPlayerHand, boolean pCard1Choice, boolean pCard2Choice, boolean pCard3Choice, boolean pCard4Choice, boolean pCard5Choice)
	{
		System.out.println("Discarded"); //For testing only. Sees the button is working
		pSecondaryStage.close(); //Closes stage 2
	}
}
