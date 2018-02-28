/**
 *
 * @author Jacek Byzdra
 * email: jacekbwwa@gmail.com
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import static javafx.scene.paint.Color.YELLOW;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jacek Byzdra
 * email: jacekbwwa@gmail.com
 */
public class FXML1Controller implements Initializable {



    @FXML
    Button c00;
    @FXML
    Button c01;
    @FXML
    Button c02;
    @FXML
    Button c10;
    @FXML
    Button c11;
    @FXML
    Button c12;
    @FXML
    Button c20;
    @FXML
    Button c21;
    @FXML
    Button c22;
    @FXML
    AnchorPane anchorPaneOuter;
    @FXML
    AnchorPane anchorPaneInner;
    @FXML
    GridPane gridPaneGame;
    @FXML
    GridPane gridPanePlayersRB;
    @FXML
    GridPane gridPaneOptionLabel;
    @FXML
    GridPane gridPaneRestart;
    @FXML
    Button restartButton;
    @FXML
    Button newGameButton;
    @FXML
    RadioButton K02;
    @FXML
    RadioButton K01;
    @FXML
    RadioButton K11;
    @FXML
    RadioButton K03;
    @FXML
    RadioButton K12;
    @FXML
    RadioButton K13;
    @FXML
    RadioButton K21;
    @FXML
    RadioButton K22;
    @FXML
    RadioButton K23;
    @FXML
    RadioButton K00;
    @FXML
    RadioButton K10;
    @FXML
    RadioButton K20;
    @FXML
    ImageView ImageView00;
    @FXML
    ImageView ImageView01;
    @FXML
    ImageView ImageView02;
    @FXML
    ImageView ImageView10;
    @FXML
    ImageView ImageView11;
    @FXML
    ImageView ImageView12;
    @FXML
    ImageView ImageView20;
    @FXML
    ImageView ImageView21;
    @FXML
    ImageView ImageView22;
    @FXML
    GridPane gridPaneInfoMove;
    @FXML
    Label label00;
    @FXML
    Label label10;
    @FXML
    Label label20;
    @FXML
    GridPane gridPaneCounter;
    @FXML
    Label labelPlayer1;
    @FXML
    Label labelPlayer2;
    @FXML
    Label labelComp;
    @FXML
    GridPane gridPaneLabelStats;
    @FXML
    Label labelGameStats;
    @FXML
    Label labelPlayer1Stats;
    @FXML
    Label labelPlayer2Stats;
    @FXML
    Label labelCompStats;

    protected Model model = new Model();
    int i;
    int j;
    int m;
    int n;
    protected Image image;
    protected String returnPlayerSign;
    protected Stage primaryStage;
    protected Stage stage;

    private Main mainApplication;

        /**
     * Initializes the controller class.
     */
    public FXML1Controller() {
         
    }
    
    public void setMainApp(Main mainApplication) {
        this.mainApplication = mainApplication;
    }

    @FXML
    public void restartBut(ActionEvent event) throws Exception {
        if (event.getSource() == restartButton) {
            mainApplication.restart(stage);
        }
    }

    @FXML
    public Button getButton(int i, int j) {
        return (Button) gridPaneGame.lookup("#c" + i + j);

    }

    @FXML
    public Button getButtonX(int i) {
        return (Button) gridPaneGame.lookup("#c" + i);
    }

    @FXML
    public Button getButtonY(int j) {
        return (Button) gridPaneGame.lookup("#c" + j);
    }

    @FXML
    public void buttonClick(MouseEvent event) {

        Button bx = (Button) event.getSource();

    }
    
    
    @FXML
    public void buttonNewGameClick(MouseEvent event){
    
        clearGame();
    }

    @FXML
    public RadioButton getRadioButton(int i, int j) {
        return (RadioButton) gridPanePlayersRB.lookup("#c" + i + j);

    }

    @FXML
    public void signX(ActionEvent event) {
        if (event.getSource() == K01) {
            int mr = Integer.parseInt(K01.getId().substring(1, 2).toLowerCase());
            int mc = Integer.parseInt(K01.getId().substring(2).toLowerCase());
            String sB = K01.getId();
            model.setFireRowISign(mr);
            model.setFireColJSign(mc);
            model.setFireSign(sB);
         

            if (model.checkNullGroupPlayer1Signs() == true) {
                model.trigglePlayer1SignButton();
                K01.setToggleGroup(model.groupPlayer1Signs);
                K02.setDisable(true);
                K03.setDisable(true);
                K02.setVisible(false);
                K03.setVisible(false);
                enableGameButtonCells();
            }
                           if(model.comp.getPlayerQueue() == PlayerQueue.FIRST.toString() && model.checkNullGroupCompSigns() == false){
                    startButtonComp();
                }
        }
    }

