import java.util.ArrayList;
import java.util.Random;

public class Curse extends DoorDeck {

	ArrayList<String> curseList;
	ArrayList<Integer> numList;

	Curse() // Constructor
	{
		super();
		curseList = new ArrayList<String>();
		numList = new ArrayList<Integer>();
		constructCard();
	}

	// 1-2:Hex of Grief--Loosing the same number of items as the number picked
		// 3:Curse of Imbalance--Losing raceand become human
		// 4-5:The Shaking Cure--Losing race and draw a random new race card
		// 6-7:Curse of the Waste-- Losing class
		// 8-10: Heart of Stone--Losing a level
	@Override
	public void constructCard() {
		// TODO Auto-generated method stub
		String[] CurseNames = { "Hex of Grief", "Curse of Imbalance", "The Shaking Cure", "Curse of the Waste",
				"Heart of Stone" };
		for (int i = 0; i < 30; i++) {
			int n = new Random().nextInt(10);
			numList.add(n);
			if (n == 0 || n == 1) {
				curseList.add(CurseNames[0]);
			} else if (n == 2) {
				curseList.add(CurseNames[1]);
			} else if (n == 3 || n == 4) {
				curseList.add(CurseNames[2]);
			} else if (n == 5 || n == 6) {
				curseList.add(CurseNames[3]);
			} else {
				curseList.add(CurseNames[4]);
			}
		}
	}
}
