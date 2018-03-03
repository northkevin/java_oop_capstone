
	
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;


public class Main extends Application {
	
	//Buttons
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
	private ToggleButton card8; //When the player first starts the game
	
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
	
	//Scenes
	private Scene scene1Draw1;
	private Scene scene2Monster;
	private Scene scene3Draw2;
	private Scene scene4DiscardAbility;
	private Scene scene5Discard;
	
	//Lines
	private Line separator;
	
	//Making the GridPanes
	private GridPane scene1Grid;
	private GridPane scene2Grid;
	private GridPane scene3Grid;
	private GridPane scene4Grid;
	private GridPane scene5Grid;
	
	//Making Hboxes
	private HBox scene1Hbox, cardsHbox, scene3Hbox, scene2Hbox, scene4Hbox, scene5Hbox;
	
	//Making a Pane
	private Pane scene1Pane;
	private Pane scene3Pane;
	private Pane scene2Pane;
	
	//Making another stage
	private Stage secondaryStage = new Stage();
	
	
	//Instantiating all the class objects
	private CharacterHelper characterHelper;
	private Character character;
	private PlayerHandHelper playerHandHelper;
	private Halfling halfling;
	private Cleric cleric;
	private Warrior warrior;
	private Wizard wizard;
	private Helpful helpful;
	private MonsterHelper monsterHelper;
	private Curse curse;
	
	//Attributes
	private int doorDeckNum = 0; //Keeps track of how many cards are in the door deck
	private ArrayList doorCards, playerHand;
	private int cardChoice = -1; //Associates the card number with the the toggle button clicked. -1 is not an index of an arraylist
	private boolean Draw1st = false; //Keeps track if it is the first draw or second draw
	private int cardsSelected = 0; //Keeps track of how many cards are selected in Scene 4
	private boolean card1Selected = false; //Keeps track of if card 1 is selected in Scenes 4 and 5
	private boolean card2Selected = false; //Keeps track of if card 2 is selected in Scenes 4 and 5
	private boolean card3Selected = false; //Keeps track of if card 3 is selected in Scenes 4 and 5
	private boolean card4Selected = false; //Keeps track of if card 4 is selected in Scenes 4 and 5
	private boolean card5Selected = false; //Keeps track of if card 5 is selected in Scenes 4 and 5
	private boolean card6Selected = false; //Keeps track of if card 6 is selected in Scenes 4 and 5
	private boolean card7Selected = false; //Keeps track of if card 7 is selected in Scenes 4 and 5
	private boolean card8Selected = false; //Keeps track of if card 8 is selected in Scenes 4 and 5
	
	private int maxCards = 5; //Keeps track of how many cards the player can have. 5 normally, 6 for dwarves
	private boolean turningUsed, berserkingUsed, charmUsed, flightUsed = false; //Keeps track of if the player has used their class ability or not
	private boolean monsterDrawn = false; //Sees if a monster has been drawn 
	
