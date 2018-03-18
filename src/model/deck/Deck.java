package model.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public abstract class Deck<CardType> implements Iterator<CardType> {

  public static final int DECK_SIZE=100;
  private ArrayList<CardType> cards;
  private int myIndex;
  
  public Deck() {
    this.cards = createDeck();
    shuffle(); 
  }
  
  protected abstract ArrayList<CardType> createDeck();
  
  private void shuffle()
  {
    Collections.shuffle(this.cards);
    this.myIndex = 0;
  }
  
  @Override
  public boolean hasNext()
  {
    return this.myIndex < this.cards.size();
  }
  

  @Override
  public CardType next()
  {
    CardType card = (CardType) this.cards.get(myIndex);
    this.myIndex++;
    return card;
  }
  
  
}
