package model.card;
import java.util.ArrayList;

import model.Character;

public class Helpful extends Card
{
	
	Helpful()//Constructor
	{
		super();
		constructCard();
	}

	@Override
	public void constructCard() 
	{
		setName(randomHelpfulName());
		
	}
	
	public String randomHelpfulName() //generates a random name from among some helpful items
	{
		String[] helpfulNames = {"Ring of Miodan", "Healing Circlet of Emiah", "Athene's Unholy Grail", "Mipha's Grace", "Ghal Maraz", "Cloak of Petrification", "Crown of Bretonnia", "The Book of Grudges", "Scroll of the Divine" };
		int index = (int) (Math.random() * helpfulNames.length);
		String name = helpfulNames[index];
		 
		return(name);
		
	}
	
	public void sellDoubleVal(Character pCharacter, ArrayList pPlayerHand, int pCardChoice)
	{
		System.out.println("Sell double value"); //For testing purposes only. Sees if button works.
	}
	
	public void helpLevelUp(Character pCharacter, ArrayList pPlayerHand, int pCardChoice)
	{
		System.out.println("Helpful level up"); //For testing purposes only. Sees if button works.
	}


}
