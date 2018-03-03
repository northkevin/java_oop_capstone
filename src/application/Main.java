package application;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Toggle;
import javafx.stage.Stage;
import model.Deck;
import model.Player;


public class Main extends Application {
  
  Deck doorCards;
  Player player;
  private Stage primaryStage;
  private Scene primaryScene;
  Game game;
  SceneController sceneController;
  
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
    // Organizing game things in game class
    game = new Game();
    
    
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
    
    
    //Setting up the layout
    sceneController = new SceneController();
    primaryScene = new Scene(sceneController.scenePane, 1400, 700);
    primaryScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    //TODO change SceneController to return a scene object.. instad of whats happening right now
    
    primaryStage.setScene(primaryScene);
    primaryStage.setTitle("Munchkin First Draw");
    primaryStage.show();
    
    //Disabling all buttons at the beginning
    ButtonController.displayButtonsNone(null);
    ButtonController.checkDispayHalflingButton();
    
    sceneController.cardGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
      @Override
      public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue)
      {
        //TODO  refactor this out of Main.java to take directions from some kind of controller class that decides how buttons are displayed based on player state.
        
        // if togglebutton is selected, get the button selected
        if(sceneController.cardGroup.getSelectedToggle() != null)
        {
          // need to identify the toggle buttons with a card number.. enum goes somewhere.. to tired.
          //TODO make this work lol
          ButtonController.displayButtonsFor(sceneController.cardGroup.getSelectedToggle());
        }
        else
        {
          ButtonController.displayButtonsNone(null);
        }
        
      }
    });
  }
      
  
}
