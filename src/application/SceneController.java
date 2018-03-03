package application;

import java.io.FileInputStream;

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
  
  private void initScene() {
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
  
  private void initLayoutElementsForScene() {
    sceneGrid = new GridPane();
    cardsHbox = new HBox(10, characterInfo, card1, card2, card3, card4, card5); //Puts all the cards in one hbox
    sceneHbox = new HBox(board, sceneGrid); //Puts the board and the rest of the buttons(except bDoorDeck) in an hbox
    scenePane = new Pane(sceneHbox, buttonController.bDoorDeck); //Made a pane so I can put the door deck button wherever I want
  }
  
  private void initUIElementsForScene() {
    
    
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
}
