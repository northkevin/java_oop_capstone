package application;

import java.io.FileInputStream;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import model.Character;
import model.Deck;
import model.Player;
import model.card.Cleric;
import model.card.Dwarf;
import model.card.Elf;
import model.card.Halfling;
import model.card.Helpful;
import model.card.Monster;
import model.card.Warrior;
import model.card.Wizard;

public class Main extends Application {
  
  Deck doorCards;
  Player player;
  private Stage primaryStage;
  private Scene primaryScene;
  private GridPane sceneGrid;
  private HBox cardsHbox;
  private HBox scene1Hbox;
  private Pane scenePane;
  private Scene scene2;
  private Scene scene3;
  private Scene scene4;
  private Scene scene5;
  private Game game;
  
  // copy paste of BOARD elements
  // -----
  // -----
  private Button bChangeRace;
  private Button bChangeClass;
  private Button bHelpfulLevel; //Button clicked to use helpful card to level up
  private Button bHelpfulSell; //Button clicked to use helfpul card to sell treasure for 2x
  private Button bHalflingSell; /*Halflings can sell 1 piece of treasure for double value per turn. 
              Goes gray if it has already been used. Also gray if they are not halfling*/
  private Button bSellTreasure; //Button clicked to sell treasure
  private Button bRules;
  private Button bDoorDeck; //Button to click to draw
  private Button bGoldLevel; //Pay 1000 gold to level up
  private Button bPlayMonster; //Can play a monster
  private Button bTreasureBonus; //Use a treasure card to gain a fight bonus
  private Button bTurning; //Cleric class ability
  private Button bFlight; //Wizard class ability
  private Button bBerserking; //warrior class ability
  private Button bCharm; //Wizard class ability
  private Button bMonsterEncounter; //For the monster card in monster encounter
  private Button bDiscard;
  private Button bGoBack;
  
  //Toggle Buttons (Cards)
  private ToggleButton card1;
  private ToggleButton card2;
  private ToggleButton card3;
  private ToggleButton card4;
  private ToggleButton card5;
  private ToggleButton card6; //For the dwarf or if too many cards are drawn
  private ToggleButton card7; //If the dwarf draws too many cards
  //Toggle Group
  private ToggleGroup cardGroup;
  
  //Labels
  private Label instructionLabel; //The top label in our GUI
  private Label actionLabel; //The bottom label in our GUI, will tell the use what they have done
  private Label characterInfo; //Will display player level, race, class, and gold
  private Label fakeLabel, fakeLabel2, fakeLabel3, fakeLabel4, fakeLabel5; //Just to help with the spacing in the gridpane
  private Label abilityLabel; //Says stuff about class abilities
  private Label monsterActionLabel; //Says stuff about using a treasure card in a monster encounter
  private Label characterMonsterInfo; //Like character info but with fight bonus and run bonus included
  
  //Making the pictures
  private FileInputStream munchkinBoard;
  private Image iBoard;
  private ImageView board;
  
  // Lines..
  private Line separator; 
  // -----
  // -----
  
