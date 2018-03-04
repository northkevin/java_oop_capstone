import java.util.ArrayList;

public class CharacterHelper 
{
	int characterLevel;

	CharacterHelper()
	{

	}

	public void changeRace(Character pCharacter, ArrayList pPlayerHand, int pCardChoice)
	{
		//Sets the player's race
		String raceType = pPlayerHand.get(pCardChoice).toString();
		pCharacter.setRace(raceType);

		String newRace = pCharacter.getRace();
		System.out.println("Race Changed"); //For testing only. Sees the button is working
		System.out.println("You changed your race to a " + newRace.toString());
	}

	public void changeClass(Character pCharacter, ArrayList pPlayerHand, int pCardChoice) //Sets the player's class
	{
		String classType = pPlayerHand.get(pCardChoice).toString();

		pCharacter.setPlayerClass(classType);
		String newClass = pCharacter.getplayerClass();

		System.out.println("Class Changed"); //For testing only. Sees the button is working
		System.out.println("You changed your class to a " + newClass.toString());

	}

	public void buyLevel(Character pCharacter, int pCardChoice) 
	{
		double levelPrice = 1000;
		//Sets the player's level after they buy a level (have to have enough money)
		if(pCharacter.getGold() > levelPrice) {
			System.out.println("You leveled up.");
			characterLevel = pCharacter.getLevel() + 1;
			pCharacter.setLevel(characterLevel);
		}		
		else {
			System.out.println("You leveled up.");
		}
	}

	public void combat(Character pCharacter, ArrayList pPlayerHand, MonsterHelper pMonsterHelper) //Compares the fight bonus + player level to monster level. Also calls run if they fail.
	{
		int combatStrength = pCharacter.getLevel() + pCharacter.getFightBonus();

		if (combatStrength > pMonsterHelper.getMonsterLevel()) {
			System.out.println("Monster fought"); //For testing only. Sees the button is working
			System.out.println("You Win");
			characterLevel = pCharacter.getLevel() + 1;
			pCharacter.setLevel(characterLevel);
		}
		else {
			System.out.println("Monster fought");
			System.out.println("Run Away!");
			run(pCharacter);
		}
		//Compares the fight bonus + player level to monster level. Also calls run if they fail.
		/***Pseudo*: If they lose then below will be called.
		 *Pseudo*: Use pCharacter.getFightBonus();**/
	}

	public void run(Character pCharacter) //Rolls the dice and adds it to the player's bonus to run. 5 and above is success. For elf 4 and above.
	{
		// Roll the dice
		int rollResult = (int) (Math.random()* (6-1)+1); 	// (highest = lowest) + lowest

		// Monster type
		MonsterHelper monsterType = new MonsterHelper();

		while(pCharacter.getRace() != null) {
			
			// Elf wins if they roll greater than 4
			if(pCharacter.getRace() == "Elf") {
				if(rollResult > 4) { 
					// success; player run
					System.out.println("You Win");
					monsterType.collectTreasure();
				
				}
				else {
					// loss
					monsterType.collectLoss();
				
				}
			}
			else
			{
				if(rollResult >= 5) {
					// success; player run
					System.out.println("Success, You Win!");
					characterLevel = pCharacter.getLevel() + 1;

					// treasure bonus?
					pCharacter.setRunBonus(characterLevel);
					pCharacter.setLevel(pCharacter.getRunBonus());
					// collect level and treasure
					// move up a level
					// collect how many  points?
				}
				else {
					// Halfling gets to run again if they lose
					if(pCharacter.getRace() == "Halfling"){
						System.out.println("You lost but you may run again. \nRun away!");
						return;
					}
					else
					{
						// loss
						monsterType.collectLoss();

					}
				}
			}
			/***Pseudo*: Use pCharacter.getRunBonus**/
		}
	}
