import java.util.ArrayList;

import javafx.scene.control.Label;

public class CurseHelper 
{

	CurseHelper() //constructor
	{
		
	}
	
	// 1-2:Loosing the same number of items as the number picked
	// 3:Losing race and become human
	// 4-5:Losing race and draw a random new race card
	// 6-7:Losing class
	// 8-10:Losing a level
	//Checks if the player drew a curse
	
	public void checkCurse(Label pActionLabel, Curse pCurse, ArrayList pPlayerHand) 
	{
		int curseNumber = 0; //What is the random curse number?
		int size = pPlayerHand.size(); //Keeps track of the size of the player's hand
		
		//These are for if there is multiple curses I can display them all in a label
		String cardLoss = "";
		String raceLoss = "";
		String raceLossAndDraw = "";
		String classLoss = "";
		String levelLoss = "";
		
		for(int f = 0; f < size; f++) //Arraylists start at one. Runs through the arraylist and checks for curse cards.
		{
			if(pPlayerHand.get(f) instanceof Curse)
			{
				curseNumber = ((Curse) pPlayerHand.get(f)).getCurseNum(); //Gets the curse number that is attached to the card
				System.out.println(curseNumber);
				
				if(curseNumber == 1 || curseNumber == 2)
				{
					//TODO call loseCards(curseNum)
					cardLoss = " " + ((DoorDeck) pPlayerHand.get(f)).getName() + " has made some of your cards disappear!";
				}
				else if(curseNumber == 3)
				{
					//TODO call loseRace
					raceLoss = " " + ((DoorDeck) pPlayerHand.get(f)).getName() + " has made you human!";
				}
				else if(curseNumber == 4 || curseNumber == 5)
				{
					//TODO call loseRaceAndDraw
					raceLossAndDraw = " " + ((DoorDeck) pPlayerHand.get(f)).getName() + " has changed your race!";
				}
				else if(curseNumber == 6 || curseNumber == 7)
				{
					//TODO call loseClass
					classLoss = " " + ((DoorDeck) pPlayerHand.get(f)).getName() + " has made you forget your class!";
				}
				else //curseNumber is 8-10
				{
					//TODO call loseLevel
					levelLoss = " " + ((DoorDeck) pPlayerHand.get(f)).getName() + " has drawn your strength and pushed you down some levels!";
				}
				
				pPlayerHand.remove(f); //Removes the curse card from the player's hand
				
				size = size - 1; //The size of the arraylist is now smaller since an element was removed
				f--; //f deincremented to take the removal into account since when you delete by index you simply move everything that has higher index than the removed element one place down
				
				System.out.println("Removed"); //For testing purposed only!
			}
			
			if(curseNumber!= 0)
			{
				pActionLabel.setText("    You have been cursed! " + cardLoss + raceLoss + "\n   " +  raceLossAndDraw + classLoss + levelLoss + "\n    Please click on the door cards in red on the left to draw!");
			}
		}
	}
	
	
	
}
