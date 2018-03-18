package model.card;

public class CardFactoryConcrete {

  public static Cleric makeCleric()
  {
    return new Cleric();
  }
  
  public static Curse makeCurse()
  {
    return new Curse();
  }
  
  public static Dwarf makeDwarf()
  {
    return new Dwarf();
  }
  
  public static Elf makeElf()
  {
    return new Elf();
  }
  
  public static Halfling makeHalfling()
  {
    return new Halfling();
  }
  
  public static Helpful makeHelpful()
  {
    return new Helpful();
  }
  
  public static Monster makeMonster()
  {
    return new Monster();
  }
  
  public static Treasure makeTreasure()
  {
    return new Treasure();
  }
  
  public static Warrior makeWarrior()
  {
    return new Warrior();
  }
  
  public static Wizard makeWizard()
  {
    return new Wizard();
  }

}
