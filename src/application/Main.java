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
    //Moved booleans into class 'Game' to track state of the game.
    game = new Game();
    
    //Setting up the layout
    initBoard();
    ButtonController buttonController = new ButtonController();
    
    //Setting up the layout for Scene1
    //TODO move margin translate numbers into CSS
    buttonController.bDoorDeck.setTranslateX(19);
    buttonController.bDoorDeck.setTranslateY(497);
    sceneGrid = new GridPane();
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
    cardsHbox = new HBox(10, characterInfo, card1, card2, card3, card4, card5); //Puts all the cards in one hbox
    sceneGrid.add(cardsHbox, 1, 12, 8, 1);
    sceneGrid.add(actionLabel, 1, 15, 8, 1);
    scene1Hbox = new HBox(board, sceneGrid); //Puts the board and the rest of the buttons(except bDoorDeck) in an hbox
    scenePane = new Pane(scene1Hbox, buttonController.bDoorDeck); //Made a pane so I can put the door deck button wherever I want
    primaryScene = new Scene(scenePane, 1400, 700);
    primaryScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    primaryStage.setScene(primaryScene);
    primaryStage.setTitle("Munchkin First Draw");
    primaryStage.show();
    
    //Disabling all buttons at the beginning
    ButtonController.displayButtonsNone(null);
    ButtonController.checkDispayHalflingButton();
    
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
          ButtonController.displayButtonsFor(cardGroup.getSelectedToggle());
        }
        else
        {
          ButtonController.displayButtonsNone(null);
        }
        
      }
    });
  }
      
  private void initBoard() {
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
        
    board = new ImageView(iBoard);
    board.setId("munchkinBoard");
  }
}
