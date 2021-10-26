import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * App
 */
public class App extends Application{

    
    @Override
    public void start(Stage pstage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fx/first.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        pstage.setTitle("FRR");
        pstage.setScene(scene);
        pstage.setResizable(false);
        pstage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
        
    }
}