	@Override
	public void start(Stage primaryStage) 
	{
		
		doorCards = new ArrayList();
		doorCards = createDoorDeck(); //First thing the program does is make the door deck
		playerHand = dealPlayerHand(doorCards); //Second thing the program does is deal the player 8 cards
		
		//Create all class objects
		characterHelper = new CharacterHelper();
		character = new Character();
		playerHandHelper = new PlayerHandHelper();
		halfling = new Halfling();
		cleric = new Cleric();
		warrior = new Warrior();
		wizard = new Wizard();
		helpful = new Helpful();
		monsterHelper = new MonsterHelper();
		curse = new Curse();
		
		//startScene(primaryStage);
		
	}
	
	
	public void startScene(Stage pPrimaryStage)
	{
		monsterDrawn = false;
		
		//Since it is not a monster encounter no class abilities have been used so they will be set to false
		turningUsed = false;
		berserkingUsed = false;
		flightUsed = false;
		charmUsed = false;
		
		//No cards are selected by default in every scene
		cardsSelected = 0;
		card1Selected = false;
		card2Selected = false;
		card3Selected = false;
		card4Selected = false;
		card5Selected = false;
		card6Selected = false;
		card7Selected = false;
		card8Selected = false;
		
		if(character.getRace() == "Dwarf") //Checks if player is a dwarf. If yes then sets their max cards to 6
		{
			maxCards = 6;
		}
		else
		{	
			maxCards = 5; //Will set it back to 5 if they stop being a dwarf
		}
		
		//Setting up the layout
		setStyles();
		
		//Setting up the layout for Scene1
		bDoorDeck.setTranslateX(19);
		bDoorDeck.setTranslateY(497);
		scene1Grid = new GridPane();
		scene1Grid.setHgap(10);
		scene1Grid.setVgap(10);
		scene1Grid.add(instructionLabel, 1, 0, 7, 1);
		scene1Grid.add(bRules, 8, 0);
		scene1Grid.add(fakeLabel, 2, 3);
		scene1Grid.add(bChangeRace, 3, 3);
		scene1Grid.add(bChangeClass, 3, 5);
		scene1Grid.add(fakeLabel2, 4, 3);
		scene1Grid.add(bHelpfulLevel, 5, 3);
		scene1Grid.add(bHelpfulSell, 5, 5);
		scene1Grid.add(fakeLabel3, 6, 5);
		scene1Grid.add(bHalflingSell, 7, 3);
		scene1Grid.add(bSellTreasure, 7, 5);
		scene1Grid.add(separator, 1,10,8,1);
		

		
		//Adds cards to the scene according to how many the player has
		if(playerHand.size() == 0)
		{
			cardsHbox = new HBox();
		}
		else if(playerHand.size() == 1)
		{
			cardsHbox = new HBox(10, characterInfo, card1);
		}
		else if(playerHand.size() == 2)
		{
			cardsHbox = new HBox(10, characterInfo, card1, card2);
		}
		else if(playerHand.size() == 3)
		{
			cardsHbox = new HBox(10, characterInfo, card1, card2, card3);
		}
		else if(playerHand.size() == 4)
		{
			cardsHbox = new HBox(10, characterInfo, card1, card2, card3, card4);
		}
		else if(playerHand.size() == 5)
		{	
			cardsHbox = new HBox(10, characterInfo, card1, card2, card3, card4, card5); //Puts all the cards in one hbox
		}
		else if(playerHand.size() == 6)
		{
			cardsHbox = new HBox(10, characterInfo, card1, card2, card3, card4, card5, card6); //Puts all the cards in one hbox
		}
		else //When the game starts the player starts with 8 cards
		{
			cardsHbox = new HBox(10, characterInfo, card1, card2, card3, card4, card5, card6, card7, card8); //Puts all the cards in one hbox
		}
		
		scene1Grid.add(cardsHbox, 1, 12, 8, 1);
		scene1Grid.add(actionLabel, 1, 15, 8, 1);
		scene1Hbox = new HBox(board, scene1Grid); //Puts the board and the rest of the buttons(except bDoorDeck) in an hbox
		scene1Pane = new Pane(scene1Hbox, bDoorDeck); //Made a pane so I can put the door deck button wherever I want
		
		//Sets the size of the scene according to how many cards the player has
		if(playerHand.size() < 6)
		{
			scene1Draw1 = new Scene(scene1Pane, 1400, 700);
		}
		else //When the player starts the game they start with 8 cards
		{
			scene1Draw1 = new Scene(scene1Pane, 1600, 700);
		}
		
		pPrimaryStage.setScene(scene1Draw1);
		pPrimaryStage.setTitle("Munchkin First Draw");
		pPrimaryStage.show();
		
		//Disabling all buttons at the beginning
		bChangeRace.setDisable(true);
		bChangeClass.setDisable(true);
		bHalflingSell.setDisable(true);
		bSellTreasure.setDisable(true);
		bHelpfulLevel.setDisable(true);
		bHelpfulSell.setDisable(true);
					
		//Enables the halfing race ability if the player is a halfling
		if(character.getRace() == "Halfling")
		{
			bHalflingSell.setDisable(false);
		}
			
		//ToggleButton Actions for Scene 1
		cardsSelected = 0; //There are automatically no cards selected
		card1.setOnAction(e-> 
		{
			if(card1.isSelected())
			{
				cardChoice = 0; //Card is equal to playerhand.get(0). Card 1.
			}
			else
			{
				cardChoice = -1;
			}
			//Grays out or ungrays out the proper buttons
			EnableButtons(cardChoice, playerHand);
		});
						
		card2.setOnAction(e-> 
		{
			if(card2.isSelected())
			{
				cardChoice = 1; //Card is equal to playerhand.get(1). Card 2
			}
			else
			{
				cardChoice = -1;
			}
				
			//Grays out or ungrays out the proper buttons
			EnableButtons(cardChoice, playerHand);
		});
				
		card3.setOnAction(e-> 
		{
			if(card3.isSelected())
			{
				cardChoice = 2; //Card is equal to playerhand.get(2). Card 3
			}
			else
			{
				cardChoice = -1;
			}
				
			//Grays out or ungrays out the proper buttons
			EnableButtons(cardChoice, playerHand);
		});
				
		card4.setOnAction(e-> 
		{
			if(card4.isSelected())
			{
				cardChoice = 3; //Card is equal to playerhand.get(3). Card 4,		
			}
			else
			{
				cardChoice = -1;
			}
				
			//Grays out or ungrays out the proper buttons
			EnableButtons(cardChoice, playerHand);
		});
				
		card5.setOnAction(e-> 
		{
			if(card5.isSelected())
			{
				cardChoice = 4; //Card is equal to playerhand.get(4);. Card 5
			}
			else 
			{
				cardChoice = -1;
			}
				
			//Grays out or ungrays out the proper buttons
			EnableButtons(cardChoice, playerHand);
		});
		
		card6.setOnAction(e-> 
		{
			if(card6.isSelected())
			{
				cardChoice = 5; //Card is equal to playerhand.get(5); Card 6
			}
			else 
			{
				cardChoice = -1;
			}
				
			//Grays out or ungrays out the proper buttons
			EnableButtons(cardChoice, playerHand);
		});
		
		card7.setOnAction(e-> 
		{
			if(card5.isSelected())
			{
				cardChoice = 6; //Card is equal to playerhand.get(6);. Card 7
			}
			else 
			{
				cardChoice = -1;
			}
				
			//Grays out or ungrays out the proper buttons
			EnableButtons(cardChoice, playerHand);
		});
	
		card8.setOnAction(e-> 
		{
			if(card8.isSelected())
			{
				cardChoice = 7; //Card is equal to playerhand.get(7);. Card 8
			}
			else 
			{
				cardChoice = -1;
			}
				
			//Grays out or ungrays out the proper buttons
			EnableButtons(cardChoice, playerHand);
		});
		
		//Button actions for Scene 1
		bRules.setOnAction(e-> Rules());
		bChangeRace.setOnAction(e-> characterHelper.changeRace(character, playerHand, cardChoice));
		bChangeClass.setOnAction(e-> characterHelper.changeClass(character, playerHand, cardChoice));
		bHelpfulLevel.setOnAction(e-> helpful.helpLevelUp(character, playerHand, cardChoice));
		bHelpfulSell.setOnAction(e-> helpful.sellDoubleVal(character, playerHand, cardChoice));
		bHalflingSell.setOnAction(e-> halfling.sellDouble(bHalflingSell, playerHand, character, cardChoice));
		bSellTreasure.setOnAction(e-> playerHandHelper.sellTreasure(character, playerHand, cardChoice));
		bDoorDeck.setOnAction(e->
		{
			playerHandHelper.drawDoor(doorCards, playerHand);
			Draw1st = true;
			
			//Makes sure the player doesn't go over their card limit
			if(playerHand.get(playerHand.size()-1) instanceof Monster)
			{
				monsterDrawn = true;
			}
			else
			{
				monsterDrawn = false;
			}
			
			if(playerHand.size() > maxCards)
			{
				discardScene(pPrimaryStage);
			}
			else
			{
				switchScene(pPrimaryStage);
			}
			
		});
	
	}

