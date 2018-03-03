package model.card;

public abstract class Card {

private String name;
  
  Card() //Constructor
  {
    
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