    @FXML
    public void signO(ActionEvent event) {
        if (event.getSource() == K02) {

            int mr = Integer.parseInt(K02.getId().substring(1, 2).toLowerCase());
            int mc = Integer.parseInt(K02.getId().substring(2).toLowerCase());
            String sB = K02.getId();
            model.setFireRowISign(mr);
            model.setFireColJSign(mc);
            model.setFireSign(sB);
          

            if (model.checkNullGroupPlayer1Signs() == true) {
                model.trigglePlayer1SignButton();
                K02.setToggleGroup(model.groupPlayer1Signs);
                K03.setDisable(true);
                K01.setDisable(true);
                K01.setVisible(false);
                K03.setVisible(false);
                enableGameButtonCells();
            }
            
                           if(model.comp.getPlayerQueue() == PlayerQueue.FIRST.toString() && model.checkNullGroupCompSigns() == false){
                    startButtonComp();
                }

        }
    }

    @FXML
    public void signT(ActionEvent event) {
        if (event.getSource() == K03) {
            int mr = Integer.parseInt(K03.getId().substring(1, 2).toLowerCase());
            int mc = Integer.parseInt(K03.getId().substring(2).toLowerCase());
            String sB = K03.getId();
            model.setFireRowISign(mr);
            model.setFireColJSign(mc);
            model.setFireSign(sB);
          

            if (model.checkNullGroupPlayer1Signs() == true) {
                model.trigglePlayer1SignButton();
                K03.setToggleGroup(model.groupPlayer1Signs);
                K02.setDisable(true);
                K01.setDisable(true);
                K01.setVisible(false);
                K02.setVisible(false);
                enableGameButtonCells();
            }
            
                           if(model.comp.getPlayerQueue() == PlayerQueue.FIRST.toString() && model.checkNullGroupCompSigns() == false){
                    startButtonComp();
                }
        }
    }

    @FXML
    public void signPlus(ActionEvent event) {
        if (event.getSource() == K11) {
            int mr = Integer.parseInt(K11.getId().substring(1, 2).toLowerCase());
            int mc = Integer.parseInt(K11.getId().substring(2).toLowerCase());
            String sB = K11.getId();
            model.setFireRowISign(mr);
            model.setFireColJSign(mc);
            model.setFireSign(sB);
          

            if (model.checkNullGroupPlayer2Signs() == true) {
                model.trigglePlayer2SignButton();
                K11.setToggleGroup(model.groupPlayer2Signs);
                K12.setDisable(true);
                K13.setDisable(true);

                K12.setVisible(false);
                K13.setVisible(false);
                enableGameButtonCells();
            }
            
                           if(model.comp.getPlayerQueue() == PlayerQueue.FIRST.toString() && model.checkNullGroupCompSigns() == false){
                    startButtonComp();
                }
        }
    }

    @FXML
    public void signQ(ActionEvent event) {
        if (event.getSource() == K12) {
            int mr = Integer.parseInt(K12.getId().substring(1, 2).toLowerCase());
            int mc = Integer.parseInt(K12.getId().substring(2).toLowerCase());
            String sB = K12.getId();
            model.setFireRowISign(mr);
            model.setFireColJSign(mc);
            model.setFireSign(sB);
           

            if (model.checkNullGroupPlayer2Signs() == true) {
                model.trigglePlayer2SignButton();
                K12.setToggleGroup(model.groupPlayer2Signs);
                K11.setDisable(true);
                K13.setDisable(true);
                K11.setVisible(false);
                K13.setVisible(false);
                enableGameButtonCells();
            }
            
                           if(model.comp.getPlayerQueue() == PlayerQueue.FIRST.toString() && model.checkNullGroupCompSigns() == false){
                    startButtonComp();
                }
        }
    }

    @FXML
    public void signV(ActionEvent event) {
        if (event.getSource() == K13) {
            int mr = Integer.parseInt(K13.getId().substring(1, 2).toLowerCase());
            int mc = Integer.parseInt(K13.getId().substring(2).toLowerCase());
            String sB = K13.getId();
            model.setFireRowISign(mr);
            model.setFireColJSign(mc);
            model.setFireSign(sB);
         

            if (model.checkNullGroupPlayer2Signs() == true) {
                model.trigglePlayer2SignButton();
                K13.setToggleGroup(model.groupPlayer2Signs);
                K11.setDisable(true);
                K12.setDisable(true);
                K11.setVisible(false);
                K12.setVisible(false);
                enableGameButtonCells();
            }
            
                           if(model.comp.getPlayerQueue() == PlayerQueue.FIRST.toString() && model.checkNullGroupCompSigns() == false){
                    startButtonComp();
                }
        }
    }

