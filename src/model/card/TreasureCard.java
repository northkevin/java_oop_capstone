package model.card;

public interface TreasureCard extends Card
{
  public void setValue();
  public void setCombatAdv();
  public String getName();
  public void setName(String pName);
  public int getValue();
  public void setValue(int value);
  public int getCombatAdv();
  public void setCombatAdv(int combatAdv);
}
