
public class Monster extends DoorDeck
{

	Monster() //Constructor
	{
		super();
		constructCard();
	}
	
	@Override
	public void constructCard()
	{
		setName(randomMonsterName());
	}
	
	public String randomMonsterName() //Will generate a monster name from a list of sp00ky names
	{
		String[] monsterNames = {"Malekith \nthe Witch King\n", "Thresh \nthe Chain Warden\n", "Eredin \nKing of the Wild Hunt\n", "Jerodiah \nEvil Lord of Calican\n", "\nArchaon \nthe EverChosen", "Kiodan \nHeadman of the Vale\n", "Trayodath \nSir of Trade\n", "Ariohan \nRabbi of the Dead\n", "Nergal \nthe Plague Lord\n" };
		int index = (int) (Math.random() * monsterNames.length);
		String name = monsterNames[index];
		 
		return(name);
		
	}
}
