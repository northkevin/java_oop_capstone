package model.card;
import java.util.ArrayList;

import model.Character;

public class Wizard extends Card
{

	Wizard()
	{
		super();
		constructCard();
	}
	
	@Override
	public void constructCard() 
	{
		setName("Wizard");	
	}
	
	public void flight(Character pCharacter, ArrayList pPlayerHand)
	{
		System.out.println("Flight"); //For testing purposes only. Sees if the button works
	}
	
	public void charm(Character pCharacter, ArrayList pPlayerHand)
	{
		System.out.println("charm"); //For testing purposes only. Sees if the button works
	}


}
