
public class Character 
{
	String race; 
	String playerClass;
	int level = 0;
	boolean isDead = false;
	int gold = 0;
	int fightBonus = 0;
	int runBonus = 0;
	
	
	Character() //Constructor
	{
		race = "Human";
		playerClass = "Cleric";
	}
	
	public String getRace()
	{
		return race;
	}
	
	public String getplayerClass()
	{
		return playerClass;
	}  
	
	public int getLevel()
	{
		return level;
	}
	
	public boolean getIsDead()
	{
		return isDead;
	}
	
	public int getGold()
	{
		return gold;
	}
	
	public int getFightBonus()
	{
		return fightBonus;
	}
	
	public int getRunBonus()
	{
		return runBonus;
	}
	
	public void setFightBonus(int pFightBonus)
	{
		fightBonus = pFightBonus;
	}
	
	public void setRunBonus(int pRunBonus)
	{
		runBonus = pRunBonus;
	}
	
	
	
}