	//Sets the stage to either a monster encounter or to their second draw depending on if a monster was drawn in scene 1 or not
	public void switchScene(Stage pPrimaryStage)
	{
		
		//Setting up the layout
		setStyles();
				
		//No cards are selected by default in every scene
		cardsSelected = 0;
		card1Selected = false;
		card2Selected = false;
		card3Selected = false;
		card4Selected = false;
		card5Selected = false;
		card6Selected = false;
		card7Selected = false;
		card8Selected = false;
		
		//Setting up the layout
				
		if(character.getRace() == "Dwarf") //Checks if player is a dwarf. If yes then sets their max cards to 6
		{
			maxCards = 6;
		}
		else
		{
			maxCards = 5; //Will set it back to 5 if they stop being a dwarf
		}
		
		//If the last drawn card is a monster, the player has drawn a monster. -1 since arraylists start at 0
		
		//Goes to scene 2 if the last card drawn is a monster.
		if(monsterDrawn == true)
		{
			//Setting up the layout
			setStyles();
			
			Draw1st = false; //This is the monster encounter not the first draw
			
			//Creates new instances of the objects
			//Setting up the layout for Scene 2
			scene2Grid = new GridPane();
			bMonsterEncounter.setTranslateX(75);
			bMonsterEncounter.setTranslateY(200);
			scene2Grid.setHgap(10);
			scene2Grid.setVgap(10);
			scene2Grid.add(monsterActionLabel, 1, 0, 3, 1);
			scene2Grid.add(abilityLabel, 4, 0, 4, 1);
			scene2Grid.add(bRules, 8, 0);
			scene2Grid.add(fakeLabel5, 1, 2);
			scene2Grid.add(bTreasureBonus, 2, 2);
			scene2Grid.add(bTurning, 4, 1, 1, 2);
			scene2Grid.add(bFlight, 4, 3, 1, 2);
			scene2Grid.add(fakeLabel4, 5, 1);
			scene2Grid.add(bBerserking, 6, 1, 2, 2);
			scene2Grid.add(bCharm, 6, 3, 2, 2);
			scene2Grid.add(separator, 1,9,8,1);
			
			//Puts however many cards the player is holding into an hbox
			if(playerHand.size() == 0)
			{
				cardsHbox = new HBox(10, characterInfo);
			}
			else if(playerHand.size() == 1)
			{
				cardsHbox = new HBox(10, characterInfo, card1);
			}
			else if(playerHand.size() == 2)
			{
				cardsHbox = new HBox(10, characterInfo, card1, card2);
			}
			else if(playerHand.size() == 3)
			{
				cardsHbox = new HBox(10, characterInfo, card1, card2, card3);
			}
			else if(playerHand.size() == 4)
			{
				cardsHbox = new HBox(10, characterInfo, card1, card2, card3, card4);
			}
			else if(playerHand.size() == 5)
			{	
				cardsHbox = new HBox(10, characterInfo, card1, card2, card3, card4, card5); //Puts all the cards in one hbox
			}
			else
			{
				cardsHbox = new HBox(10, characterInfo, card1, card2, card3, card4, card5, card6); //Puts all the cards in one hbox
			}
			
			scene2Grid.add(cardsHbox, 1, 12, 8, 1);
			scene2Grid.add(actionLabel, 1, 14, 8, 1);
			scene2Hbox = new HBox(board, scene2Grid); //Puts the board and the rest of the buttons(except bDoorDeck) in an hbox
			scene2Pane = new Pane(scene2Hbox, bMonsterEncounter); //Made a pane so I can put the door deck button wherever I want
			scene2Monster = new Scene(scene2Pane, 1400, 700);
			
			//Disabling all buttons at the beginning of scene
			bTreasureBonus.setDisable(true);
			bTurning.setDisable(true);
			bFlight.setDisable(true);
			bBerserking.setDisable(true);
			bCharm.setDisable(true);;
			
						
			//Enables the class abilities if the player is that class
			if(character.getplayerClass() == "Cleric")
			{
				if(turningUsed == false) //Does not enable if turning has already been used
				{	
					bTurning.setDisable(false);
				}	
			}
			else if(character.getplayerClass() == "Warrior")
			{
				if(berserkingUsed == false) //Does not enable if berserking has already been used
				{	
					bBerserking.setDisable(false);
				}	
			}
			else if(character.getplayerClass() == "Wizard")
			{
				if(charmUsed == false)
				{
					bCharm.setDisable(false); //Does not enable if charm has already been used
				}
				if(flightUsed == false)
				{
					bFlight.setDisable(false); //Does not enable if flight has already been used
				}
			}
			
			//ToggleButton Actions for scene 2
			cardsSelected = 0; //There are automatically no cards selected
			card1.setOnAction(e-> 
			{
				if(card1.isSelected())
				{
					cardChoice = 0; //Card is equal to playerhand.get(0). Card 1.
				}
				else
				{
					cardChoice = -1;
				}
						
				//Grays out or ungrays out the proper buttons
				EnableButtons(cardChoice, playerHand);
			});
							
			card2.setOnAction(e-> 
			{
				if(card2.isSelected())
				{
					cardChoice = 1; //Card is equal to playerhand.get(1). Card 2
				}
				else
				{
					cardChoice = -1;
				}
							
				//Grays out or ungrays out the proper buttons
				EnableButtons(cardChoice, playerHand);
			});
							
			card3.setOnAction(e-> 
			{
				if(card3.isSelected())
				{
					cardChoice = 2; //Card is equal to playerhand.get(2). Card 3
				}
				else
				{
					cardChoice = -1;
				}
							
				//Grays out or ungrays out the proper buttons
				EnableButtons(cardChoice, playerHand);
			});
							
			card4.setOnAction(e-> 
			{
				if(card4.isSelected())
				{
					cardChoice = 3; //Card is equal to playerhand.get(3). Card 4,		
				}
				else
				{
					cardChoice = -1;
				}
							
				//Grays out or ungrays out the proper buttons
				EnableButtons(cardChoice, playerHand);
			});
			
			card5.setOnAction(e-> 
			{
				if(card5.isSelected())
				{
					cardChoice = 4; //Card is equal to playerhand.get(4). Card 5,		
				}
				else
				{
					cardChoice = -1;
				}
							
				//Grays out or ungrays out the proper buttons
				EnableButtons(cardChoice, playerHand);
			});
			
			card6.setOnAction(e-> 
			{
				if(card6.isSelected())
				{
					cardChoice = 5; //Card is equal to playerhand.get(3). Card 4,		
				}
				else
				{
					cardChoice = -1;
				}
							
				//Grays out or ungrays out the proper buttons
				EnableButtons(cardChoice, playerHand);
			});
			
			//Button actions for Scene 1
			bRules.setOnAction(e-> Rules());
			bTreasureBonus.setOnAction(e-> playerHandHelper.useTreasure(character, playerHand, cardChoice));
			bTurning.setOnAction(e-> 
			{
				cleric.turning(character, playerHand);
				turningUsed = true; //Sets the ability to disabled after the character has used it
				abilityScene(pPrimaryStage);
			});
			
			bBerserking.setOnAction(e-> 
			{
				warrior.berserking(character, playerHand);
				berserkingUsed = true;
				abilityScene(pPrimaryStage);
				
			});
			
			bFlight.setOnAction(e-> 
			{
				wizard.flight(character, playerHand);
				flightUsed = true;
				abilityScene(pPrimaryStage);
			});
			
			bCharm.setOnAction(e-> 
			{
				wizard.charm(character, playerHand);
				charmUsed = true;
				abilityScene(pPrimaryStage);
				
			});
			bMonsterEncounter.setOnAction(e-> 
			{
				characterHelper.combat(character, playerHand, monsterHelper);
				startScene(pPrimaryStage);
			});
					
			pPrimaryStage.setScene(scene2Monster);
			pPrimaryStage.setTitle("Monster Encounter");
			pPrimaryStage.show();	
		}
		//The last card drawn is not a monster card so the player gets to draw again!
		else
		{
			
			setStyles();
			Draw1st = false; //It is the second draw
			
			bDoorDeck.setTranslateX(19);
			bDoorDeck.setTranslateY(497);
			scene3Grid = new GridPane();
			scene3Grid.setHgap(10);
			scene3Grid.setVgap(10);
			scene3Grid.add(instructionLabel, 1, 0, 7, 1);
			scene3Grid.add(bRules, 8, 0);
			scene3Grid.add(fakeLabel, 2, 3);
			scene3Grid.add(bChangeRace, 3, 3);
			scene3Grid.add(bChangeClass, 3, 5);
			scene3Grid.add(fakeLabel2, 4, 3);
			scene3Grid.add(bGoldLevel, 5, 3);
			scene3Grid.add(bPlayMonster, 5, 5);
			scene3Grid.add(fakeLabel3, 6, 5);
			scene3Grid.add(bHalflingSell, 7, 3);
			scene3Grid.add(bSellTreasure, 7, 5);
			scene3Grid.add(separator, 1,10,8,1);

			//Puts however many cards the character has in the hbox
			if(playerHand.size() == 0)
			{
				cardsHbox = new HBox(10, characterInfo);
			}
			else if(playerHand.size() == 1)
			{
				cardsHbox = new HBox(10, characterInfo, card1);
			}
			else if(playerHand.size() == 2)
			{
				cardsHbox = new HBox(10, characterInfo, card1, card2);
			}
			else if(playerHand.size() == 3)
			{
				cardsHbox = new HBox(10, characterInfo, card1, card2, card3);
			}
			else if(playerHand.size() == 4)
			{
				cardsHbox = new HBox(10, characterInfo, card1, card2, card3, card4);
			}
			else if(playerHand.size() == 5)
			{	
				cardsHbox = new HBox(10, characterInfo, card1, card2, card3, card4, card5); //Puts all the cards in one hbox
			}
			else
			{
				cardsHbox = new HBox(10, characterInfo, card1, card2, card3, card4, card5, card6); //Puts all the cards in one hbox
			}
			
			scene3Grid.add(cardsHbox, 1, 12, 8, 1);
			scene3Grid.add(actionLabel, 1, 15, 8, 1);
			scene3Hbox = new HBox(board, scene3Grid); //Puts the board and the rest of the buttons(except bDoorDeck) in an hbox
			scene3Pane = new Pane(scene3Hbox, bDoorDeck); //Made a pane so I can put the door deck button wherever I want
			scene3Draw2 = new Scene(scene3Pane, 1400, 700);
			pPrimaryStage.setScene(scene3Draw2);
			pPrimaryStage.setTitle("Munchkin Second Draw");
			pPrimaryStage.show();
				
			//Disabling all buttons at the beginning
			bChangeRace.setDisable(true);
			bChangeClass.setDisable(true);
			bGoldLevel.setDisable(true);
			bPlayMonster.setDisable(true);
			bHalflingSell.setDisable(true);
			bSellTreasure.setDisable(true);
				
			//Enables the halfing race ability if the player is a halfling
			if(character.getRace() == "Halfling")
			{
				bHalflingSell.setDisable(false);
			}
				
			//ToggleButton Actions for Scene 3
			cardsSelected = 0; //There are automatically no cards selected
			card1.setOnAction(e-> 
			{
				if(card1.isSelected())
				{
					cardChoice = 0; //Card is equal to playerhand.get(0). Card 1.
				}
				else
				{
					cardChoice = -1;
				}
				//Grays out or ungrays out the proper buttons
				EnableButtons(cardChoice, playerHand);
			});
					
			card2.setOnAction(e-> 
			{
				if(card2.isSelected())
				{
					cardChoice = 1; //Card is equal to playerhand.get(1). Card 2
				}
				else
				{
					cardChoice = -1;
				}
					
				//Grays out or ungrays out the proper buttons
				EnableButtons(cardChoice, playerHand);
			});
					
			card3.setOnAction(e-> 
			{
				if(card3.isSelected())
				{
					cardChoice = 2; //Card is equal to playerhand.get(2). Card 3
				}
				else
				{
					cardChoice = -1;
				}
					
				//Grays out or ungrays out the proper buttons
				EnableButtons(cardChoice, playerHand);
			});
					
			card4.setOnAction(e-> 
			{
				if(card4.isSelected())
				{
					cardChoice = 3; //Card is equal to playerhand.get(3). Card 4,		
				}
				else
				{
					cardChoice = -1;
				}
					
				//Grays out or ungrays out the proper buttons
				EnableButtons(cardChoice, playerHand);
			});
					
			card5.setOnAction(e-> 
			{
				if(card5.isSelected())
				{
					cardChoice = 4; //Card is equal to playerhand.get(4);. Card 5
				}
				else 
				{
					cardChoice = -1;
				}
					
				//Grays out or ungrays out the proper buttons
				EnableButtons(cardChoice, playerHand);
			});
				
					
					
			//Button actions for Scene 3
			bRules.setOnAction(e-> Rules());
			bChangeRace.setOnAction(e-> characterHelper.changeRace(character, playerHand, cardChoice));
			bChangeClass.setOnAction(e-> characterHelper.changeClass(character, playerHand, cardChoice));
			bGoldLevel.setOnAction(e-> characterHelper.buyLevel(character, cardChoice));
			bPlayMonster.setOnAction(e-> playerHandHelper.playMonster(character, playerHand, cardChoice));
			bHalflingSell.setOnAction(e-> halfling.sellDouble(bHalflingSell, playerHand, character, cardChoice));
			bSellTreasure.setOnAction(e-> playerHandHelper.sellTreasure(character, playerHand, cardChoice));
			bDoorDeck.setOnAction(e->
			{
				playerHandHelper.drawDoor(doorCards, playerHand);
				
				//Makes sure the player doesn't go over their card limit
				if(playerHand.size() > maxCards)
				{
					discardScene(pPrimaryStage);
				}
				else
				{
					startScene(pPrimaryStage);
				}
				
			});
		}
	}
	
