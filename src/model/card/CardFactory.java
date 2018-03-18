package model.card;

public abstract class CardFactory implements Card{

  private String name;
  
  public CardFactory() //Constructor
  {
    constructCard();
  }
  
  public abstract void constructCard();
  
  public String getName()
  {
    return this.name;
  }
  
  public void setName(String pName)
  {
    this.name = pName;
  }
}
