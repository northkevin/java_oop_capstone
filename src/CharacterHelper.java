import java.util.ArrayList;

import javafx.scene.control.Label;

public class CharacterHelper 
{
	int characterLevel;
	boolean runTwice = false;

	CharacterHelper()
	{

	}

	public void changeRace(Label pActionLabel, Character pCharacter, ArrayList pPlayerHand, int pCardChoice)
	{
		//Sets the player's race
		pCharacter.setRace(((DoorDeck) pPlayerHand.get(pCardChoice)).getName());
		
		pActionLabel.setText("  You changed your race to a " + pCharacter.getRace() + " Please click on the door deck in red to the left to draw!");
		
		pPlayerHand.remove(pCardChoice);
	}

	public void changeClass(Label pActionLabel, Character pCharacter, ArrayList pPlayerHand, int pCardChoice) //Sets the player's class
	{
		pCharacter.setPlayerClass(((DoorDeck) pPlayerHand.get(pCardChoice)).getName());
		
		pActionLabel.setText("  You changed your class to a " + pCharacter.getClass() + " Please click on the door deck in red to the left to draw!" );
		
		pPlayerHand.remove(pCardChoice);

	}

	public void buyLevel(Label pActionLabel, Character pCharacter, int pCardChoice) 
	{
		double levelPrice = 1000;
		
		
		if(pCharacter.getGold() > levelPrice) 
		{
			characterLevel = pCharacter.getLevel() + 1;
			pCharacter.setLevel(characterLevel);
			pActionLabel.setText("	You leveled up!");
			
			pCharacter.setGold(pCharacter.getGold() - 1000); //Subtracts the 1000 gold from the player's gold
		}		
		else 
		{
			pActionLabel.setText("	You do not have enough money to buy a level! You need 1000 gold to level up!\n  Please click on the door deck in red to the left to draw!");
		}
	}

	public Label combat(Label pActionLabel, Character pCharacter, ArrayList pPlayerHand, Monster pMonster) //Compares the fight bonus + player level to monster level. Also calls run if they fail.
	{
		int combatStrength = pCharacter.getLevel() + pCharacter.getFightBonus();

		if (combatStrength > ((Monster) pMonster).getLevel()) 
		{
			pActionLabel.setText("	You Won your fight with the monster! You get a level and get" + pMonster.getGood() + " pieces of treasure");
			characterLevel = pCharacter.getLevel() + 1; //Adds a level to the character's level since they won
			pCharacter.setLevel(characterLevel);
			
			//TODO collect's treasure from monster here
			
		}
		else 
		{
			pActionLabel = run(pActionLabel, pCharacter, pMonster);
		}
		
		return pActionLabel;
	}

	public Label run(Label pActionLabel, Character pCharacter, Monster pMonster) //Rolls the dice and adds it to the player's bonus to run. 5 and above is success. For elf 4 and above.
	{
		// Roll the dice
		int rollResult = (int) (Math.random()* (6-1)+1); 	// (highest - lowest) + lowest

		rollResult = rollResult + pCharacter.getRunBonus(); //Adds the run bonus so the roll will be higher and it is easier to run away
		
		// Elf wins if they roll greater than 4
		if(pCharacter.getRace() == "Elf") 
		{
			if(rollResult >= 4) 
			{ 
				// success; player run
				pActionLabel.setText("	You lost your fight with the monster, but you managed to successfully run away!");
			
			}
			else 
			{
				pActionLabel.setText("You have lost your fight with a monster and failed to escape!");
				//TODO collectloss
			
			}
		}
		else
		{
			if(rollResult >= 5) 
			{
				pActionLabel.setText("	You lost your fight with the monster, but you managed to successfully run away!");
	
			}
			else 
			{
				// Halfling gets to run again if they lose
				if(pCharacter.getRace() == "Halfling")
				{
					run(pActionLabel, pCharacter, pMonster); //Calls run again for halfling
				}
				else
				{
					//Collect loss
				}
			}
		}
		
		return pActionLabel;
}	
	

}