    @FXML
    public void signHash(ActionEvent event) {
        if (event.getSource() == K21) {
            int mr = Integer.parseInt(K21.getId().substring(1, 2).toLowerCase());
            int mc = Integer.parseInt(K21.getId().substring(2).toLowerCase());
            String sB = K21.getId();
            model.setFireRowISign(mr);
            model.setFireColJSign(mc);
            model.setFireSign(sB);
          

            if (model.checkNullGroupCompSigns() == true) {
                model.triggleCompSignButton();
                K21.setToggleGroup(model.groupCompSign);
                K22.setDisable(true);
                K23.setDisable(true);

                K22.setVisible(false);
                K23.setVisible(false);
                enableGameButtonCells();
            }
            
                           if(model.comp.getPlayerQueue() == PlayerQueue.FIRST.toString() && model.checkNullGroupCompSigns() == false){
                    startButtonComp();
                }
        }
    }

    @FXML
    public void signAt(ActionEvent event) {
        if (event.getSource() == K22) {
            int mr = Integer.parseInt(K22.getId().substring(1, 2).toLowerCase());
            int mc = Integer.parseInt(K22.getId().substring(2).toLowerCase());
            String sB = K22.getId();
            model.setFireRowISign(mr);
            model.setFireColJSign(mc);
            model.setFireSign(sB);
          

            if (model.checkNullGroupCompSigns() == true) {
                model.triggleCompSignButton();
                K22.setToggleGroup(model.groupCompSign);
                K21.setDisable(true);
                K23.setDisable(true);
                K21.setVisible(false);
                K23.setVisible(false);

                enableGameButtonCells();
            }
                           if(model.comp.getPlayerQueue() == PlayerQueue.FIRST.toString() && model.checkNullGroupCompSigns() == false){
                    startButtonComp();
                }
        }
    }

    @FXML
    public void signH(ActionEvent event) {
        if (event.getSource() == K23) {
            int mr = Integer.parseInt(K23.getId().substring(1, 2).toLowerCase());
            int mc = Integer.parseInt(K23.getId().substring(2).toLowerCase());
            String sB = K23.getId();
            model.setFireRowISign(mr);
            model.setFireColJSign(mc);
            model.setFireSign(sB);
           

            if (model.checkNullGroupCompSigns() == true) {
                model.triggleCompSignButton();
                K23.setToggleGroup(model.groupCompSign);
                K22.setDisable(true);
                K21.setDisable(true);
                K21.setVisible(false);
                K22.setVisible(false);
                enableGameButtonCells();

            }
                           if(model.comp.getPlayerQueue() == PlayerQueue.FIRST.toString() && model.checkNullGroupCompSigns() == false){
                    startButtonComp();
                }
        }
    }

    @FXML
    public void player1(ActionEvent event) {
        if (event.getSource() == K00) {
            if (model.checkNullToogleForPl1() == true) {
                model.initPlayer1();
                if (model.player1.getPlayerQueue() == PlayerQueue.FIRST.toString()) {
                    label00.setText("First move");
                }
                K00.setToggleGroup(model.groupPlayer1);
                K01.setDisable(false);
                K02.setDisable(false);
                K03.setDisable(false);
                K01.setVisible(true);
                K02.setVisible(true);
                K03.setVisible(true);
                if (model.checkNullGroupPlayer2() != true) {
                    K20.setDisable(true);
                    K21.setDisable(true);
                    K22.setDisable(true);
                    K23.setDisable(true);
                    K20.setVisible(false);
                }
                if (model.checkNullGroupComp() != true) {
                    K10.setDisable(true);
                    K11.setDisable(true);
                    K12.setDisable(true);
                    K13.setDisable(true);
                    K10.setVisible(false);
                }
            }

        }
    }

    @FXML
    public void comp(ActionEvent event) {
        if (event.getSource() == K20) {
            if (model.checkNullToogleForComp() == true) {
                model.initComp();
                if (model.comp.getPlayerQueue() == PlayerQueue.FIRST.toString()) {
                    label20.setText("First move");
                }
                K20.setToggleGroup(model.groupComp);
                K21.setDisable(false);
                K22.setDisable(false);
                K23.setDisable(false);
                K21.setVisible(true);
                K22.setVisible(true);
                K23.setVisible(true);
                if (model.checkNullGroupPlayer2() != true) {
                    K00.setDisable(true);
                    K01.setDisable(true);
                    K02.setDisable(true);
                    K03.setDisable(true);
                    K00.setVisible(false);

                }
                if (model.checkNullGroupPlayer1() != true) {
                    K10.setDisable(true);
                    K11.setDisable(true);
                    K12.setDisable(true);
                    K13.setDisable(true);
                    K10.setVisible(false);
                }
            }
        }
    }

