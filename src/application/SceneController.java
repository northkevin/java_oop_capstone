package application;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collection;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class SceneController {
  Scene currentScene;
  GridPane sceneGrid;
  HBox cardsHbox;
  HBox sceneHbox;
  Pane scenePane;
  Game game;
  
  //Toggle Buttons (Cards)
  ToggleButton card1;
  ToggleButton card2;
  ToggleButton card3;
  ToggleButton card4;
  ToggleButton card5;
  ToggleButton card6; //For the dwarf or if too many cards are drawn
  ToggleButton card7; //If the dwarf draws too many cards
  //Toggle Group
  ToggleGroup cardGroup;
  ArrayList<ToggleButton> cards;
  
  //Labels
  Label instructionLabel; //The top label in our GUI
  Label actionLabel; //The bottom label in our GUI, will tell the use what they have done
  Label characterInfo; //Will display player level, race, class, and gold
  Label fakeLabel, fakeLabel2, fakeLabel3, fakeLabel4, fakeLabel5; //Just to help with the spacing in the gridpane
  Label abilityLabel; //Says stuff about class abilities
  Label monsterActionLabel; //Says stuff about using a treasure card in a monster encounter
  Label characterMonsterInfo; //Like character info but with fight bonus and run bonus included
  
  //Making the pictures
  ImageView board;
  
  // Lines..
  Line separator; 
  
  ButtonController buttonController;
  
  public SceneController() {
    buttonController = new ButtonController();
    initUIElementsForScene();
    initLayoutElementsForScene();
    initScene();
  }
  private void initScene() 
  {
  //Setting up the layout for Scene1
    //TODO move margin translate numbers into CSS
    buttonController.bDoorDeck.setTranslateX(19);
    buttonController.bDoorDeck.setTranslateY(497);
    sceneGrid.setHgap(10);
    sceneGrid.setVgap(10);
    sceneGrid.add(instructionLabel, 1, 0, 7, 1);
    sceneGrid.add(buttonController.bRules, 8, 0);
    sceneGrid.add(fakeLabel, 2, 3);
    sceneGrid.add(buttonController.bChangeRace, 3, 3);
    sceneGrid.add(buttonController.bChangeClass, 3, 5);
    sceneGrid.add(fakeLabel2, 4, 3);
    sceneGrid.add(buttonController.bHelpfulLevel, 5, 3);
    sceneGrid.add(buttonController.bHelpfulSell, 5, 5);
    sceneGrid.add(fakeLabel3, 6, 5);
    sceneGrid.add(buttonController.bHalflingSell, 7, 3);
    sceneGrid.add(buttonController.bSellTreasure, 7, 5);
    sceneGrid.add(separator, 1,10,8,1);
    sceneGrid.add(cardsHbox, 1, 12, 8, 1);
    sceneGrid.add(actionLabel, 1, 15, 8, 1);
  } 
  private void initLayoutElementsForScene() 
  {
    sceneGrid = new GridPane();
    cardsHbox = new HBox(10, characterInfo, card1, card2, card3, card4, card5); //Puts all the cards in one hbox
    sceneHbox = new HBox(board, sceneGrid); //Puts the board and the rest of the buttons(except bDoorDeck) in an hbox
    scenePane = new Pane(sceneHbox, buttonController.bDoorDeck); //Made a pane so I can put the door deck button wherever I want
  }
  private void initUIElementsForScene() 
  {
    
    
    //Creating and styling buttons
          
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
          
      board = new ImageView();
      board.setId("munchkinBoard");
    }
  private void setTextForPlayerCards(int numOfPlayerCards) 
  {
    ArrayList<ToggleButton> cards = new ArrayList<ToggleButton>();
    for(int i = 0; i < numOfPlayerCards; i++)
    {
      cards.add((ToggleButton)cardGroup.getToggles().get(i));
    }
    
    cards.forEach(card -> {
      card.setText("TBD");
//      // always set name to this
//      card3.setText(((DoorDeck) playerHand.get(2)).getName() + " Card");
//      // if Monster
//      card3.setText("Monster\n" + ((DoorDeck) playerHand.get(2)).getName() + "\nLevel: " + ((Monster) playerHand.get(2)).getLevel() + "\nVulnerability: " + "\nTreasure: " + ((Monster) playerHand.get(2)).getGood());
//      // if Helpful
//      card3.setText("Helpful Card\n" + ((DoorDeck) playerHand.get(2)).getName() );
//      // if Treasure
//      // needs to be written
    });
  }
    
  private void initMonsterScene(int numOfPlayerCards) 
  {
    
  // game Things
  // --
    Boolean Draw1st = false; //This is the monster encounter not the first draw
    
  // java-fx things
  // --
    //Creates new instances of the objects
    //Setting up the layout for Scene 2
    
    sceneGrid = new GridPane();
    buttonController.bMonsterEncounter.setTranslateX(75);
    buttonController.bMonsterEncounter.setTranslateY(200);
    sceneGrid.setHgap(10);
    sceneGrid.setVgap(10);
    sceneGrid.add(monsterActionLabel, 1, 0, 3, 1);
    sceneGrid.add(abilityLabel, 4, 0, 4, 1);
    sceneGrid.add(buttonController.bRules, 8, 0);
    sceneGrid.add(fakeLabel5, 1, 2);
    sceneGrid.add(buttonController.bTreasureBonus, 2, 2);
    sceneGrid.add(buttonController.bTurning, 4, 1, 1, 2);
    sceneGrid.add(buttonController.bFlight, 4, 3, 1, 2);
    sceneGrid.add(fakeLabel4, 5, 1);
    sceneGrid.add(buttonController.bBerserking, 6, 1, 2, 2);
    sceneGrid.add(buttonController.bCharm, 6, 3, 2, 2);
    sceneGrid.add(separator, 1,9,8,1);
  
      
    switch(numOfPlayerCards)
    {
      case 0:
        cardsHbox = new HBox(10, characterMonsterInfo);
      case 1:
        cardsHbox = new HBox(10, characterMonsterInfo, card1);
      case 2:
        cardsHbox = new HBox(10, characterMonsterInfo, card1, card2);
      case 3:
        cardsHbox = new HBox(10, characterMonsterInfo, card1, card2, card3);
      case 4:
        cardsHbox = new HBox(10, characterMonsterInfo, card1, card2, card3, card4);
      case 5:
        cardsHbox = new HBox(10, characterMonsterInfo, card1, card2, card3, card4, card5);
      default: 
        cardsHbox = new HBox(10, characterMonsterInfo, card1, card2, card3, card4, card5, card6);
    }
    
      sceneGrid.add(cardsHbox, 1, 12, 8, 1);
      sceneGrid.add(actionLabel, 1, 14, 8, 1);
      sceneHbox = new HBox(board, sceneGrid); //Puts the board and the rest of the buttons(except bDoorDeck) in an hbox
      scenePane = new Pane(sceneHbox, buttonController.bMonsterEncounter); //Made a pane so I can put the door deck button wherever I want
      //TODO maybe use this here      currentScene = new Scene(scenePane, 1400, 700);
      
//      setCardText(); //Sets the text of a card on a button associated with that card
      setTextForPlayerCards(numOfPlayerCards);
      
      
      //Disabling all buttons at the beginning of scene
      buttonController.displayButtonsFor("monster");
      
//      buttonController.bMonsterEncounter.setText("Monster \n" + ((DoorDeck) monsterCard).getName() + "\nLevel: " + monsterCard.getLevel() + "\nVulnerability: " + "\nTreasure: " + monsterCard.getGood());
//            
//      //Enables the class abilities if the player is that class
//      if(character.getplayerClass() == "Cleric")
//      {
//        if(cleric.isActive() == false) //Does not enable if turning has already been used
//        { 
//          buttonController.bTurning.setDisable(false);
//        } 
//      }
//      else if(character.getplayerClass() == "Warrior")
//      {
//        if(warrior.isActive() == false) //Does not enable if berserking has already been used
//        { 
//          buttonController.bBerserking.setDisable(false);
//        } 
//      }
//      else if(character.getplayerClass() == "Wizard")
//      {
//        if(charmUsed == false)
//        {
//          buttonController.bCharm.setDisable(false); //Does not enable if charm has already been used
//        }
//        if(flightUsed == false)
//        {
//          buttonController.bFlight.setDisable(false); //Does not enable if flight has already been used
//        }
//      }
//      
//      //ToggleButton Actions for scene 2
//      cardsSelected = 0; //There are automatically no cards selected
//      card1.setOnAction(e-> 
//      {
//        if(card1.isSelected())
//        {
//          cardChoice = 0; //Card is equal to playerhand.get(0). Card 1.
//        }
//        else
//        {
//          cardChoice = -1;
//        }
//            
//        //Grays out or ungrays out the proper buttons
//        EnableButtons(cardChoice, playerHand);
//      });
//              
//      card2.setOnAction(e-> 
//      {
//        if(card2.isSelected())
//        {
//          cardChoice = 1; //Card is equal to playerhand.get(1). Card 2
//        }
//        else
//        {
//          cardChoice = -1;
//        }
//              
//        //Grays out or ungrays out the proper buttons
//        EnableButtons(cardChoice, playerHand);
//      });
//              
//      card3.setOnAction(e-> 
//      {
//        if(card3.isSelected())
//        {
//          cardChoice = 2; //Card is equal to playerhand.get(2). Card 3
//        }
//        else
//        {
//          cardChoice = -1;
//        }
//              
//        //Grays out or ungrays out the proper buttons
//        EnableButtons(cardChoice, playerHand);
//      });
//              
//      card4.setOnAction(e-> 
//      {
//        if(card4.isSelected())
//        {
//          cardChoice = 3; //Card is equal to playerhand.get(3). Card 4,   
//        }
//        else
//        {
//          cardChoice = -1;
//        }
//              
//        //Grays out or ungrays out the proper buttons
//        EnableButtons(cardChoice, playerHand);
//      });
//      
//      card5.setOnAction(e-> 
//      {
//        if(card5.isSelected())
//        {
//          cardChoice = 4; //Card is equal to playerhand.get(4). Card 5,   
//        }
//        else
//        {
//          cardChoice = -1;
//        }
//              
//        //Grays out or ungrays out the proper buttons
//        EnableButtons(cardChoice, playerHand);
//      });
//      
//      card6.setOnAction(e-> 
//      {
//        if(card6.isSelected())
//        {
//          cardChoice = 5; //Card is equal to playerhand.get(3). Card 4,   
//        }
//        else
//        {
//          cardChoice = -1;
//        }
//              
//        //Grays out or ungrays out the proper buttons
//        EnableButtons(cardChoice, playerHand);
//      });
//      
//      //Button actions for Scene 1
//      buttonController.bRules.setOnAction(e-> Rules());
//      buttonController.bTreasureBonus.setOnAction(e-> playerHandHelper.useTreasure(character, playerHand, cardChoice));
//      buttonController.bTurning.setOnAction(e-> 
//      {
//        cleric.turning(character, playerHand);
//        abilityScene(pPrimaryStage);
//      });
//      
//      buttonController.bBerserking.setOnAction(e-> 
//      {
//        warrior.berserking(character, playerHand);
//        abilityScene(pPrimaryStage);
//        
//      });
//      
//      buttonController.bFlight.setOnAction(e-> 
//      {
//        wizard.flight(character, playerHand);
//        flightUsed = true;
//        abilityScene(pPrimaryStage);
//      });
//      
//      buttonController.bCharm.setOnAction(e-> 
//      {
//        wizard.charm(character, playerHand);
//        charmUsed = true;
//        abilityScene(pPrimaryStage);
//        
//      });
//      buttonController.bMonsterEncounter.setOnAction(e-> 
//      {
//        characterHelper.combat(character, playerHand, monsterHelper);
//        startScene(pPrimaryStage);
//      });
    } 
  }
