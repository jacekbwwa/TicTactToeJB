
import javafx.scene.control.ToggleGroup;


/**
 *
 * @author Jacek Byzdra
 * email: jacekbwwa@gmail.com
 */
public class Player {

    protected String playerName;
    protected String playerSign;
    protected String playerTurn;
    protected String playerState;
    protected String playerQueue; 
    protected ToggleGroup groupPlayerSigns;
    protected ToggleGroup groupPlayer1Signs;
    protected ToggleGroup groupPlayer2Signs;    
    protected ToggleGroup groupCompSigns;
    protected ToggleGroup groupPlayer;
    protected ToggleGroup groupPlayer1;
    protected ToggleGroup groupPlayer2;
    protected ToggleGroup groupComp;
    protected int sumWin;
    protected int sumWinPlayer1;
    protected int sumWinPlayer2;
    protected int sumWinComp;
    


    public Player() {

    }
    
    public Player(String playerName){
        this.playerName=playerName;
    }
    
    

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

   

    public String getPlayerSign() {
        return playerSign;
    }

    public void setPlayerSign(String playerSign) {
        this.playerSign = playerSign;
    }

   

    

    public String getPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(String playerTurn) {
        this.playerTurn = playerTurn;
    }

    

    public String getPlayerState() {
        return playerState;
    }

    public void setPlayerState(String playerState) {
        this.playerState = playerState;
    }

  

   
    
    public String getPlayerQueue() {
        return playerQueue;
    }

    public void setPlayerQueue(String playerQueue) {
        this.playerQueue = playerQueue;
    }

    
    
    public void setGroupPlayer(ToggleGroup groupPlayer){
        this.groupPlayer=groupPlayer;
    }
    
    public ToggleGroup getGroupPlayer(){
        return groupPlayer;
    }
 
  

    public void setGroupPlayerSigns(ToggleGroup groupPlayerSigns){
        this.groupPlayerSigns=groupPlayerSigns;
    }
    
    public ToggleGroup getGroupPlayerSigns(){
        return groupPlayerSigns;
    }
 
   
    
    public void setSumWin(int sumWin){
        this.sumWin=sumWin;
    }
    
    public int getSumWin(){
        return sumWin;
    }
    
    /**
 *
 * @author Jacek Byzdra
 * email: jacekbwwa@gmail.com
 */
}
