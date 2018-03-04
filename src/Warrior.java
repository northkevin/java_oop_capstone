import java.util.ArrayList;

public class Warrior extends DoorDeck implements AbilitySwitch
{
  private Boolean switchState;

	Warrior()
	{
		super();
		constructCard();
	}
	
	@Override
	public void constructCard() 
	{
		setName("Warrior");
	}

	
	public void berserking(Character pCharacter, ArrayList pPlayerHand)
	{
		turnOn();
	}

	
	@Override
  public void turnOn()
  {
    this.switchState = true;
  }

  @Override
  public void turnOff()
  {
    this.switchState = false;
  }

  @Override
  public Boolean isActive()
  {
    return this.switchState;
  }
}