    @FXML
    public void player2(ActionEvent event) {
        if (event.getSource() == K10) {
            if (model.checkNullToogleForPl2() == true) {
                model.initPlayer2();
                if (model.player2.getPlayerQueue() == PlayerQueue.FIRST.toString()) {
                    label10.setText("First move");
                }
                K10.setToggleGroup(model.groupPlayer2);
                K11.setDisable(false);
                K12.setDisable(false);
                K13.setDisable(false);
                K11.setVisible(true);
                K12.setVisible(true);
                K13.setVisible(true);
                if (model.checkNullGroupPlayer1() != true) {
                    K20.setDisable(true);
                    K21.setDisable(true);
                    K22.setDisable(true);
                    K23.setDisable(true);
                    K20.setVisible(false);
                }
                if (model.checkNullGroupComp() != true) {
                    K00.setDisable(true);
                    K01.setDisable(true);
                    K02.setDisable(true);
                    K03.setDisable(true);
                    K00.setVisible(false);
                }
            }
        }
    }

    @FXML
    public Image getImageX() {
        image = new Image("img/x.png");
        return image;

    }

    @FXML
    public Image getImageO() {
        image = new Image("img/o.png");
        return image;

    }

    @FXML
    public Image getImageT() {
        image = new Image("img/t.png");
        return image;

    }

    @FXML
    public Image getImageAT() {
        image = new Image("img/at.png");
        return image;

    }

    @FXML
    public Image getImageHash() {
        image = new Image("img/hash.png");
        return image;

    }

    @FXML
    public Image getImageH() {
        image = new Image("img/h.png");
        return image;

    }

    @FXML
    public Image getImagePlus() {
        image = new Image("img/plus.png");
        return image;

    }

    @FXML
    public Image getImageQ() {
        image = new Image("img/q.png");
        return image;

    }

    @FXML
    public Image getImageV() {
        image = new Image("img/v.png");
        return image;

    }

    public boolean checkChoosedImage() {
        return !(returnPlayerSign == "AT_SIGN" || returnPlayerSign == "HASH_SIGN" || returnPlayerSign == "H_SIGN");
    }

    @FXML
    public Image triggleChoosedImage() {
        if (returnPlayerSign == "X_SIGN" || returnPlayerSign == "O_SIGN" || returnPlayerSign == "T_SIGN") {
            if (returnPlayerSign == "X_SIGN") {
                image = getImageX();
                return image;

            }
            if (returnPlayerSign == "O_SIGN") {
                image = getImageO();
                return image;
            }
            if (returnPlayerSign == "T_SIGN") {
                image = getImageT();
                return image;
            }
        } else if (returnPlayerSign == "PLUS_SIGN" || returnPlayerSign == "Q_SIGN" || returnPlayerSign == "V_SIGN") {
            if (returnPlayerSign == "PLUS_SIGN") {
                image = getImagePlus();
                return image;
            }
            if (returnPlayerSign == "Q_SIGN") {
                image = getImageQ();
                return image;
            }
            if (returnPlayerSign == "V_SIGN") {
                image = getImageV();
                return image;
            }
        } else if (returnPlayerSign == "AT_SIGN" || returnPlayerSign == "HASH_SIGN" || returnPlayerSign == "H_SIGN") {
            if (returnPlayerSign == "AT_SIGN") {
                image = getImageAT();
                return image;
            }
            if (returnPlayerSign == "HASH_SIGN") {
                image = getImageHash();
                return image;
            }
            if (returnPlayerSign == "H_SIGN") {
                image = getImageH();
                return image;
            }

        }
        return image;
    }

    
    
public void checkIfBoardIsFull(){
     if (model.checkIfPlayersArrayIsFull() == true) {
         labelGameStats.setText(PlayerResult.DRAW_GAME_OVER.toString());
         disableGameButtonCellsViewTrue();
     }
}
    
    

    
    public void check3InRow() {
        if (model.checkThreeInRow() == true) {
            model.checkWhowWins();
            if (model.winPlayer1 == true) {
                labelGameStats.setText(PlayerResult.PLAYER1_WINS_GAME_OVER.toString());
                labelPlayer1Stats.setText(Integer.toString(model.sumWinPlayer1));
                if (model.comp.getPlayerState() == PlayerState.IN_GAME.toString()) {
                    labelCompStats.setText(Integer.toString(model.sumWinComp));
                }
                if (model.player2.getPlayerState() == PlayerState.IN_GAME.toString()) {
                    labelPlayer2Stats.setText(Integer.toString(model.sumWinPlayer2));
                }
              disableGameButtonCellsViewTrue();
            }
            if (model.winComp == true) {
                labelGameStats.setText(PlayerResult.COMP_WINS_GAME_OVER.toString());
                labelCompStats.setText(Integer.toString(model.sumWinComp));
                if (model.player1.getPlayerState() == PlayerState.IN_GAME.toString()) {
                    labelPlayer1Stats.setText(Integer.toString(model.sumWinPlayer1));
                }
                if (model.player2.getPlayerState() == PlayerState.IN_GAME.toString()) {
                    labelPlayer2Stats.setText(Integer.toString(model.sumWinPlayer2));
                }
              disableGameButtonCellsViewTrue();
            }
            if (model.winPlayer2 == true) {
                labelGameStats.setText(PlayerResult.PLAYER2_WINS_GAME_OVER.toString());
                labelPlayer2Stats.setText(Integer.toString(model.sumWinPlayer2));
                if (model.comp.getPlayerState() == PlayerState.IN_GAME.toString()) {
                    labelCompStats.setText(Integer.toString(model.sumWinComp));
                }
                if (model.player1.getPlayerState() == PlayerState.IN_GAME.toString()) {
                    labelPlayer1Stats.setText(Integer.toString(model.sumWinPlayer1));
                }
              disableGameButtonCellsViewTrue();
            }

        }
        
    }