  public static void main(String[] args)
  {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception
  {
    //TODO this needs to loop .. 
    initGame();
    this.primaryStage = primaryStage;
    initPrimaryScene();
  }

  // initializer for all game related objects
  // 
  // Deck
  // Cards
  // Player
  // Character
  // Treasure
  private void initGame() {
    // First thing the program does is make the door deck
    doorCards = new Deck();
    
    // Second thing the program does is deal the player 8 cards
    player = new Player();
    player.dealHand(doorCards, 8);
  }
  
  // initializer for primary scene
  // 
  // Scene 1
  private void initPrimaryScene() {
//    monsterDrawn = false;
//    
//    //Since it is not a monster encounter no class abilities have been used so they will be set to false
//    turningUsed = false;
//    berserkingUsed = false;
//    flightUsed = false;
//    charmUsed = false;
    game = new Game();
    
//  if(character.getRace() == "Dwarf") //Checks if player is a dwarf. If yes then sets their max cards to 6
//  {
//    maxCards = 6;
//  }
//  else
//  { 
//    maxCards = 5; //Will set it back to 5 if they stop being a dwarf
//  }
    
    //Setting up the layout
    initBoard();
    
    //Setting up the layout for Scene1
    bDoorDeck.setTranslateX(19);
    bDoorDeck.setTranslateY(497);
    sceneGrid = new GridPane();
    sceneGrid.setHgap(10);
    sceneGrid.setVgap(10);
    sceneGrid.add(instructionLabel, 1, 0, 7, 1);
    sceneGrid.add(bRules, 8, 0);
    sceneGrid.add(fakeLabel, 2, 3);
    sceneGrid.add(bChangeRace, 3, 3);
    sceneGrid.add(bChangeClass, 3, 5);
    sceneGrid.add(fakeLabel2, 4, 3);
    sceneGrid.add(bHelpfulLevel, 5, 3);
    sceneGrid.add(bHelpfulSell, 5, 5);
    sceneGrid.add(fakeLabel3, 6, 5);
    sceneGrid.add(bHalflingSell, 7, 3);
    sceneGrid.add(bSellTreasure, 7, 5);
    sceneGrid.add(separator, 1,10,8,1);
    cardsHbox = new HBox(10, characterInfo, card1, card2, card3, card4, card5); //Puts all the cards in one hbox
    sceneGrid.add(cardsHbox, 1, 12, 8, 1);
    sceneGrid.add(actionLabel, 1, 15, 8, 1);
    scene1Hbox = new HBox(board, sceneGrid); //Puts the board and the rest of the buttons(except bDoorDeck) in an hbox
    scenePane = new Pane(scene1Hbox, bDoorDeck); //Made a pane so I can put the door deck button wherever I want
    primaryScene = new Scene(scenePane, 1400, 700);
    primaryStage.setScene(primaryScene);
    primaryStage.setTitle("Munchkin First Draw");
    primaryStage.show();
    
    //Disabling all buttons at the beginning
    bChangeRace.setDisable(true);
    bChangeClass.setDisable(true);
    bHalflingSell.setDisable(true);
    bSellTreasure.setDisable(true);
    bHelpfulLevel.setDisable(true);
    bHelpfulSell.setDisable(true);
          
    //Enables the halfing race ability if the player is a halfling
    if(player.getCharacter().getRace() == "Halfling")
    {
      bHalflingSell.setDisable(false);
    }
   
    
//  //ToggleButton Actions for Scene 1
//  cardsSelected = 0; //There are automatically no cards selected
//  card1.setOnAction(e-> 
//  {
//    if(card1.isSelected())
//    {
//      cardChoice = 0; //Card is equal to playerhand.get(0). Card 1.
//      // card1.notifyObservers()
//    }
//    else
//    {
//      cardChoice = -1;
//    }
//    //Grays out or ungrays out the proper buttons
//    EnableButtons(cardChoice, playerHand);
//  });
//          
//  card2.setOnAction(e-> 
//  {
//    if(card2.isSelected())
//    {
//      cardChoice = 1; //Card is equal to playerhand.get(1). Card 2
//    }
//    else
//    {
//      cardChoice = -1;
//    }
//      
//    //Grays out or ungrays out the proper buttons
//    EnableButtons(cardChoice, playerHand);
//  });
//      
//  card3.setOnAction(e-> 
//  {
//    if(card3.isSelected())
//    {
//      cardChoice = 2; //Card is equal to playerhand.get(2). Card 3
//    }
//    else
//    {
//      cardChoice = -1;
//    }
//      
//    //Grays out or ungrays out the proper buttons
//    EnableButtons(cardChoice, playerHand);
//  });
//      
//  card4.setOnAction(e-> 
//  {
//    if(card4.isSelected())
//    {
//      cardChoice = 3; //Card is equal to playerhand.get(3). Card 4,   
//    }
//    else
//    {
//      cardChoice = -1;
//    }
//      
//    //Grays out or ungrays out the proper buttons
//    EnableButtons(cardChoice, playerHand);
//  });
//      
//  card5.setOnAction(e-> 
//  {
//    if(card5.isSelected())
//    {
//      cardChoice = 4; //Card is equal to playerhand.get(4);. Card 5
//    }
//    else 
//    {
//      cardChoice = -1;
//    }
//      
//    //Grays out or ungrays out the proper buttons
//    EnableButtons(cardChoice, playerHand);
//  });
//
//  //Button actions for Scene 1
//  bRules.setOnAction(e-> Rules());
//  bChangeRace.setOnAction(e-> characterHelper.changeRace(character, playerHand, cardChoice));
//  bChangeClass.setOnAction(e-> characterHelper.changeClass(character, playerHand, cardChoice));
//  bHelpfulLevel.setOnAction(e-> helpful.helpLevelUp(character, playerHand, cardChoice));
//  bHelpfulSell.setOnAction(e-> helpful.sellDoubleVal(character, playerHand, cardChoice));
//  bHalflingSell.setOnAction(e-> halfling.sellDouble(bHalflingSell, playerHand, character, cardChoice));
//  bSellTreasure.setOnAction(e-> playerHandHelper.sellTreasure(character, playerHand, cardChoice));
//  bDoorDeck.setOnAction(e->
//  {
//    playerHandHelper.drawDoor(doorCards, playerHand);
//    Draw1st = true;
//    
//    //Makes sure the player doesn't go over their card limit
//    if(playerHand.size() > maxCards)
//    {
//      discardScene(pPrimaryStage);
//    }
//    else
//    {
//      switchScene(pPrimaryStage);
//    }
//    
//  });
//}
//
//public void EnableButtons(int pCardChoice, ArrayList pPlayerHand)
//{
//  
//  if(pCardChoice == -1)
//  {
//    bChangeRace.setDisable(true);
//    bChangeClass.setDisable(true);
//    bGoldLevel.setDisable(true);
//    bPlayMonster.setDisable(true);
//    bHalflingSell.setDisable(true); // unique
//    bSellTreasure.setDisable(true);
//    bTreasureBonus.setDisable(true); // half/half
//    bHelpfulLevel.setDisable(true);
//    bHelpfulSell.setDisable(true);
//  }
//  else
//  { 
//    if(pPlayerHand.get(pCardChoice) instanceof Monster) //Makes play monster clickable if the card is a monster. All others are gray.
//    {
//      bHelpfulLevel.setDisable(true);
//      bHelpfulSell.setDisable(true);
//      bPlayMonster.setDisable(false);
//      bChangeRace.setDisable(true);
//      bChangeClass.setDisable(true);
//      bGoldLevel.setDisable(true);
//      bSellTreasure.setDisable(true);
//    }
//    else if(pPlayerHand.get(pCardChoice) instanceof Treasure) //Makes sell treasure and treasure bonus clickable if the card is a treasure card. All others are gray.
//    {
//      bSellTreasure.setDisable(false);
//      bChangeRace.setDisable(true);
//      bChangeClass.setDisable(true);
//      bGoldLevel.setDisable(true);
//      bPlayMonster.setDisable(true);
//      bTreasureBonus.setDisable(false);
//      bHelpfulLevel.setDisable(true);
//      bHelpfulSell.setDisable(true);
//    
//    }
//    //Makes change race clickable if the card is a race card. All others are gray.
//    else if(pPlayerHand.get(pCardChoice) instanceof Halfling || pPlayerHand.get(pCardChoice) instanceof Elf || pPlayerHand.get(pCardChoice) instanceof Dwarf)
//    {
//      bChangeRace.setDisable(false);
//      bChangeClass.setDisable(true);
//      bGoldLevel.setDisable(true);
//      bPlayMonster.setDisable(true);
//      bSellTreasure.setDisable(true);
//      bHelpfulLevel.setDisable(true);
//      bHelpfulSell.setDisable(true);
//    }
//    //Makes change class clickable if the card is a class card. All others are gray.
//    else if(pPlayerHand.get(pCardChoice) instanceof Cleric || pPlayerHand.get(pCardChoice) instanceof Warrior || pPlayerHand.get(pCardChoice) instanceof Wizard)
//    {
//      bChangeRace.setDisable(true);
//      bChangeClass.setDisable(false);
//      bGoldLevel.setDisable(true);
//      bPlayMonster.setDisable(true);
//      bSellTreasure.setDisable(true);
//      bHelpfulLevel.setDisable(true);
//      bHelpfulSell.setDisable(true);
//    }
//    //Makes helpful level and helpful sell clickable if the card chosen is a helpful card. All others are gray.
//    else if (pPlayerHand.get(pCardChoice) instanceof Helpful)
//    {
//      bHelpfulLevel.setDisable(false);
//      bHelpfulSell.setDisable(false);
//      bChangeRace.setDisable(true);
//      bChangeClass.setDisable(true);
//      bGoldLevel.setDisable(true);
//      bPlayMonster.setDisable(true);
//      bSellTreasure.setDisable(true);
//      bTreasureBonus.setDisable(true);
//    }
//    //If it isn't any of the above then the button is disabled
//    else
//    {
//      bHelpfulLevel.setDisable(true);
//      bHelpfulSell.setDisable(true);
//      bChangeRace.setDisable(true);
//      bChangeClass.setDisable(true);
//      bGoldLevel.setDisable(true);
//      bPlayMonster.setDisable(true);
//      bSellTreasure.setDisable(true);
//      bTreasureBonus.setDisable(true);
//    }
//  }
//}
    cardGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
      @Override
      public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue)
      {
        //TODO  refactor this out of Main.java to take directions from some kind of controller class that decides how buttons are displayed based on player state.
        
        // if togglebutton is selected, get the button selected
        if(cardGroup.getSelectedToggle() != null)
        {
          // need to identify the toggle buttons with a card number.. enum goes somewhere.. to tired.
          //TODO make this work lol
          // ButtonController.displayButtonsFor(cardGroup.getSelectedToggle());
        }
        else
        {
          // ButtonController.displayButtonsNone(null);
        }
        
      }
    });
  }
      


  private void initBoard() {
  //Creating and styling buttons
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
        
    //Creating and styling toggle buttons
    card1 = new ToggleButton("Card1");
    card2 = new ToggleButton("Card2");
    card3 = new ToggleButton("Card3");
    card4 = new ToggleButton("Card4");  
    card5 = new ToggleButton("Card5");    
    card6 = new ToggleButton("Card6");
    
    //Putting the toggle buttons into a group
    cardGroup = new ToggleGroup();
    card1.setToggleGroup(cardGroup);
    card2.setToggleGroup(cardGroup);
    card3.setToggleGroup(cardGroup);
    card4.setToggleGroup(cardGroup);
    card5.setToggleGroup(cardGroup);
    card6.setToggleGroup(cardGroup);
        
        
    //Creating and styling labels
    instructionLabel = new Label("  Please pick a card from your hand to proceed with one of the grayed out options below!");
    instructionLabel.setId("instructionLabel");
    
    //ImaginaryLabels to help with spacing
    fakeLabel = new Label();
    fakeLabel2 = new Label();
    fakeLabel3 = new Label();
    fakeLabel4 = new Label();
    fakeLabel5 = new Label();
    fakeLabel5.setId("fakeLabel5");
    //End of spacing labels
    
    actionLabel = new Label(" Please click on the door deck to draw and continue your adventure!");
    actionLabel.setId("actionLabel");
    
    characterInfo = new Label("Player Level: 1 \nPlayer Race: Human\nPlayer Class: none\nPlayer Gold: 0");
    
    monsterActionLabel = new Label("  Please pick a treasure card from your hand to proceed with the\n  grayed out option below");
    monsterActionLabel.setId("monsterActionLabel");
    
    abilityLabel = new Label("  Class abilities are below. Abilities that aren't used\n by your current class will be grayed out.");
    abilityLabel.setId("abilityLabel");
    
    characterMonsterInfo = new Label("Player Level: 1 \nPlayer Race: Human\nPlayer Class: none\nPlayer Gold: 0\nFight Bonus: 0\nRun Bonus: 0");
        
    //Making line to seperate buttons and cards
    separator = new Line(0, 1, 1200, 1);
        
    board = new ImageView(iBoard);
    board.setId("munchkinBoard");
  }
}
