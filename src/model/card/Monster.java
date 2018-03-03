package model.card;

public class Monster extends Card
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
		String[] monsterNames = {"Malekith the Witch King", "Thresh the Chain Warden", "Eredin King of the Wild Hunt", "Jerodiah Evil Lord of Calican", "Archaon the EverChosen", "Kiodan Headman of the Vale", "Trayodath Sir of Trade", "Ariohan Rabbi of the Dead", "Nergal the Plague Lord" };
		int index = (int) (Math.random() * monsterNames.length);
		String name = monsterNames[index];
		 
		return(name);
		
	}
}