	public void abilityScene(Stage pPrimaryStage) 
	{
		//No cards are selected by default in every scene
		cardsSelected = 0;
		card1Selected = false;
		card2Selected = false;
		card3Selected = false;
		card4Selected = false;
		card5Selected = false;
		card6Selected = false;
		card7Selected = false;
		monsterDrawn = true; //Will make this method go back to the monster encounter scene when done
		
		setStyles();
		
		//Removing all the cards from a toggle group so they can select more than one
		card1.setToggleGroup(null);
		card2.setToggleGroup(null);
		card3.setToggleGroup(null);
		card4.setToggleGroup(null);
		card5.setToggleGroup(null);
		card6.setToggleGroup(null);
		card7.setToggleGroup(null);
		card8.setToggleGroup(null);
		
		instructionLabel.setText("	Please choose up to three cards below to use your class ability!"); //Changing the text of the instruction label
		
		//Setting up the layout for scene 4
		scene4Grid = new GridPane();
		scene4Grid.setHgap(10);
		scene4Grid.setVgap(10);
		scene4Grid.add(instructionLabel, 1, 0, 7, 1);
		scene4Grid.add(bRules, 8, 0);
		
		//Puts however many cards the player has into an hbox
		if(playerHand.size() == 0)
		{
			cardsHbox = new HBox(10, characterMonsterInfo);
		}
		else if(playerHand.size() == 1)
		{
			cardsHbox = new HBox(10, characterMonsterInfo, card1);
		}
		else if(playerHand.size() == 2)
		{
			cardsHbox = new HBox(10, characterMonsterInfo, card1, card2);
		}
		else if(playerHand.size() == 3)
		{
			cardsHbox = new HBox(10, characterMonsterInfo, card1, card2, card3);
		}
		else if(playerHand.size() == 4)
		{
			cardsHbox = new HBox(10, characterMonsterInfo, card1, card2, card3, card4);
		}
		else if(playerHand.size() == 5)
		{	
			cardsHbox = new HBox(10, characterMonsterInfo, card1, card2, card3, card4, card5); //Puts all the cards in one hbox
		}
		else
		{
			cardsHbox = new HBox(10, characterMonsterInfo, card1, card2, card3, card4, card5, card6); //Puts all the cards in one hbox
		}
		
		scene4Grid.add(cardsHbox, 1, 7, 8, 1);
		actionLabel.setMinHeight(70); //Readjusting the height of the action label
		scene4Grid.add(actionLabel, 1, 17, 9, 1);
		scene4Grid.add(bDiscard, 1, 22);
		fakeLabel.setMinWidth(550);
		scene4Grid.add(fakeLabel, 6, 22);
		scene4Hbox = new HBox(board, scene4Grid); //Puts the board and the rest of the buttons in an hbox
		scene4DiscardAbility = new Scene(scene4Hbox, 1400, 700);
		pPrimaryStage.setScene(scene4DiscardAbility);
		pPrimaryStage.setTitle("Munchkin Discard for Class Ability");
		pPrimaryStage.show();
		
		//Togglebutton actions for Scene 4
		cardsSelected = 0; //There are automatically no cards selected
		card1.setOnAction(e-> 
		{
			if(card1.isSelected())
			{
				card1Selected = true; //Card 1 is selected
				cardsSelected++;
			}
			else
			{
				card1Selected = false; //Card 1 is not selected
				cardsSelected--;
			}
		});
				
		card2.setOnAction(e-> 
		{
			if(card2.isSelected())
			{
				card2Selected = true; //Card 1 is selected
				cardsSelected++;
			}
			else
			{
				card2Selected = false; //Card 2 is not selected
				cardsSelected--;
			}
		});
				
		card3.setOnAction(e-> 
		{
			if(card3.isSelected())
			{
				card3Selected = true; //Card 3 is selected
				cardsSelected++;
			}
			else
			{
				card3Selected = false; //Card 3 is not selected
				cardsSelected--;
			}
		});
				
		card4.setOnAction(e-> 
		{
			if(card4.isSelected())
			{
				card4Selected = true; //Card 4 is selected
				cardsSelected++;
			}
			else
			{
				card4Selected = false; //Card 4 is not selected
				cardsSelected--;
			}
		});
				
		card5.setOnAction(e-> 
		{
			if(card5.isSelected())
			{
				card5Selected = true; //Card 5 is selected
				cardsSelected++;
			}
			else 
			{
				card5Selected = false; //Card 5 is not selected
				cardsSelected--;
			}
		});
		
		card6.setOnAction(e-> //Implemented for dwarves
		{
			if(card5.isSelected())
			{
				card5Selected = true; //Card 6 is selected
				cardsSelected++;
			}
			else 
			{
				card5Selected = false; //Card 6 is not selected
				cardsSelected--;
			}
		});
		
		
		//Button actions for scene 4
		bRules.setOnAction(e-> Rules());
		
		//Will discard if the player has toggles 3 cards or less
		bDiscard.setOnAction(e-> 
		{
			playerHandHelper.discardAbility(character, instructionLabel, cardsSelected, playerHand, card1Selected, card2Selected, card3Selected, card4Selected, card5Selected, card6Selected);
			//Only continues if at least 1 card is selected and 3 or less cards are selected
			if(cardsSelected <=3 && cardsSelected >= 1)
			{		
				switchScene(pPrimaryStage);
			}
			
		});
		
	}
	
