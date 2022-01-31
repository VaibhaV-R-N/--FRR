import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class App extends Application{

    
    @Override
    public void start(Stage pstage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fx/Main.fxml"));
        Parent root = loader.load();
        
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        scene.getStylesheets().add("css/style.css");
       
        pstage.setTitle("FRR");
        pstage.setScene(scene);
        pstage.initStyle(StageStyle.TRANSPARENT);
        
        pstage.setResizable(false);
        pstage.setOnCloseRequest(WindowEvent ->System.exit(0));
        pstage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
        
    }
}