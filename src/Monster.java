import java.util.Random;

public class Monster extends DoorDeck
{
	int mLevel;
	int mVulnerability;
	int mGood; //Corresponds to how much treasure you get. Between 1 and 5
	int mBad; //How much treasure, items or levels you lose
	
	/*mBad 1,2 you lose levels (1 or 2 depending on the role)
	 * 3 lose the biggest item in hand
	 * 4 lose two items from your hand
	 * 5 You die*/

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
	
	public void setLevel() 
	{
		Random lvlSelect = new Random(); 
		mLevel = (lvlSelect.nextInt(21) + 1);
	}
	
	public int getLevel() {return mLevel;}
	
	public void setVulnerability()
	{
		Random intSelect = new Random();
		mVulnerability = (intSelect.nextInt(11) + 1);
		
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
