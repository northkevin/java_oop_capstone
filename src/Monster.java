import java.util.Random;

public class Monster extends DoorDeck
{
	int mLevel;
	int mVulnerability;
	int mGood;
	int mBad;
	
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
		String[] monsterNames = {"Malekith the Witch King", "Thresh the Chain Warden", 
				"Eredin King of the Wild Hunt", "Jerodiah Evil Lord of Calican", 
				"Archaon the EverChosen", "Kiodan Headman of the Vale", "Trayodath Sir of Trade", 
				"Ariohan Rabbi of the Dead", "Nergal the Plague Lord" };
		int index = (int) (Math.random() * monsterNames.length);
		String name = monsterNames[index];
		 
		return(name);
	}
	public void setLevel() 
	{
		Random lvlSelect = new Random(); 
		mLevel = (lvlSelect.nextInt(21) + 1);
	}
	public int getLevel() {return mLevel;}
	public void setVulnerability()
	{
		Random intSelect = new Random();
		mVulnerability = (intSelect.nextInt(5) + 1);
	}
	public int getVulnerability() {return mVulnerability;}
	public void setGood()
	{
		Random goodSelect = new Random();
		mGood = (goodSelect.nextInt(6) + 1);
	}
	public int getGood() {return mGood;}
	public void setBad()
	{
		Random badSelect = new Random();
		mBad = (badSelect.nextInt(11) + 1);
	}
	public int getBad() {return mBad;}
}

