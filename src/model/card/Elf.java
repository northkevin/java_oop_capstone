package model.card;

public class Elf extends Card
{

	Elf() //Constructor
	{
		super();
		constructCard();
	}
	
	@Override
	public void constructCard() 
	{
		setName("Elf");
	}

}
