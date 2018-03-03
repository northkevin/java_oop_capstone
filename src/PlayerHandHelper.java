import java.util.ArrayList;

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
}