    @FXML
    public void mouseActionButtonC00(ActionEvent event) {
        if (event.getSource() == c00) {
            
            int mr = Integer.parseInt(c00.getId().substring(1, 2).toLowerCase());
            int mc = Integer.parseInt(c00.getId().substring(2).toLowerCase());
            model.setFireRowXMouseBut(mr);
            model.setFireRowYMouseBut(mc);
           
            returnPlayerSign = model.getCheckPlayersQueueAndReturnSign(mr, mc);

            c00 = (Button) event.getSource();
            image = triggleChoosedImage();
            ImageView00.setImage(image);
            check3InRow();
            checkIfBoardIsFull();
            if(model.checkIfPlayersArrayIsFull() == true){
                return;
            }

            else  if ((checkChoosedImage() == true) && (model.comp.getPlayerState() == PlayerState.IN_GAME.toString())) {
                startButtonComp();
            }
        }
    }

    @FXML
    public void mouseActionButtonC01(ActionEvent event) {
        if (event.getSource() == c01) {
            int mr = Integer.parseInt(c01.getId().substring(1, 2).toLowerCase());
            int mc = Integer.parseInt(c01.getId().substring(2).toLowerCase());
            model.setFireRowXMouseBut(mr);
            model.setFireRowYMouseBut(mc);
          
            returnPlayerSign = model.getCheckPlayersQueueAndReturnSign(mr, mc);

            c01 = (Button) event.getSource();
            image = triggleChoosedImage();
            ImageView01.setImage(image);
            check3InRow();
            checkIfBoardIsFull();
            if(model.checkIfPlayersArrayIsFull() == true){
                return;
            }

            else 
            
           if ((checkChoosedImage() == true) && (model.comp.getPlayerState() == PlayerState.IN_GAME.toString())) {
                startButtonComp();
            }
        }
    }

    @FXML
    public void mouseActionButtonC02(ActionEvent event) {
        if (event.getSource() == c02) {
            int mr = Integer.parseInt(c02.getId().substring(1, 2).toLowerCase());
            int mc = Integer.parseInt(c02.getId().substring(2).toLowerCase());
            model.setFireRowXMouseBut(mr);
            model.setFireRowYMouseBut(mc);
           
            returnPlayerSign = model.getCheckPlayersQueueAndReturnSign(mr, mc);

            c02 = (Button) event.getSource();
            image = triggleChoosedImage();
            ImageView02.setImage(image);
            check3InRow();
            checkIfBoardIsFull();
            if(model.checkIfPlayersArrayIsFull() == true){
                return;
            }

            else 
           if ((checkChoosedImage() == true) && (model.comp.getPlayerState() == PlayerState.IN_GAME.toString())) {
                startButtonComp();
            }
        }
    }

    @FXML
    public void mouseActionButtonC10(ActionEvent event) {
        if (event.getSource() == c10) {
            int mr = Integer.parseInt(c10.getId().substring(1, 2).toLowerCase());
            int mc = Integer.parseInt(c10.getId().substring(2).toLowerCase());
            model.setFireRowXMouseBut(mr);
            model.setFireRowYMouseBut(mc);
            
            returnPlayerSign = model.getCheckPlayersQueueAndReturnSign(mr, mc);

            c10 = (Button) event.getSource();
            image = triggleChoosedImage();
            ImageView10.setImage(image);
            check3InRow();
            checkIfBoardIsFull();
            if(model.checkIfPlayersArrayIsFull() == true){
                return;
            }

            else 
           if ((checkChoosedImage() == true) && (model.comp.getPlayerState() == PlayerState.IN_GAME.toString())) {
                startButtonComp();
            }
        }
    }

