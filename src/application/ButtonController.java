package application;

import javafx.scene.control.Button;
import javafx.scene.control.Toggle;

public class ButtonController {
  
  Button bChangeRace;
  Button bChangeClass;
  Button bHelpfulLevel; //Button clicked to use helpful card to level up
  Button bHelpfulSell; //Button clicked to use helfpul card to sell treasure for 2x
  Button bHalflingSell; /*Halflings can sell 1 piece of treasure for double value per turn. 
              Goes gray if it has already been used. Also gray if they are not halfling*/
  Button bSellTreasure; //Button clicked to sell treasure
  Button bRules;
  Button bDoorDeck; //Button to click to draw
  Button bGoldLevel; //Pay 1000 gold to level up
  Button bPlayMonster; //Can play a monster
  Button bTreasureBonus; //Use a treasure card to gain a fight bonus
  Button bTurning; //Cleric class ability
  Button bFlight; //Wizard class ability
  Button bBerserking; //warrior class ability
  Button bCharm; //Wizard class ability
  Button bMonsterEncounter; //For the monster card in monster encounter
  Button bDiscard;
  Button bGoBack;
  
//TODO move button init here
  public ButtonController() {
    initButtons();
  }
  
  public void initButtons() {
    bChangeRace = new Button("Change Race");
    bChangeClass = new Button("Change Class");
    bHelpfulLevel = new Button("Use Helpful Card \nto Level Up");
    bHelpfulSell = new Button("Use Helpful Card \nto Sell Treasure for 2x");
    bSellTreasure = new Button("Sell Treasure");
    bHalflingSell = new Button("Use halfling ability \nto Sell Treasure for 2x");
    
    bRules = new Button("Rules");
    bRules.setId("bRules");
    bDoorDeck = new Button();
    bDoorDeck.setId("bDoorDeck");
    
    bGoldLevel = new Button("Pay 1000 Gold to Level Up");
    bPlayMonster = new Button("Play Monster");
    bTreasureBonus = new Button("Use a Treasure Card \nto Gain a Fight Bonus");
    bTurning = new Button("Turning(Cleric)");
    bFlight = new Button("Flight(Wizard)");
    bBerserking = new Button("Berserking(Warrior)");
    bCharm = new Button("Charm(Wizard)");
    
    bMonsterEncounter = new Button("Monster");
    bMonsterEncounter.setId("bMonsterEncounter");
    
    bDiscard = new Button("Discard");
  }
//TODO pass player obj to a method OR implement an Observable between Player and ButtonController

  public static void displayButtonsFor(Toggle selectedToggle)
  {
    //TODO move button event here for disabling buttons based on state of Player's hand
    
  }

  public static void displayButtonsNone(Object object)
  {
  //TODO move button event here for disabling all button  
// From Main.java -->
//
//    bChangeRace.setDisable(true);
//    bChangeClass.setDisable(true);
//    bHalflingSell.setDisable(true);
//    bSellTreasure.setDisable(true);
//    bHelpfulLevel.setDisable(true);
//    bHelpfulSell.setDisable(true);
  }

  public static void checkDispayHalflingButton()
  {
    // from Main.java -->
    //
    //  //Enables the halfing race ability if the player is a halfling
    //  if(player.getCharacter().getRace() == "Halfling")
    //  {
    //    bHalflingSell.setDisable(false);
    //  }
    
  }
  
  
  
  

}
