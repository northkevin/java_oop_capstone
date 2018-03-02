
public abstract class DoorDeck 
{

	private String name;
	
	DoorDeck() //Constructor
	{
		
	}
	
	public abstract void constructCard();
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String pName)
	{
		name = pName;
	}
}
