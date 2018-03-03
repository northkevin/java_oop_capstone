package model;

import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.card.Card;

public class Player implements Playable{
  
  private ArrayList<Card> hand;
  private Character character;
  private int maxCards;
  
  public Player() {
    this.hand = new ArrayList<Card>();
    this.character = new Character();
    calcMaxCards();
  }
  
  // Deal numOfCards from gameDeck to this player's hand
  public void dealHand(Deck gameDeck, int numOfCards) {
    for(int i = 0; i < numOfCards; i++) 
    {
      if(gameDeck.hasNext()) 
      {
        this.hand.add(gameDeck.next());
      }
      else 
      {
        System.out.println("Deck is Empty!");
      }
    }
  }
  
  
  public Character getCharacter() {
    return this.character;
  }
  
  public int getMaxCards() 
  {
    return this.maxCards;
  }
  
  public ArrayList<Card> getHand()
  {
    return this.hand;
  }
  
  private void calcMaxCards() 
  {
    if(getCharacter().getRace() == "Dwarf")
    {
      this.maxCards = 6;
    }
    else
    {
      this.maxCards = 5;
    }
  }
  
  
  
  @Override
  public void changeRace(Character pCharacter, ArrayList pPlayerHand, int pCardChoice)
  {
    // TODO Auto-generated method stub
    calcMaxCards();
  }

  @Override
  public void changeClass(Character pCharacter, ArrayList pPlayerHand, int pCardChoice)
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void buyLevel(Character pCharacte, int pCardChoice)
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void combat(Character pCharacter, ArrayList pPlayerHand)
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void run(Character pCharacter)
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void playMonster(Character pCharacter, ArrayList pPlayerHand, int pCardChoice)
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void sellTreasure(Character pCharacter, ArrayList pPlayerHand, int pCardChoice)
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void drawDoor(ArrayList pDoorCards, ArrayList pPlayerHand)
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void useTreasure(Character pcharacter, ArrayList pPlayerHand, int pCardChoice)
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void discardAbility(Character pChar, Label pInstructionLabel, int pCardsSelected, ArrayList pPlayerHand,
      boolean pCard1Choice, boolean pCard2Choice, boolean pCard3Choice, boolean pCard4Choice, boolean pCard5Choice)
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void discard(Label pInstructionLabel, int pCardsSelected, Stage pSecondaryStage, ArrayList pPlayerHand,
      boolean pCard1Choice, boolean pCard2Choice, boolean pCard3Choice, boolean pCard4Choice, boolean pCard5Choice)
  {
    // TODO Auto-generated method stub
    
  }

  
}