	public void discardScene(Stage pPrimaryStage)
	{
		
		//No cards are selected by default in every scene
		cardsSelected = 0;
		card1Selected = false;
		card2Selected = false;
		card3Selected = false;
		card4Selected = false;
		card5Selected = false;
		card6Selected = false;
		card7Selected = false;
		card8Selected = false;
		
		setStyles();
		
		//Removing all the cards from a toggle group so they can select more than one
		card1.setToggleGroup(null);
		card2.setToggleGroup(null);
		card3.setToggleGroup(null);
		card4.setToggleGroup(null);
		card5.setToggleGroup(null);
		card6.setToggleGroup(null);
		card7.setToggleGroup(null);
		card8.setToggleGroup(null);
		
		
		
		instructionLabel.setText("	You have obtained too many cards! Please choose some to discard below!");
		
		//Setting up the layout for scene 4
		scene5Grid = new GridPane();
		scene5Grid.setHgap(10);
		scene5Grid.setVgap(10);
		scene5Grid.add(instructionLabel, 1, 0, 7, 1);
		scene5Grid.add(bRules, 8, 0);
		
		if(playerHand.size() == 0)
		{
			cardsHbox = new HBox(10, characterInfo);
		}
		else if(playerHand.size() == 1)
		{
			cardsHbox = new HBox(10, characterInfo, card1);
		}
		else if(playerHand.size() == 2)
		{
			cardsHbox = new HBox(10, characterInfo, card1, card2);
		}
		else if(playerHand.size() == 3)
		{
			cardsHbox = new HBox(10, characterInfo, card1, card2, card3);
		}
		else if(playerHand.size() == 4)
		{
			cardsHbox = new HBox(10, characterInfo, card1, card2, card3, card4);
		}
		else if(playerHand.size() == 5) //If the player is not a dwarf they can hold 5
		{
			cardsHbox = new HBox(10, characterInfo, card1, card2, card3, card4, card5); //Puts all the cards in one hbox
		}
		else if(playerHand.size() == 6) //If the player is a dwarf they can hold 6 or if the player has too many cards
		{
			cardsHbox = new HBox(10, characterInfo, card1, card2, card3, card4, card5, card6); //Puts all the cards in one hbox
		}
		else if(playerHand.size() == 7) //If the dwarf has too many cards (7) 
		{
			cardsHbox = new HBox(10, characterInfo, card1, card2, card3, card4, card5, card6, card7); //Puts all the cards in one hbox
		}
		else //If it's the beginning of the game and the player has 8 cards to discard
		{
			cardsHbox = new HBox(10, characterInfo, card1, card2, card3, card4, card5, card6, card7, card8);
		}
		
		scene5Grid.add(characterInfo, 1, 7);
		scene5Grid.add(cardsHbox, 1, 9, 8, 1);
		scene5Grid.add(bDiscard, 1, 22);
		fakeLabel.setMinWidth(550);
		scene5Grid.add(fakeLabel, 6, 22);
		scene5Hbox = new HBox(board, scene5Grid); //Puts the board and the rest of the buttons in an hbox
		
		//Sets the size of the scene according to how many cards the player has
		if(playerHand.size() < 6)
		{
			//savedline
			scene5Discard = new Scene(scene5Hbox, 1400, 700);
		}
		else //When the player starts the game they start with 8 cards
		{
			scene5Discard = new Scene(scene5Hbox, 1500, 700);
		}
		
		pPrimaryStage.setScene(scene5Discard);
		pPrimaryStage.setTitle("Munchkin Discard Cards");
		pPrimaryStage.show();
		
		//Togglebutton actions for Scene 4
		cardsSelected = 0; //There are automatically no cards selected
		card1.setOnAction(e-> 
		{
			if(card1.isSelected())
			{
				card1Selected = true; //Card 1 is selected
				cardsSelected++;
			}
			else
			{
				card1Selected = false; //Card 1 is not selected
				cardsSelected--;
			}
		});
				
		card2.setOnAction(e-> 
		{
			if(card2.isSelected())
			{
				card2Selected = true; //Card 1 is selected
				cardsSelected++;
			}
			else
			{
				card2Selected = false; //Card 2 is not selected
				cardsSelected--;
			}
		});
				
		card3.setOnAction(e-> 
		{
			if(card3.isSelected())
			{
				card3Selected = true; //Card 3 is selected
				cardsSelected++;
			}
			else
			{
				card3Selected = false; //Card 3 is not selected
				cardsSelected--;
			}
		});
				
		card4.setOnAction(e-> 
		{
			if(card4.isSelected())
			{
				card4Selected = true; //Card 4 is selected
				cardsSelected++;
			}
			else
			{
				card4Selected = false; //Card 4 is not selected
				cardsSelected--;
			}
		});
				
		card5.setOnAction(e-> 
		{
			if(card5.isSelected())
			{
				card5Selected = true; //Card 5 is selected
				cardsSelected++;
			}
			else 
			{
				card5Selected = false; //Card 5 is not selected
				cardsSelected--;
			}
		});
		
		card6.setOnAction(e-> 
		{
			if(card6.isSelected())
			{
				card6Selected = true; //Card 5 is selected
				cardsSelected++;
			}
			else 
			{
				card6Selected = false; //Card 5 is not selected
				cardsSelected--;
			}
		});
		
		card7.setOnAction(e-> 
		{
			if(card7.isSelected())
			{
				card7Selected = true; //Card 5 is selected
				cardsSelected++;
			}
			else 
			{
				card7Selected = false; //Card 5 is not selected
				cardsSelected--;
			}
		});
		
		card8.setOnAction(e-> 
		{
			if(card8.isSelected())
			{
				card8Selected = true; //Card 5 is selected
				cardsSelected++;
			}
			else 
			{
				card8Selected = false; //Card 5 is not selected
				cardsSelected--;
			}
		});
		
		//Button Actions
		bDiscard.setOnAction(e->
		{
			//Player drew too many cards
			playerHandHelper.discard(maxCards, instructionLabel, cardsSelected, secondaryStage, playerHand, card1Selected, card2Selected, card3Selected, card4Selected, card5Selected, card6Selected, card7Selected, card8Selected);
			
			//Only continues if at least 1 card is selected and the amount of cards they would have after the discard is less than their allowed max
			if(cardsSelected >=1 && (playerHand.size() - cardsSelected) <= maxCards)
			{
				if(Draw1st == false) //Player was at stage 3 and drew too many, go to stage 1 after discard
				{
					startScene(pPrimaryStage);
				}
				else //Player was at stage 1 and drew too many(not monster), go to stage 3 after discard
				{
					switchScene(pPrimaryStage);
				}
			}
			
		});
		
	}
	
	
	public ArrayList createDoorDeck()
	{
		//Creating the doorCard arrayList
		ArrayList doorDeckCards = new ArrayList();
				
		for(int i = 0; i < 30; i++) //30% monster cards
		{	
			doorDeckCards.add(DoorDeckFactory.createCard(1)); //Puts monsters in the door deck

		}
							
		for(int i = 0; i < 30; i++) //30% curse cards
		{	
			doorDeckCards.add(DoorDeckFactory.createCard(3)); //Puts curses in the door deck
		}
						
		for(int i = 0; i < 10; i++) //10% helpful cards
		{	
			doorDeckCards.add(DoorDeckFactory.createCard(2)); //Puts helpful cards in the door deck
		}
						
		for(int i = 0; i < 5; i++) //15% race cards
		{	
			doorDeckCards.add(DoorDeckFactory.createCard(7)); //Adds race elfs to the door deck
			doorDeckCards.add(DoorDeckFactory.createCard(8)); //Adds race halflings to the door deck
			doorDeckCards.add(DoorDeckFactory.createCard(9)); //Adds race dwarves to the door deck
		}
						
		for(int i = 0; i < 5; i++) //15% class cards
		{	
			doorDeckCards.add(DoorDeckFactory.createCard(4)); //Adds class warriors to the door deck
			doorDeckCards.add(DoorDeckFactory.createCard(5)); //Adds class wizards to the door deck
			doorDeckCards.add(DoorDeckFactory.createCard(6)); //Adds class clerics to the door deck
		}
						
		Collections.shuffle(doorDeckCards); //Shuffles all the cards that were added to the array list
		doorDeckNum = 99; //Says there are 100 cards in the door deck(Since we start with 0)
		//End of doorcard arraylist creation
		
		return(doorDeckCards);
	}
	
