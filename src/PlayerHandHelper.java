import java.util.ArrayList;

import javafx.scene.control.Label;
import javafx.stage.Stage;

public class PlayerHandHelper 
{
  private int soldAmount;
  private Boolean worthDouble;
  private int iteratorIndex;
  
	PlayerHandHelper()
	{
		
	}
	
	public void playMonster(Character pCharacter, ArrayList pPlayerHand, int pCardChoice) //Plays a monster from the players hand
	{
		System.out.println("Monster Played"); //For testing only. Sees the button is working
		pPlayerHand.add(DoorDeckFactory.createCard(10));
	}
	
	public void sellTreasure(Character pCharacter, ArrayList<DoorDeck> pPlayerHand, int pCardChoice) //Sells treasure, removed from hand, adds to gold
	{
	  this.soldAmount = 0;
	  this.worthDouble = false;
	  this.iteratorIndex = 0;
	  
	  pPlayerHand.forEach(card ->
	  {
	    if((card instanceof Treasure)&&(pCardChoice == iteratorIndex))
	    {
	      this.soldAmount += ((Treasure) card).getValue();
	    }
	    if((card instanceof Helpful)&&(pCardChoice == iteratorIndex))
	    {
	      worthDouble = true;
	    }
	    iteratorIndex++;
    });
	  
	  // for now just putting default values for testing.
	  soldAmount=50;
	  if(worthDouble){soldAmount+=soldAmount;}
	  
	  System.out.println("Current Gold: " + pCharacter.getGold());
	  pCharacter.setGold(pCharacter.getGold() + soldAmount);
	  System.out.println("Gold After sale: " + pCharacter.getGold());
	  
	  // this method like a mini program right now.. so being safe and setting all vars back to 0/false
	  this.soldAmount = 0;
    this.worthDouble = false;
    this.iteratorIndex = 0;
	}
	
	public int drawDoor(int pDoorDeckNum, ArrayList pDoorCards, ArrayList pPlayerHand) //Cards are drawn and added to player hand. Removed from door deck.
	{
		pPlayerHand.add(pDoorCards.get(pDoorDeckNum)); //adds a card from the top of the door deck to player's hand
		pDoorCards.remove(pDoorDeckNum); //removes the cards from the top of the door deck
		pDoorDeckNum--; //deincrements the number of cards in the door deck
		
		return pDoorDeckNum;
	}
	
	public void useTreasure(Character pcharacter, ArrayList pPlayerHand, int pCardChoice)
	{
		System.out.println("Treasure Used"); //For testing only. Sees the button is working
	}
	