    @FXML
    public void mouseActionButtonC11(ActionEvent event) {
        if (event.getSource() == c11) {
            int mr = Integer.parseInt(c11.getId().substring(1, 2).toLowerCase());
            int mc = Integer.parseInt(c11.getId().substring(2).toLowerCase());
            model.setFireRowXMouseBut(mr);
            model.setFireRowYMouseBut(mc);
            
            returnPlayerSign = model.getCheckPlayersQueueAndReturnSign(mr, mc);

            c11 = (Button) event.getSource();
            image = triggleChoosedImage();
            ImageView11.setImage(image);
            check3InRow();
            checkIfBoardIsFull();
            if(model.checkIfPlayersArrayIsFull() == true){
                return;
            }

            else 
           if ((checkChoosedImage() == true) && (model.comp.getPlayerState() == PlayerState.IN_GAME.toString())) {
                startButtonComp();
            }
        }

    }

    @FXML
    public void mouseActionButtonC12(ActionEvent event) {
        if (event.getSource() == c12) {
            int mr = Integer.parseInt(c12.getId().substring(1, 2).toLowerCase());
            int mc = Integer.parseInt(c12.getId().substring(2).toLowerCase());
            model.setFireRowXMouseBut(mr);
            model.setFireRowYMouseBut(mc);
           
            returnPlayerSign = model.getCheckPlayersQueueAndReturnSign(mr, mc);

            c12 = (Button) event.getSource();
            image = triggleChoosedImage();
            ImageView12.setImage(image);
            check3InRow();
            checkIfBoardIsFull();
            if(model.checkIfPlayersArrayIsFull() == true){
                return;
            }

            else 
           if ((checkChoosedImage() == true) && (model.comp.getPlayerState() == PlayerState.IN_GAME.toString())) {
                startButtonComp();
            }
        }
    }

    @FXML
    public void mouseActionButtonC20(ActionEvent event) {
        if (event.getSource() == c20) {
            int mr = Integer.parseInt(c20.getId().substring(1, 2).toLowerCase());
            int mc = Integer.parseInt(c20.getId().substring(2).toLowerCase());
            model.setFireRowXMouseBut(mr);
            model.setFireRowYMouseBut(mc);
           
            returnPlayerSign = model.getCheckPlayersQueueAndReturnSign(mr, mc);

            c20 = (Button) event.getSource();
            image = triggleChoosedImage();
            ImageView20.setImage(image);
            check3InRow();
            checkIfBoardIsFull();
            if(model.checkIfPlayersArrayIsFull() == true){
                return;
            }

            else 
           if ((checkChoosedImage() == true) && (model.comp.getPlayerState() == PlayerState.IN_GAME.toString())) {
                startButtonComp();
            }
        }
    }

    @FXML
    public void mouseActionButtonC21(ActionEvent event) {
        if (event.getSource() == c21) {
            int mr = Integer.parseInt(c21.getId().substring(1, 2).toLowerCase());
            int mc = Integer.parseInt(c21.getId().substring(2).toLowerCase());
            model.setFireRowXMouseBut(mr);
            model.setFireRowYMouseBut(mc);
            
            returnPlayerSign = model.getCheckPlayersQueueAndReturnSign(mr, mc);

            c21 = (Button) event.getSource();
            image = triggleChoosedImage();
            ImageView21.setImage(image);
            check3InRow();
            checkIfBoardIsFull();
            if(model.checkIfPlayersArrayIsFull() == true){
                return;
            }

            else 
           if ((checkChoosedImage() == true) && (model.comp.getPlayerState() == PlayerState.IN_GAME.toString())) {
                startButtonComp();
            }
        }
    }

    @FXML
    public void mouseActionButtonC22(ActionEvent event) {
        if (event.getSource() == c22) {
            int mr = Integer.parseInt(c22.getId().substring(1, 2).toLowerCase());
            int mc = Integer.parseInt(c22.getId().substring(2).toLowerCase());
            model.setFireRowXMouseBut(mr);
            model.setFireRowYMouseBut(mc);
           
            returnPlayerSign = model.getCheckPlayersQueueAndReturnSign(mr, mc);

            c22 = (Button) event.getSource();
            image = triggleChoosedImage();
            ImageView22.setImage(image);
            check3InRow();
            checkIfBoardIsFull();
            if(model.checkIfPlayersArrayIsFull() == true){
                return;
            }

            else 
           if ((checkChoosedImage() == true) && (model.comp.getPlayerState() == PlayerState.IN_GAME.toString())) {
                startButtonComp();
            }
        }
    }

