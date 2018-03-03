import java.util.ArrayList;

public class CharacterHelper 
{
	
	
	CharacterHelper()
	{
		
	}
	
	public void changeRace(Character pCharacter, ArrayList pPlayerHand, int pCardChoice) //Sets the player's race
	{
		System.out.println("Race Changed"); //For testing only. Sees the button is working
	}
	
	public void changeClass(Character pCharacter, ArrayList pPlayerHand, int pCardChoice) //Sets the player's class
	{
		System.out.println("Class Changed"); //For testing only. Sees the button is working
	}
	
	public void buyLevel(Character pCharacte, int pCardChoice) //Sets the player's level after they buy a level(have to have enough money)
	{
		System.out.println("Leveled Up"); //For testing only. Sees the button is working
	}
	
	public void combat(Character pCharacter, ArrayList pPlayerHand, MonsterHelper pMonsterHelper) //Compares the fight bonus + player level to monster level. Also calls run if they fail.
	{
		System.out.println("Monster fought"); //For testing only. Sees the button is working
		/***Pseudo*: If they lose then below will be called.
		*Pseudo*: Use pCharacter.getFightBonus();**/
		
		run(pCharacter);
	}
	
	public void run(Character pCharacter) //Rolls the dice and adds it to the player's bonus to run. 5 and above is success. For elf 4 and above.
	{
		System.out.println("Run away"); //For testing only. Sees the button is working
		/***Pseudo*: Use pCharacter.getRunBonus**/
	}
}
