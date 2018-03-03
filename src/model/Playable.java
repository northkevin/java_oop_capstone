package model;

import java.util.ArrayList;

import javafx.scene.control.Label;
import javafx.stage.Stage;

public interface Playable {

  public void changeRace(Character pCharacter, ArrayList pPlayerHand, int pCardChoice); //Sets the player's race
  
  public void changeClass(Character pCharacter, ArrayList pPlayerHand, int pCardChoice); //Sets the player's class
  
  public void buyLevel(Character pCharacte, int pCardChoice); //Sets the player's level after they buy a level(have to have enough money)
  
  public void combat(Character pCharacter, ArrayList pPlayerHand); //Compares the fight bonus + player level to monster level. Also calls run if they fail.

  public void run(Character pCharacter); //Rolls the dice and adds it to the player's bonus to run. 5 and above is success. For elf 4 and above.
  
  public void playMonster(Character pCharacter, ArrayList pPlayerHand, int pCardChoice);
  
  public void sellTreasure(Character pCharacter, ArrayList pPlayerHand, int pCardChoice);
  
  public void drawDoor(ArrayList pDoorCards, ArrayList pPlayerHand);
  
  public void useTreasure(Character pcharacter, ArrayList pPlayerHand, int pCardChoice);
  
  //Used in Scene 4 and Scene 5. Discards the cards the player chose to discard. booleans will be true if they chose them.
  public void discardAbility(Character pChar, Label pInstructionLabel, int pCardsSelected, ArrayList pPlayerHand, boolean pCard1Choice, boolean pCard2Choice, boolean pCard3Choice, boolean pCard4Choice, boolean pCard5Choice);
  
  //Used in Scene 4. Discards the cards the player chose to discard. booleans will be true if they chose them. Has to discard at least one card.
  public void discard(Label pInstructionLabel, int pCardsSelected, Stage pSecondaryStage, ArrayList pPlayerHand, boolean pCard1Choice, boolean pCard2Choice, boolean pCard3Choice, boolean pCard4Choice, boolean pCard5Choice);
}
