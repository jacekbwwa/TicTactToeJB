
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Jacek Byzdra
 * email: jacekbwwa@gmail.com
 */
public class Main extends Application {
    
   Parent root;
  //private Stage stage1;
  protected Stage primaryStage;
  protected Stage stage;
  protected AnchorPane anchorPaneOuter;
  protected FXML1Controller fxml1Controller;
  FXMLLoader loader;
  Scene scene;
  Model model;

    

    @Override
    public void start(Stage primaryStage) throws Exception {
      startGame(primaryStage);
        
       
    }
    

    public void cleanup(){
        model = new Model();
    }
    
    public void restart(Stage stage){
        cleanup();
        startGame(stage);
   }
    
    public void startGame(Stage stage){
        try{
         loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("FXML1.fxml"));
            anchorPaneOuter = (AnchorPane) loader.load();
            scene = new Scene(anchorPaneOuter, 800, 600);
            stage.setScene(scene);
            fxml1Controller = loader.getController();
           fxml1Controller.setMainApp(this);
          fxml1Controller.restartButton.setOnAction(e -> {
            restart(stage);
              });

           
            stage.show();
        } catch (IOException e){
            System.out.println("RunTime IOexception");
        }
    }
    
        public static void Main (String args[]){
        launch(args);

          
    }
        
        
        
    
}
