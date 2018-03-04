import java.util.ArrayList;
import java.util.Random;

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
	
	
	// 1-2:Hex of Grief--Loosing the same number of items as the number picked
	public void loseCards(ArrayList itemList, int number) 
	{
		for (int i = 0; i < number; i++) 
		{
			itemList.remove(i);
			number--; //Array list shift
			i--; //Array list shift
		}
	}

	// 3:Curse of Imbalance--Losing raceand become human
	public void loseRace(Character currentCharacter) 
	{
		currentCharacter.setRace("Human");
	}

	// 4-5:The Shaking Cure--Losing race and draw a random new race card
	public void loseRaceAndDraw(Character currentCharacter) 
	{
		String races[] = { "Dwarf", "Elf", "Halfling" };
		Random r = new Random();
		int num = r.nextInt(3);
		
		currentCharacter.setRace(races[num]);
	}

	// 6-7:Curse of the Waste-- Losing class
	public void loseClass(Character currentCharacter) 
	{
		currentCharacter.setPlayerClass("None");
	}

	// 8-10: Heart of Stone--Losing a level
	public void loseLevel(Character pCharacter) 
	{
		pCharacter.setLevel(pCharacter.getLevel() - 1);
		System.out.println(pCharacter.getLevel());
	}

	
	public void checkCurse(Character pCharacter, Label pActionLabel, Curse pCurse, ArrayList pPlayerHand) 
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
				
				if(curseNumber == 1 || curseNumber == 2)
				{
					if(curseNumber == 1)
					{	
						//loseCards(pPlayerHand, 1);
					}
					else
					{
						//loseCards(pPlayerHand, 2);
					}
					cardLoss = " " + ((DoorDeck) pPlayerHand.get(f)).getName() + " has made some of your cards disappear!";
				}
				else if(curseNumber == 3)
				{
					loseRace(pCharacter);
					raceLoss = " " + ((DoorDeck) pPlayerHand.get(f)).getName() + " has made you human!";
				}
				else if(curseNumber == 4 || curseNumber == 5)
				{
					//loseRaceAndDraw(pCharacter);
					raceLossAndDraw = " " + ((DoorDeck) pPlayerHand.get(f)).getName() + " has changed your race!";
				}
				else if(curseNumber == 6 || curseNumber == 7)
				{
					loseClass(pCharacter);
					classLoss = " " + ((DoorDeck) pPlayerHand.get(f)).getName() + " has made you forget your class!";
				}
				else //curseNumber is 8-10
				{
					loseLevel(pCharacter);
					levelLoss = " " + ((DoorDeck) pPlayerHand.get(f)).getName() + " has drawn your strength and pushed you down some levels!";
				}
				
				pPlayerHand.remove(f); //Removes the curse card from the player's hand
				
				size = size - 1; //The size of the arraylist is now smaller since an element was removed
				f--; //f deincremented to take the removal into account since when you delete by index you simply move everything that has higher index than the removed element one place down
				

			}
			
			if(curseNumber!= 0)
			{
				pActionLabel.setText("    You have been cursed! " + cardLoss + raceLoss + "\n   " +  raceLossAndDraw + classLoss + levelLoss + "\n    Please click on the door cards in red on the left to draw!");
			}
		}
	}
	
	
	
}