	//Used in Scene 4 and Scene 5. Discards the cards the player chose to discard. booleans will be true if they chose them.
	public void discardAbility(Character pCharacter, Label pInstructionLabel, int pCardsSelected, ArrayList pPlayerHand, boolean pCard1Selected, boolean pCard2Selected, boolean pCard3Selected, boolean pCard4Selected, boolean pCard5Selected, boolean pCard6Selected)
	{
		//Will run it in a loop until the player has picked the correct number of cards
		
		if(pCardsSelected < 1)
		{
			pInstructionLabel.setText("	Please choose at least one card to discard! Please choose up to three cards below to use your class ability!");
		}
		else if(pCardsSelected <= 3 && pCardsSelected > 1)
		{	
			
			//Discard the cards they want and give the player +1 fight bonus for each card discarded	
			
			if(pCard1Selected == true)
			{
				pPlayerHand.set(0, "0"); //card 1 is replaced so the arraylist doesn't move yet
				pCharacter.setFightBonus(pCharacter.getFightBonus() + 1); //sets the fight bonus to current + 1
			}
			
			if(pCard2Selected == true)
			{
				pPlayerHand.set(1, "0"); //card 2 is replaced so the arraylist doesn't move yet
				pCharacter.setFightBonus(pCharacter.getFightBonus() + 1); //sets the fight bonus to current + 1
			}
			
			if(pCard3Selected == true)
			{
				pPlayerHand.set(2, "0"); //card 3 is replaced so the arraylist doesn't move yet
				pCharacter.setFightBonus(pCharacter.getFightBonus() + 1); //sets the fight bonus to current + 1
			}
			
			if(pCard4Selected == true)
			{
				pPlayerHand.set(3, "0"); //card 4 is replaced so the arraylist doesn't move yet
				pCharacter.setFightBonus(pCharacter.getFightBonus() + 1); //sets the fight bonus to current + 1
			}
			
			if(pCard5Selected == true)
			{
				pPlayerHand.set(4,"0"); //card 5 is replaced so the arraylist doesn't move yet
				pCharacter.setFightBonus(pCharacter.getFightBonus() + 1); //sets the fight bonus to current + 1
			}
			
			if(pCard6Selected == true)
			{
				pPlayerHand.set (5,"0"); //card 6 is replaced so the arraylist doesn't move yet
				pCharacter.setFightBonus(pCharacter.getFightBonus() + 1); //sets the fight bonus to current + 1
			}
			
			for(int s = 0; s < pCardsSelected; s++) //Goes to remove all the "0"'s we put in the arraylist
			{	
				if(pPlayerHand.get(s) == "0")
				{
					pPlayerHand.remove(s);
					s--; //To account for the array moving
					pCardsSelected = pCardsSelected - 1; //To account for the array moving
				}
			}
			
			
		}	
		else if(pCardsSelected > 3)
		{
			pInstructionLabel.setText("	You cannot choose more than 3 cards! Please choose up to three cards below to use your class ability!");
		}

	}
	
	//Used in Scene 4. Discards the cards the player chose to discard. booleans will be true if they chose them. Has to discard at least one card.
	public void discard(int pMaxCards, Label pInstructionLabel, int pCardsSelected, Stage pSecondaryStage, ArrayList pPlayerHand, boolean pCard1Selected, boolean pCard2Selected, boolean pCard3Selected, boolean pCard4Selected, boolean pCard5Selected, boolean pCard6Selected, boolean pCard7Selected, boolean pCard8Selected)
	{
		
		int size = pPlayerHand.size(); //Keeps track of the size of the player's hand
		
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
			//Discard the cards they want and give the player +1 fight bonus for each card discarded
			if(pCard1Selected == true)
			{
				pPlayerHand.set(0, "0"); //card 1 is replaced so the arraylist doesn't move yet
			}
			
			if(pCard2Selected == true)
			{
				pPlayerHand.set(1, "0"); //card 2 is replaced so the arraylist doesn't move yet
			}
			
			if(pCard3Selected == true)
			{
				pPlayerHand.set(2, "0"); //card 3 is replaced so the arraylist doesn't move yet
			}
			
			if(pCard4Selected == true)
			{
				pPlayerHand.set(3, "0"); //card 4 is replaced so the arraylist doesn't move yet
			}
			
			if(pCard5Selected == true)
			{
				pPlayerHand.set(4, "0"); //card 5 is replaced so the arraylist doesn't move yet
			}
			
			if(pCard6Selected == true)
			{
				pPlayerHand.set(5, "0"); //card 6 is replaced so the arraylist doesn't move yet
			}
			
			if(pCard7Selected == true)
			{
				pPlayerHand.set(6,"0"); //card 7 is replaced so the arraylist doesn't move yet
			}
			
			if(pCard8Selected == true)
			{
				//pPlayerHand.set(7, "0"); //card 8 is replaced so the arraylist doesn't move yet
			}
			
			for(int s = 0; s < size; s++) //Goes to remove all the "0"'s we put in the arraylist
			{	
				if(pPlayerHand.get(s) == "0")
				{
					pPlayerHand.remove(s);
					s--; //To account for the arraylist moving
					size = size - 1; //To account for the arraylist moving
				}
			}

		}
	}
}
