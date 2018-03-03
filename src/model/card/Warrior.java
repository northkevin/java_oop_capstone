package model.card;
import java.util.ArrayList;

import model.Character;

public class Warrior extends Card
{

	Warrior()
	{
		super();
		constructCard();
	}
	
	@Override
	public void constructCard() 
	{
		setName("Warrior");
	}

	
	public void berserking(Character pCharacter, ArrayList pPlayerHand)
	{
		
	}
}
