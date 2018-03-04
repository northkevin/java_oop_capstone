import java.util.ArrayList;

public class Helpful extends DoorDeck
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
		String[] helpfulNames = {"Ring \nof Miodan\n", "Healing \nCirclet of Emiah\n", "Athene's Unholy Grail\n", "Mipha's Grace\n", "Ghal Maraz\n", "Cloak \nof Petrification\n", "Crown \nof Bretonnia\n", "The Book \nof Grudges\n", "Scroll \nof the Divine\n" };
		int index = (int) (Math.random() * helpfulNames.length);
		String name = helpfulNames[index];
		 
		return(name);
		
	}
	
	public void helpLevelUp(Character pCharacter, ArrayList pPlayerHand, int pCardChoice)
	{
		pCharacter.setLevel(pCharacter.getLevel() + 1); //Levels the player up
		
		pPlayerHand.remove(pCardChoice); //Removes the card from the player's hand
	}


}
