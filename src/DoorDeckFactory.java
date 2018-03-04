
public class DoorDeckFactory 
{

	DoorDeckFactory()//Constructor
	{
		
	}
	
	public static DoorDeck createCard(int pBuildChoice)
	{
		DoorDeck card = null;
		
		switch(pBuildChoice)
		{
		
		case 1: 
			card = new Monster();
		break;
		case 2:	
			card = new Helpful();
		break;
		case 3: 
			card = new Curse();
		break;
		case 4:
			card = new Warrior();
		break;	
		case 5:
			card = new Wizard();
		break;
		case 6:
			card = new Cleric();
		break;
		case 7: 
			card = new Elf();
		break;
		case 8:
			card = new Halfling();
		break;
		case 9:
			card = new Dwarf();
		break;
		case 10:
		  card = new Treasure();
		  break;
		}
		
		
		return card;
	}
}
