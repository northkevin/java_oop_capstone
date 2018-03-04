import java.util.Random;

public class Treasure extends DoorDeck
{
	String treasureName;
	private int value;
	private int combatAdv;

	public Treasure() 
	{
		setTreasureName();
		setValue();
		setCombatAdv();
	}

	
	public String getTreasureName()
	{
		return treasureName;
	}
	
	public int getValue() 
	{
		return value;
	}

	public int getCombatAdv() 
	{
		return combatAdv;
	}

	//A monetary value between 100 and 400 gold pieces.Randomly picked of course.
	public void setValue() 
	{
		value = new Random().nextInt(300) + 100;
	}
	
	//A combat advantage value between 1 and 5.
	public void setCombatAdv() 
	{
		combatAdv = new Random().nextInt(5) + 1;
	}
	
	public void setTreasureName() //Sets a random treasure name
	{
		String[] treasureNames = {"Chest of Gold", "Vampyr Fang", "Talking Head", "Blue Goo", "Three Sided Gold Coin", "Zombie Hand", "Cat Statue", "Treasure Map", "Dust Bunny" };
		int index = (int) (Math.random() * treasureNames.length);
		String name = treasureNames[index];
		
		treasureName = name;
	}

  @Override
  public void constructCard()
  {
    // TODO Auto-generated method stub
    
  }
}
