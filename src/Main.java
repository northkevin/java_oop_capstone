import java.util.ArrayList;
import java.util.Collections;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application
{
	
	private boolean Exit = false;
	private int doorDeckNum = 0;
	private ArrayList doorCards;
	private ArrayList playerHand;
	private PlayerHandHelper playerHandHelper;
	private Helpful helpful;
	private Character character;
	private CharacterHelper characterHelper;
	private Monster monster;
	private Classes cClass;
	private Curse curse;
	
	private Button bRules, bChangeRace, bChangeClass, bSeeHand, bHelpfulLevelUp, bFight, bBuyLevel;
	private Button bSellTreasure, bHelpfulTreasure, bDrawCards, bClassAbility, bTreasureBonus, bExit;
	private int fightBonus;
	private int runBonus;
	private Stage stage1, stage2, stage3;
	private BorderPane pane1, pane2, pane3;
	private Scene stage1Scene1, stage1Scene2, stage1Scene3;
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage)
	{
		
		
		//Initializing all the Class objects
		character = new Character();
		doorCards = new ArrayList();
		playerHand = new ArrayList();
		playerHandHelper = new PlayerHandHelper();
		characterHelper = new CharacterHelper();
		monster = new Monster();
		helpful = new Helpful();
		cClass = new Classes();
		character = new Character();
		curse = new Curse();
		System.out.println ("before cards creation");
		
		while(doorCards.size() < 100) doorCards.add(0); //initializes the door deck
		
		while(playerHand.size() < 4) playerHand.add(0); //initializes the player hand
		
		//Creating the doorCard arrayList
		for(int i = 0; i < 30; i++) 
		{	
			doorCards.add(new Monster());

		}
			
		for(int i = 0; i < 30; i++) 
		{	
			doorCards.add(new Curse());
		}
		
		for(int i = 0; i < 10; i++) 
		{	
			doorCards.add(new Helpful());
		}
		
		for(int i = 0; i < 15; i++) 
		{	
			doorCards.add(new Races());
		}
		
		for(int i = 0; i < 15; i++) 
		{	
			doorCards.add(new Classes());
		}
		System.out.println("before adding to the doorcard - done");
		
		Collections.shuffle(doorCards); //Shuffles all the cards that were added to the array list
		doorDeckNum = 99; //Says there are 100 cards in the door deck
		//End of doorcard arraylist creation
		
		for(int i = 0; i < 5; i++) //Gives the player 5 cards to start
		{
			playerHand.add(doorCards.get(doorDeckNum)); //adds cards to players hand
			doorCards.remove(doorDeckNum); //removes the cards from the door deck
			doorDeckNum--; //deincrements the number of cards in the door deck
			
		}
		
		System.out.println("before adding to the doorcard - after dealing");
		
		//Creating Buttons
		bRules = new Button("Rules");
		bChangeRace = new Button("Change Race"); 
		/* = new Button("Change Class");
		bSeeHand = new Button("See Hand");
		bTreasureBonus = new Button("Use a Treasure Card to Gain a Fight Bonus");
		bHelpfulTreasure = new Button("Use a Helpful Card to Sell Treasure for Twice its Value");
		bHelpfulLevelUp = new Button("Use a Helpful Card to Level Up");
		bDrawCards = new Button("Draw Cards");
		bFight = new Button("Fight!");
		bBuyLevel = new Button("Pay 1000 Gold to Level Up");
	*/	bExit = new Button("Exit");
	
		VBox mainSceneLayout = new VBox(500);
		mainSceneLayout.setAlignment(Pos.CENTER);
		mainSceneLayout.getChildren().addAll(bRules, bChangeRace,bExit );
		stage1Scene1 = new Scene(mainSceneLayout, 300, 250);
		
		primaryStage.setScene(stage1Scene1);
		primaryStage.show();
        Exit = false;
		//Display Stage 3 Scene 23
//		do
		{
			//Kick down the door phase
			//*Pseudo: Put buttons on scene 1 and show scene 1*
			//*Pseudo: Make some labels for player level, race, class, and gold*
			primaryStage.setTitle("Kick Down the Door!"); 
			//playerHandHelper.drawDoor(doorCards); //Player draws from the door deck
		
			//Stage 1 Scene 1 button actions
			bRules.setOnAction(e -> Rules()); //Brings up the rules in a new stage
			bChangeRace.setOnAction(e -> characterHelper.changeRace(character, playerHand));
		//	bChangeClass.setOnAction(e -> characterHelper.changeClass(character, playerHand));
	//		bSeeHand.setOnAction( e -> playerHandHelper.displayHand(playerHand));
	//		bHelpfulLevelUp.setOnAction( e -> helpful.helpLevelUp(playerHand, character));
		//	bHelpfulTreasure.setOnAction(e -> helpful.sellDoubleVal(playerHand, character));
		//	bSellTreasure.setOnAction(e -> playerHandHelper.sellTreasure(character, playerHand));

			/*	bDrawCards.setOnAction( e-> 
			{
				playerHandHelper.drawDoor(doorCards);
				//Display Stage 3 Scene 22
				
			}); */
			bExit.setOnAction( e -> Exit = true);
			
	/*		if(doorCards.get(doorDeckNum) instanceof Monster)
			{	
				//*Pseudo: Put buttons on scene 2 and show scene 2*
				//*Pseudo: Display Stage 3 Scene 1*
				//*Pseudo: Make some labels for player level, race, class, and gold*
				//Stage 1 Scene 2 button actions
				bRules.setOnAction(e -> Rules());
				bSeeHand.setOnAction( e -> playerHandHelper.displayHand(playerHand));
				bClassAbility.setOnAction( e-> 
				{
					//*Pseudo: Checks what class the user is **Don't really know what to put here**
				});
				bTreasureBonus.setOnAction( e-> playerHandHelper.useTreasure(character, playerHand));
				bFight.setOnAction( e-> characterHelper.combat(fightBonus, character, monster));
				bExit.setOnAction( e -> Exit = true);
			}	
			else
			{
				//*Pseudo: put buttons on scene 3 and show scene 3*
				//*Pseudo: Make some labels for player level, race, class, and gold*
				//Stage 1 Scene 3 button actions
				bRules.setOnAction(e -> Rules()); //Brings up the rules in a new stage
				bChangeRace.setOnAction(e -> characterHelper.changeRace(character, playerHand));
				bChangeClass.setOnAction(e -> characterHelper.changeClass(character, playerHand));
				bSeeHand.setOnAction( e -> playerHandHelper.displayHand(playerHand));
				bBuyLevel.setOnAction(e -> characterHelper.buyLevel(character));
				bDrawCards.setOnAction( e-> playerHandHelper.drawDoor(doorCards));
				bExit.setOnAction( e -> Exit = true);
			}*/
		}
	//	while(Exit!= true);
	}
	
	public void Rules() //*Pseudo: Stage 2 Scene 1*
	{
		//*Pseudo: Whole bunch of System.out.printlns*
		
	}
}