	//Grays out or ungrays out the proper buttons
	public void EnableButtons(int pCardChoice, ArrayList pPlayerHand)
	{
		
		if(pCardChoice == -1)
		{
			bChangeRace.setDisable(true);
			bChangeClass.setDisable(true);
			bGoldLevel.setDisable(true);
			bPlayMonster.setDisable(true);
			bHalflingSell.setDisable(true);
			bSellTreasure.setDisable(true);
			bTreasureBonus.setDisable(true);
			bHelpfulLevel.setDisable(true);
			bHelpfulSell.setDisable(true);
		}
		else
		{	
			if(pPlayerHand.get(pCardChoice) instanceof Monster) //Makes play monster clickable if the card is a monster. All others are gray.
			{
				bHelpfulLevel.setDisable(true);
				bHelpfulSell.setDisable(true);
				bPlayMonster.setDisable(false);
				bChangeRace.setDisable(true);
				bChangeClass.setDisable(true);
				bGoldLevel.setDisable(true);
				bSellTreasure.setDisable(true);
			}
			else if(pPlayerHand.get(pCardChoice) instanceof Treasure) //Makes sell treasure and treasure bonus clickable if the card is a treasure card. All others are gray.
			{
				bSellTreasure.setDisable(false);
				bChangeRace.setDisable(true);
				bChangeClass.setDisable(true);
				bGoldLevel.setDisable(true);
				bPlayMonster.setDisable(true);
				bTreasureBonus.setDisable(false);
				bHelpfulLevel.setDisable(true);
				bHelpfulSell.setDisable(true);
			
			}
			//Makes change race clickable if the card is a race card. All others are gray.
			else if(pPlayerHand.get(pCardChoice) instanceof Halfling || pPlayerHand.get(pCardChoice) instanceof Elf || pPlayerHand.get(pCardChoice) instanceof Dwarf)
			{
				bChangeRace.setDisable(false);
				bChangeClass.setDisable(true);
				bGoldLevel.setDisable(true);
				bPlayMonster.setDisable(true);
				bSellTreasure.setDisable(true);
				bHelpfulLevel.setDisable(true);
				bHelpfulSell.setDisable(true);
			}
			//Makes change class clickable if the card is a class card. All others are gray.
			else if(pPlayerHand.get(pCardChoice) instanceof Cleric || pPlayerHand.get(pCardChoice) instanceof Warrior || pPlayerHand.get(pCardChoice) instanceof Wizard)
			{
				bChangeRace.setDisable(true);
				bChangeClass.setDisable(false);
				bGoldLevel.setDisable(true);
				bPlayMonster.setDisable(true);
				bSellTreasure.setDisable(true);
				bHelpfulLevel.setDisable(true);
				bHelpfulSell.setDisable(true);
			}
			//Makes helpful level and helpful sell clickable if the card chosen is a helpful card. All others are gray.
			else if (pPlayerHand.get(pCardChoice) instanceof Helpful)
			{
				bHelpfulLevel.setDisable(false);
				bHelpfulSell.setDisable(false);
				bChangeRace.setDisable(true);
				bChangeClass.setDisable(true);
				bGoldLevel.setDisable(true);
				bPlayMonster.setDisable(true);
				bSellTreasure.setDisable(true);
				bTreasureBonus.setDisable(true);
			}
			//If it isn't any of the above then the button is disabled
			else
			{
				bHelpfulLevel.setDisable(true);
				bHelpfulSell.setDisable(true);
				bChangeRace.setDisable(true);
				bChangeClass.setDisable(true);
				bGoldLevel.setDisable(true);
				bPlayMonster.setDisable(true);
				bSellTreasure.setDisable(true);
				bTreasureBonus.setDisable(true);
			}
		}
	}
	
	
	public ArrayList dealPlayerHand(ArrayList pDoorCards) //At the beginning of the game the player is dealt 8 cards
	{
		ArrayList originalPlayerHand = new ArrayList();
		
		for(int i = 0; i < 8; i++) //Gives the player 8 cards to start
		{
			originalPlayerHand.add(doorCards.get(doorDeckNum)); //adds cards to players hand
			doorCards.remove(doorDeckNum); //removes the cards from the top of the door deck
			doorDeckNum--; //deincrements the number of cards in the door deck
		}
		
		return(originalPlayerHand);
	}
	
