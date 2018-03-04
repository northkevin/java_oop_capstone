import java.util.ArrayList;

public class Cleric extends DoorDeck implements AbilitySwitch{
  
  private Boolean switchState;

	Cleric() //Constructor
	{
		super();
		constructCard();
		this.switchState = false;
	}
	
	@Override
	public void constructCard()
	{
		setName("Cleric");
	}
	
	//Cleric class ability
	public void turning(Character pCharacter, ArrayList pPlayerHand)
	{
		turnOn();
	}

	// This will be interface used inside of PlayerHandHelper#discardAbility method , where state of this class is used during game.
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
