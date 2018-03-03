package application;

public class Game {

  private Boolean monsterDrawn;
  
  //Since it is not a monster encounter no class abilities have been used so they will be set to false
  private Boolean turningUsed;
  private Boolean berserkingUsed;
  private Boolean flightUsed;
  private Boolean charmUsed;
  
  public Game() 
  {
    this.monsterDrawn = false;
    this.turningUsed = false;
    this.berserkingUsed = false;
    this.flightUsed = false;
    this.charmUsed = false;
  }
  
  
}