	public void Rules()
	{
		System.out.println("Rules"); //For testing only! Checks to see if the button is working.
	}
	
	//Creating all buttons, togglebuttons, labels, etc and setting their styles
	public void setStyles()
	{	
		//Creating and styling buttons
		bChangeRace = new Button("Change Race");
		bChangeRace.setStyle("-fx-border-color: black; -fx-background-color: #def4de;" );
		bChangeRace.setMinSize(200, 100);
		bChangeClass = new Button("Change Class");
		bChangeClass.setStyle("-fx-border-color: black; -fx-background-color: #def4de;" );
		bChangeClass.setMinSize(200, 100);
		
		bHelpfulLevel = new Button("Use Helpful Card \nto Level Up");
		bHelpfulLevel.setStyle("-fx-border-color: black; -fx-background-color: #def4de;" );
		bHelpfulLevel.setMinSize(200, 100);
		
		bHelpfulSell = new Button("Use Helpful Card \nto Sell Treasure for 2x");
		bHelpfulSell.setStyle("-fx-border-color: black; -fx-background-color: #def4de;" );
		bHelpfulSell.setMinSize(200, 100);
		
		bSellTreasure = new Button("Sell Treasure");
		bSellTreasure.setStyle("-fx-border-color: black; -fx-background-color: #def4de;" );
		bSellTreasure.setMinSize(200, 100);
		
		bHalflingSell = new Button("Use halfling ability \nto Sell Treasure for 2x");
		bHalflingSell.setStyle("-fx-border-color: black; -fx-background-color: #def4de; -fx-focus-color: white; ");
		bHalflingSell.setMinSize(200, 100);
		
		bRules = new Button("Rules");
		bRules.setStyle("-fx-border-color: black; -fx-background-color: #def4de; -fx-shadow-highlight-color: white" );
		bRules.setMinSize(150, 50);
		
		bDoorDeck = new Button();
		bDoorDeck.setStyle("-fx-background-color: transparent; -fx-background-radius: 7;");
		bDoorDeck.setMinSize(116, 77);
		
		bDoorDeck.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(7.0), BorderStroke.THICK)));
		
		bGoldLevel = new Button("Pay 1000 Gold to Level Up");
		bGoldLevel.setStyle("-fx-border-color: black;  -fx-background-color: #def4de; -fx-focus-color: white; ");
		bGoldLevel.setMinSize(200, 100);
		
		bPlayMonster = new Button("Play Monster");
		bPlayMonster.setStyle("-fx-border-color: black; -fx-background-color: #def4de; -fx-focus-color: white; ");
		bPlayMonster.setMinSize(200, 100);
		
		bTreasureBonus = new Button("Use a Treasure Card \nto Gain a Fight Bonus");
		bTreasureBonus.setStyle("-fx-border-color: black; -fx-background-color: #def4de; -fx-focus-color: white; ");
		bTreasureBonus.setMinSize(200, 100);
		
		bTurning = new Button("Turning(Cleric)");
		bTurning.setStyle("-fx-border-color: black; -fx-background-color: #def4de; -fx-focus-color: white; ");
		bTurning.setMinSize(200, 100);
		
		bFlight = new Button("Flight(Wizard)");
		bFlight.setStyle("-fx-border-color: black; -fx-background-color: #def4de; -fx-focus-color: white; ");
		bFlight.setMinSize(200, 100);
		
		bBerserking = new Button("Berserking(Warrior)");
		bBerserking.setStyle("-fx-border-color: black; -fx-background-color: #def4de; -fx-focus-color: white; ");
		bBerserking.setMinSize(200, 100);
		
		bCharm = new Button("Charm(Wizard)");
		bCharm.setStyle("-fx-border-color: black; -fx-background-color: #def4de; -fx-focus-color: white; ");
		bCharm.setMinSize(200, 100);
		
		bMonsterEncounter = new Button("Monster");
		bMonsterEncounter.setMinSize(200, 275);		
		
		bDiscard = new Button("Discard");
		bDiscard.setMinSize(200, 100);		
		bDiscard.setStyle("-fx-border-color: black; -fx-background-color: #def4de; -fx-focus-color: white; ");
		
		bGoBack = new Button("Go Back");
		bGoBack.setMinSize(200,  100);
		bGoBack.setStyle("-fx-border-color: black; -fx-background-color: #def4de; -fx-focus-color: white; ");
				
		//Creating and styling toggle buttons
		card1 = new ToggleButton("Card1");
		card1.setMinSize(130, 205);
		card1.setStyle("-fx-border-radius: 10; -fx-background-radius: 10");
		
		card2 = new ToggleButton("Card2");
		card2.setMinSize(130, 205);
		card2.setStyle("-fx-border-radius: 10; -fx-background-radius: 10");
		
		card3 = new ToggleButton("Card3");
		card3.setMinSize(130, 205);
		card3.setStyle("-fx-border-radius: 10; -fx-background-radius: 10");
		
		card4 = new ToggleButton("Card4");
		card4.setMinSize(130, 205);
		card4.setStyle("-fx-border-radius: 10; -fx-background-radius: 10");
		
		card5 = new ToggleButton("Card5");
		card5.setMinSize(130, 205);
		card5.setStyle("-fx-border-radius: 10; -fx-background-radius: 10");
		
		card6 = new ToggleButton("Card6");
		card6.setMinSize(130, 205);
		card6.setStyle("-fx-border-radius: 10; -fx-background-radius: 10");
		
		card7 = new ToggleButton("Card7");
		card7.setMinSize(130, 205);
		card7.setStyle("-fx-border-radius: 10; -fx-background-radius: 10");
		
		card8 = new ToggleButton("Card8");
		card8.setMinSize(130, 205);
		card8.setStyle("-fx-border-radius: 10; -fx-background-radius: 10");
		
		//Putting the toggle buttons into a group
		cardGroup = new ToggleGroup();
		card1.setToggleGroup(cardGroup);
		card2.setToggleGroup(cardGroup);
		card3.setToggleGroup(cardGroup);
		card4.setToggleGroup(cardGroup);
		card5.setToggleGroup(cardGroup);
		card6.setToggleGroup(cardGroup);
		card7.setToggleGroup(cardGroup);
		card8.setToggleGroup(cardGroup);
				
				
		//Creating and styling labels
		instructionLabel = new Label("	Please pick a card from your hand to proceed with one of the grayed out options below!");
		instructionLabel.setStyle("-fx-border-color: black; -fx-border-radius: 10; -fx-background-radius: 10; -fx-background-color: #ffe5e5;");
		instructionLabel.setMinSize(850, 40);
		
		//ImaginaryLabels to help with spacing
		fakeLabel = new Label();
		fakeLabel.setMinSize(50, 50);
		fakeLabel2 = new Label();
		fakeLabel2.setMinSize(50, 50);
		fakeLabel3 = new Label();
		fakeLabel3.setMinSize(50, 50);
		fakeLabel4 = new Label();
		fakeLabel4.setMinSize(30, 30);
		fakeLabel5 = new Label();
		fakeLabel5.setMinSize(85, 85);
		//End of spacing labels
		
		actionLabel = new Label("	Please click on the door deck to draw and continue your adventure!");
		actionLabel.setStyle("-fx-border-color: black; -fx-border-radius: 10; -fx-background-radius: 10; -fx-background-color: #ffe5e5;");
		actionLabel.setMinSize(1012, 40);
		
		characterInfo = new Label("Player Level: " + character.getLevel()  + "\nPlayer Race: " + character.getRace() + "\nPlayer Class: " + character.getplayerClass() + "\nPlayer Gold: " + character.getGold());
		
		monsterActionLabel = new Label("	Please pick a treasure card from your hand to proceed with the\n	grayed out option below");
		monsterActionLabel.setStyle("-fx-border-color: black; -fx-border-radius: 10; -fx-background-radius: 10; -fx-background-color: #ffe5e5;");
		monsterActionLabel.setMinSize(400, 40);
		
		abilityLabel = new Label("	Class abilities are below. Abilities that aren't used\n	by your current class will be grayed out.");
		abilityLabel.setStyle("-fx-border-color: black; -fx-border-radius: 10; -fx-background-radius: 10; -fx-background-color: #ffe5e5;");
		abilityLabel.setMinSize(450, 40);
		
		characterMonsterInfo = new Label("Player Level: " + character.getLevel()  + "\nPlayer Race: " + character.getRace() + "\nPlayer Class: " + character.getplayerClass() + "\nPlayer Gold: " + character.getGold() + "\nFight Bonus: " + character.getFightBonus() + "\nRun Bonus:" + character.getRunBonus());
				
		//Making line to seperate buttons and cards
		separator = new Line(0, 1, 1200, 1);
				
		//Loading in the images
		try 
		{
			munchkinBoard = new FileInputStream("C:\\Users\\Lex\\Desktop\\Programs\\MunchkinCapstone\\src\\Images\\Board.jpg");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		iBoard = new Image(munchkinBoard);
		board = new ImageView(iBoard);
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
	
	
}