    @FXML
    public void clickByMistake(MouseEvent event) {
        if ((event.getSource() == anchorPaneOuter) || (event.getSource() == anchorPaneInner)) {
            System.out.println("Please click precisely");
        }
    }

    public void startButtonComp() {
        model.fireButtonComp();
        int r = model.getFireRowXComp();
        int k = model.getfireColYComp();
        Button cr = getButton(r, k);
        cr.fire();

    }

    public void enableGameButtonCells() {
        if (model.checkActivePlayer1HaveSign() == true) {
            c00.setDisable(false);
            c01.setDisable(false);
            c02.setDisable(false);
            c10.setDisable(false);
            c11.setDisable(false);
            c12.setDisable(false);
            c20.setDisable(false);
            c21.setDisable(false);
            c22.setDisable(false);

            c00.setVisible(true);
            c01.setVisible(true);
            c02.setVisible(true);
            c10.setVisible(true);
            c11.setVisible(true);
            c12.setVisible(true);
            c20.setVisible(true);
            c21.setVisible(true);
            c22.setVisible(true);
            model.addCellAndNameToCellArr();
            model.addNtoCellsStatePlayersArray();
            model.addNtoCellSignArr();
            model.addPairToCellArr();
            model.addWeightsNumbersPlayersToCell();
        }
        else if(model.checkActivePlayer2HaveSign() == true){
            c00.setDisable(false);
            c01.setDisable(false);
            c02.setDisable(false);
            c10.setDisable(false);
            c11.setDisable(false);
            c12.setDisable(false);
            c20.setDisable(false);
            c21.setDisable(false);
            c22.setDisable(false);

            c00.setVisible(true);
            c01.setVisible(true);
            c02.setVisible(true);
            c10.setVisible(true);
            c11.setVisible(true);
            c12.setVisible(true);
            c20.setVisible(true);
            c21.setVisible(true);
            c22.setVisible(true);
            model.addCellAndNameToCellArr();
            model.addNtoCellsStatePlayersArray();
            model.addNtoCellSignArr();
            model.addPairToCellArr();
            model.addWeightsNumbersPlayersToCell();
        }
    }

    public void disableGameButtonCellsViewTrue() {
        c00.setDisable(true);
        c01.setDisable(true);
        c02.setDisable(true);
        c10.setDisable(true);
        c11.setDisable(true);
        c12.setDisable(true);
        c20.setDisable(true);
        c21.setDisable(true);
        c22.setDisable(true);
    }
    
    public void disableGameButtonCells() {
        c00.setDisable(true);
        c01.setDisable(true);
        c02.setDisable(true);
        c10.setDisable(true);
        c11.setDisable(true);
        c12.setDisable(true);
        c20.setDisable(true);
        c21.setDisable(true);
        c22.setDisable(true);

        c00.setVisible(false);
        c01.setVisible(false);
        c02.setVisible(false);
        c10.setVisible(false);
        c11.setVisible(false);
        c12.setVisible(false);
        c20.setVisible(false);
        c21.setVisible(false);
        c22.setVisible(false);
    }

    public void disableRadioButtons() {
        K21.setDisable(true);
        K22.setDisable(true);
        K23.setDisable(true);
        K01.setDisable(true);
        K02.setDisable(true);
        K03.setDisable(true);
        K11.setDisable(true);
        K12.setDisable(true);
        K13.setDisable(true);
        K21.setVisible(false);
        K22.setVisible(false);
        K23.setVisible(false);
        K01.setVisible(false);
        K02.setVisible(false);
        K03.setVisible(false);
        K11.setVisible(false);
        K12.setVisible(false);
        K13.setVisible(false);
    }

    public void setButtonsOnAction() {
        c00.setOnAction(this::mouseActionButtonC00);
        c01.setOnAction(this::mouseActionButtonC01);
        c02.setOnAction(this::mouseActionButtonC02);
        c10.setOnAction(this::mouseActionButtonC10);
        c11.setOnAction(this::mouseActionButtonC11);
        c12.setOnAction(this::mouseActionButtonC12);
        c20.setOnAction(this::mouseActionButtonC20);
        c21.setOnAction(this::mouseActionButtonC21);
        c22.setOnAction(this::mouseActionButtonC22);
        K00.setOnAction(this::player1);
        K10.setOnAction(this::player2);
        K20.setOnAction(this::comp);
        K21.setOnAction(this::signHash);
        K22.setOnAction(this::signAt);
        K23.setOnAction(this::signH);
        K01.setOnAction(this::signX);
        K02.setOnAction(this::signO);
        K03.setOnAction(this::signT);
        K11.setOnAction(this::signPlus);
        K12.setOnAction(this::signQ);
        K13.setOnAction(this::signV);
        anchorPaneOuter.setOnMouseClicked(this::clickByMistake);
        anchorPaneInner.setOnMouseClicked(this::clickByMistake);

   

    }
    
