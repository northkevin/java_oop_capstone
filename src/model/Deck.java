package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import model.card.Card;
import model.card.CardFactory;

// https://www2.cs.duke.edu/csed/ap/cards/cardstuff.pdf

public class Deck implements Iterator<Card>{
  public static final int DECK_SIZE=100;
  private ArrayList<Card> doorDeckCards;
  private int myIndex;
  
  public Deck() {
    this.doorDeckCards = new ArrayList<Card>();
    for(int i = 0; i < 30; i++) //30% monster cards
    { 
      this.doorDeckCards.add(CardFactory.createCard(1)); //Puts monsters in the door deck
    }      
    for(int i = 0; i < 30; i++) //30% curse cards
    { 
      this.doorDeckCards.add(CardFactory.createCard(3)); //Puts curses in the door deck
    }   
    for(int i = 0; i < 10; i++) //10% helpful cards
    { 
      this.doorDeckCards.add(CardFactory.createCard(2)); //Puts helpful cards in the door deck
    }      
    for(int i = 0; i < 5; i++) //15% race cards
    { 
      this.doorDeckCards.add(CardFactory.createCard(7)); //Adds race elfs to the door deck
      this.doorDeckCards.add(CardFactory.createCard(8)); //Adds race halflings to the door deck
      this.doorDeckCards.add(CardFactory.createCard(9)); //Adds race dwarves to the door deck
    } 
    for(int i = 0; i < 5; i++) //15% class cards
    { 
      this.doorDeckCards.add(CardFactory.createCard(4)); //Adds class warriors to the door deck
      this.doorDeckCards.add(CardFactory.createCard(5)); //Adds class wizards to the door deck
      this.doorDeckCards.add(CardFactory.createCard(6)); //Adds class clerics to the door deck
    }
            
    shuffle(); 
  }
  
  private void shuffle()
  {
    Collections.shuffle(this.doorDeckCards);
    this.myIndex = 0;
  }

  @Override
  public boolean hasNext()
  {
    return myIndex < this.doorDeckCards.size();
  }

  @Override
  public Card next()
  {
    Card card = (Card) this.doorDeckCards.get(myIndex);
    myIndex++;
    return card;
  }

}
