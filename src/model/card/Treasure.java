package model.card;

import java.util.Random;

public class Treasure extends CardFactory implements TreasureCard {
  
  private String name;
  private int value;
  private int combatAdv;
  
  public Treasure() //Constructor
  {
    super();
  }
  
  @Override
  public void constructCard()
  {
    setTreasureName();
    setValue();
    setCombatAdv();
  }
  
  private void setTreasureName() //Sets a random treasure name
  {
    String[] treasureNames = {"Chest of Gold", "Vampyr Fang", "Talking Head", "Blue Goo", "Three Sided Gold Coin", "Zombie Hand", "Cat Statue", "Treasure Map", "Dust Bunny" };
    int index = (int) (Math.random() * treasureNames.length);
    String name = treasureNames[index];
    setName(name);
  }
  
//A monetary value between 100 and 400 gold pieces.Randomly picked of course.
  public void setValue() 
  {
    this.value = new Random().nextInt(300) + 100;
  }
  
  //A combat advantage value between 1 and 5.
  public void setCombatAdv() 
  {
    this.combatAdv = new Random().nextInt(5) + 1;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setName(String pName)
  {
    this.name = pName;
  }

  public int getValue()
  {
    return value;
  }

  public void setValue(int value)
  {
    this.value = value;
  }

  public int getCombatAdv()
  {
    return combatAdv;
  }

  public void setCombatAdv(int combatAdv)
  {
    this.combatAdv = combatAdv;
  }
  


  

}