    private void clearGame(){
        enableGameButtonCells();
        ImageView00 = new ImageView();
        ImageView00.setFitHeight(50);
        ImageView00.setFitWidth(50);
        c00.setGraphic(ImageView00);

        ImageView01 = new ImageView();
        ImageView01.setFitHeight(50);
        ImageView01.setFitWidth(50);
        c01.setGraphic(ImageView01);
        
        ImageView02 = new ImageView();
        ImageView02.setFitHeight(50);
        ImageView02.setFitWidth(50);
        c02.setGraphic(ImageView02);
        
        ImageView10 = new ImageView();
        ImageView10.setFitHeight(50);
        ImageView10.setFitWidth(50);
        c10.setGraphic(ImageView10);
        
        ImageView11 = new ImageView();
        ImageView11.setFitHeight(50);
        ImageView11.setFitWidth(50);
        c11.setGraphic(ImageView11);
        
        ImageView12 = new ImageView();
        ImageView12.setFitHeight(50);
        ImageView12.setFitWidth(50);
        c12.setGraphic(ImageView12);
        
        ImageView20 = new ImageView();
        ImageView20.setFitHeight(50);
        ImageView20.setFitWidth(50);
        c20.setGraphic(ImageView20);
        
        ImageView21 = new ImageView();
        ImageView21.setFitHeight(50);
        ImageView21.setFitWidth(50);
        c21.setGraphic(ImageView21);
        
        ImageView22 = new ImageView();
        ImageView22.setFitHeight(50);
        ImageView22.setFitWidth(50);
        c22.setGraphic(ImageView22);
        gridPaneLabelStats.getChildren().clear();
        labelGameStats = new Label();
        labelGameStats.prefWidth(340);
        labelGameStats.textFillProperty().setValue(YELLOW);
        labelGameStats.setText("");
        gridPaneLabelStats.add(labelGameStats, 0, 0);
       // Font K = new Font("Georgia",15);
       
       model.addNtoCellsStatePlayersArray();
        if(label20.getText()=="First move"){
            model.comp.setPlayerQueue(PlayerQueue.FIRST.toString());
            if(model.checkNullGroupPlayer1Signs()==false){
                model.player1.setPlayerQueue(PlayerQueue.SECOND.toString()); 
            }
            if(model.checkNullGroupPlayer2Signs()== false){
                model.player2.setPlayerQueue(PlayerQueue.SECOND.toString());
            }
            }
        else if(label00.getText()=="First move"){
             model.player1.setPlayerQueue(PlayerQueue.FIRST.toString()); 
             if(model.checkNullGroupCompSigns() == false){
                  model.comp.setPlayerQueue(PlayerQueue.SECOND.toString());
             }
             if(model.checkNullGroupPlayer2Signs()== false){
                model.player2.setPlayerQueue(PlayerQueue.SECOND.toString());
             }
         }
        else if(label10.getText()=="First move"){
             model.player2.setPlayerQueue(PlayerQueue.FIRST.toString()); 
             if(model.checkNullGroupCompSigns() == false){
                model.comp.setPlayerQueue(PlayerQueue.SECOND.toString());
             }
             if(model.checkNullGroupPlayer1Signs()== false){
                  model.player1.setPlayerQueue(PlayerQueue.SECOND.toString()); 
             }
         }
         
       
                           if(model.comp.getPlayerQueue() == PlayerQueue.FIRST.toString() && model.checkNullGroupCompSigns() == false){
                    startButtonComp();
                }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        model.player1 = new Player();
        model.player2 = new Player();
        model.comp = new Player();

        model = new Model();
        //model.addNtoPlayersArray();

        disableRadioButtons();
        disableGameButtonCells();
        model.player1.setPlayerTurn(PlayerTurn.N.toString());
        model.player2.setPlayerTurn(PlayerTurn.N.toString());
        model.comp.setPlayerTurn(PlayerTurn.N.toString());
        model.player1.setPlayerName(PlayerName.N.toString());
        model.player2.setPlayerName(PlayerName.N.toString());
        model.comp.setPlayerName(PlayerName.N.toString());
        model.player1.setPlayerState(PlayerState.OUT_GAME.toString());
        model.player2.setPlayerState(PlayerState.OUT_GAME.toString());
        model.comp.setPlayerState(PlayerState.OUT_GAME.toString());
        model.player1.setPlayerSign(PlayerSign.N.toString());
        model.player2.setPlayerSign(PlayerSign.N.toString());
        model.comp.setPlayerSign(PlayerSign.N.toString());
        setButtonsOnAction();

        /**
 *
 * @author Jacek Byzdra
 * email: jacekbwwa@gmail.com
 */
    }

}
