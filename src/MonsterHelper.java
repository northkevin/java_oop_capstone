import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Comparator;

public class MonsterHelper 
{
	Monster newMonster = new Monster();
	Character newCharacter = new Character();
	Treasure treasureCard = new Treasure();
	Random indexGen = new Random();
	
	int charLevel;
	int listIndex;
	
	MonsterHelper() //constructor
	{
		
	}
	public int collectTreasure()
	{
		//give player treasure cards, randomized from 1-5
		int mTreasure; 
		newMonster.setGood();
		mTreasure = newMonster.getGood();
		return mTreasure;
	}
	@SuppressWarnings("rawtypes")
	public void collectLoss(ArrayList playerHand)
	{
		int mBadStuff;
		newMonster.setBad();
		mBadStuff = newMonster.getBad();
		switch(mBadStuff)
		{
		case 1:
			System.out.println("You've lost 1 level");
			charLevel = newCharacter.getLevel();
			newCharacter.setLevel(charLevel - 1);
			break;
		case 2: 
			System.out.println("You've lost 2 levels");
			charLevel = newCharacter.getLevel();
			newCharacter.setLevel(charLevel - 2);
			break;
		case 3: 
			System.out.println("You've lost your biggest item"); 
			int arraySize = playerHand.size();
			int[][] cardValues = new int[arraySize][2]; //first column: card value, second column: array position
			for(int i=0; i<playerHand.size(); i++)
			{
				if(playerHand.get(i) instanceof Treasure)
				{
					//get the value of the treasure card, compare it to another treasure card
					//in the player's hand
					int goldValue;
					goldValue = ((Treasure) playerHand.get(i)).getValue(); 
					cardValues = new int[][]{{goldValue, i}};
				}		
			}
			//sorts the value based on the values in the first column 
			Arrays.sort(cardValues, new Comparator<int[]>() {
				public int compare(int[] a, int[] b) {
					return b[0] - a[0];
				}
			});
			//TODO: Could this be done with the discard method?
			playerHand.remove(cardValues[0][0]);
		case 4: 
			System.out.println("You've lost 2 items");
			for(int i = 0; i < 1; i ++)
			{
				listIndex = indexGen.nextInt(playerHand.size());
				playerHand.remove(listIndex);
			}
		case 5: 
			System.out.println("You've died");
			newCharacter.setIsDead(true); 
		}
	}
	public void levelUp()
	{
		charLevel = newCharacter.getLevel();
		newCharacter.setLevel(charLevel + 1);
		System.out.println("You've gained a level");
	}
	public void vulnerabilitySelect()
	{
		newMonster.setVulnerability();
		int vulnerability = newMonster.getVulnerability();
		switch(vulnerability)
		{
		case 1:
			System.out.println("Only elves are vulnerable to this monster");
			break;
		case 2: 
			System.out.println("Only halflings are vulnerable to this monster");
			break;
		case 3:
			System.out.println("Only dwarves are vulnerable to this monster");
			break;
		default:
			System.out.println("All races are vulnerable to thise monster");
			break;
		}
	}
	
}

