package model.deck;

import java.util.ArrayList;
import model.card.CardFactoryConcrete;
import model.card.TreasureCard;

public class TreasureDeck extends Deck<TreasureCard> {
  
  public TreasureDeck()
  {
    super();
  }

  @Override
  public ArrayList<TreasureCard> createDeck()
  {
    ArrayList<TreasureCard> treasureDeckCards = new ArrayList<TreasureCard>();
    
    for(int j = 0; j < 99; j++) //Will put 100 treasure cards in a deck of treasure
    {
      treasureDeckCards.add(CardFactoryConcrete.makeTreasure());
    }
    
    return treasureDeckCards;
  }

}
