package model.card;
import java.util.ArrayList;

import model.Character;


public class Cleric extends CardFactory{

	Cleric() //Constructor
	{
		super();
	}
	
	@Override
	public void constructCard() 
	{
		setName("Cleric");
	}
	
	//Cleric class ability
	public void turning(Character pCharacter, ArrayList pPlayerHand)
	{
		System.out.println("Turning"); //For testing purposes only. Sees if button is working.
	}

}
