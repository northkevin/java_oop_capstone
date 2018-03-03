import java.util.Random;

public class Treasure {
	private int monetaryValue;
	private int combatValue;

	public Treasure() {
		setMonetaryValue();
		setCombatValue();
	}

	// a serial of set and get function
	public int getMonetaryValue() {
		return this.monetaryValue;
	}

	public int getCombatValue() {
		return this.combatValue;
	}

	//A monetary value between 100 and 400 gold pieces.Randomly picked of course.
	public void setMonetaryValue() {
		monetaryValue = new Random().nextInt(300) + 100;
	}
	
	//A combat advantage value between 1 and 5.
	public void setCombatValue() {
		combatValue = new Random().nextInt(5) + 1;
	}
}
