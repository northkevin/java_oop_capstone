package model.deck;

import java.util.ArrayList;
import model.card.Card;
import model.card.CardFactoryConcrete;

// https://www2.cs.duke.edu/csed/ap/cards/cardstuff.pdf

public class DoorDeck extends Deck<Card> {
 
  public DoorDeck() {
    super();
  }
  
  protected ArrayList<Card> createDeck(){
    ArrayList<Card> cards = new ArrayList<Card>();
    for(int i = 0; i < 30; i++) //30% monster cards
    { 
      cards.add(CardFactoryConcrete.makeMonster()); //Puts monsters in the door deck
    }      
    for(int i = 0; i < 30; i++) //30% curse cards
    { 
      cards.add(CardFactoryConcrete.makeCurse()); //Puts curses in the door deck
    }   
    for(int i = 0; i < 10; i++) //10% helpful cards
    { 
      cards.add(CardFactoryConcrete.makeHelpful()); //Puts helpful cards in the door deck
    }      
    for(int i = 0; i < 5; i++) //15% race cards
    { 
      cards.add(CardFactoryConcrete.makeElf()); //Adds race elfs to the door deck
      cards.add(CardFactoryConcrete.makeHalfling()); //Adds race halflings to the door deck
      cards.add(CardFactoryConcrete.makeDwarf()); //Adds race dwarves to the door deck
    } 
    for(int i = 0; i < 5; i++) //15% class cards
    { 
      cards.add(CardFactoryConcrete.makeWarrior()); //Adds class warriors to the door deck
      cards.add(CardFactoryConcrete.makeWizard()); //Adds class wizards to the door deck
      cards.add(CardFactoryConcrete.makeCleric()); //Adds class clerics to the door deck
    }
    return cards;
  }
}
