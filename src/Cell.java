

/**
 *
 * @author Jacek Byzdra
 * email: jacekbwwa@gmail.com
 */
public class Cell {

    protected String cellName;
    protected String cellState;
    protected int weightsMoveComp;
    protected int weightsMovePlayer1;
    protected int weightsMovePlayer2;
    protected String moveComp;
    protected String movePlayer1;
    protected String movePlayer2;
    protected String cellSign;
    protected int priorCellsComp;
    protected int priorCellsPlayer1;
    protected int priorCellsPlayer2;
    protected int weightNumberPlayers;
    Pair pair;

    public Cell() {
     Pair pair = new Pair();
    }
    
   

    public Cell(String cellName) {
        this.cellName = cellName;
    }
    
    public Cell(Pair pair){
        this.pair=pair;
    }

    
    public void setCellName(String cellName){
        this.cellName=cellName;
    }
    
    public String getCellName(){
        return cellName;
    }
    
    
    public void setCellState(String cellState) {
        this.cellState = cellState;
    }

    public String getCellState() {
        return cellState;
    }

/**
 *
 * @author Jacek Byzdra
 * email: jacekbwwa@gmail.com
 */
    public void setMoveComp(String moveComp) {
        this.moveComp = moveComp;
    }

    public String getMoveComp() {
        return moveComp;
    }

    public void setMovePlayer1(String movePlayer1) {
        this.movePlayer1 = movePlayer1;
    }

    public String getMovePlayer1() {
        return movePlayer1;
    }

    public void setMovePlayer2(String movePlayer2) {
        this.movePlayer2 = movePlayer2;
    }

    public String getMovePlayer2() {
        return movePlayer2;
    }

    public void setCellSign(String cellSign) {
        this.cellSign = cellSign;
    }

    public String getCellSign() {
        return cellSign;
    }

    public void setWeightsMoveComp(int weightsMoveComp) {
        this.weightsMoveComp = weightsMoveComp;
    }

    public int getWeightsMoveComp() {
        return weightsMoveComp;
    }
/**
 *
 * @author Jacek Byzdra
 * email: jacekbwwa@gmail.com
 */
    public void setWeightsMovePlayer1(int weightsMovePlayer1) {
        this.weightsMovePlayer1 = weightsMovePlayer1;
    }

    public int getWeightsMovePlayer1() {
        return weightsMovePlayer1;
    }

    public void setWeightsMovePlayer2(int weightsMovePlayer2) {
        this.weightsMovePlayer2 = weightsMovePlayer2;
    }

    public int getWeightsMovePlayer2() {
        return weightsMovePlayer2;
    }



    public void setPriorCellsComp(int priorCellsComp) {
        this.priorCellsComp = priorCellsComp;
    }

    public int getPriorCellsComp() {
        return priorCellsComp;
    }

    public void setPriorCellsPlayer1(int priorCellsPlayer1) {
        this.priorCellsPlayer1 = priorCellsPlayer1;
    }

    public int getPriorCellsPlayer1() {
        return priorCellsPlayer1;
    }

    public void setPriorCellsPlayer2(int priorCellsPlayer2) {
        this.priorCellsPlayer2 = priorCellsPlayer2;
    }

    public int getPriorCellsPlayer2() {
        return priorCellsPlayer2;
    }


            
        public void setWeightNumberPlayers(int weightNumberPlayers) {
        this.weightNumberPlayers = weightNumberPlayers;
    }

    public int getWeightNumPlayers() {
        return weightNumberPlayers;
    }        
/**
 *
 * @author Jacek Byzdra
 * email: jacekbwwa@gmail.com
 */  
    public void setPair(Pair pair){
        this.pair=pair;
    }
    
    public Pair getPair(){
        return pair;
    }
    
    
}
