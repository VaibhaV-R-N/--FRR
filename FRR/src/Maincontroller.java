import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Maincontroller {

    @FXML
    private Button newb,removeb,exitb,minb;

    @FXML
    public Label mlabel;


    public static String gen ;
    Stage stage;
    Random ran = new Random();
    Delta delta = new Delta();
    SQLConnector sc = new SQLConnector("jdbc:mariadb://localhost:3306/food","root","S@S@K!");
    Detailscontroller dc = new Detailscontroller();
    
    Thread thread;
    
    
    public String variable(Label l){
        return l.getText();

    }

    public void generate(ActionEvent e)throws Exception{
        thread = new Thread(() -> {
            try {
                changecolor();
            } catch (Exception e1) {
                
                e1.printStackTrace();
            }
        });
        sc.Connect();
        String[] ara = sc.GetAllTables();
        gen =ara[ran.nextInt(ara.length)];

      
        mlabel.setText(gen);
        
        // mlabel1.setText(gen);
        // mlabel11.setText(gen);
        // mlabel12.setText(gen);
        thread.start();
        
        
                
    }

    public void foodlabel()throws Exception{
        if(mlabel.getText()!=""){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fx/Details.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            scene.getStylesheets().add("css/Details-style.css");
            scene.setFill(Color.TRANSPARENT);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();

        }

    }

    public void changecolor() throws Exception{
        
       while(true){
        mlabel.setStyle("-fx-text-fill:red");
        // mlabel1.setStyle("-fx-text-fill:red");
        // mlabel11.setStyle("-fx-text-fill:red");
        // mlabel12.setStyle("-fx-text-fill:red");
        
        Thread.sleep(2000);
        mlabel.setStyle("-fx-text-fill:blue");
        // mlabel1.setStyle("-fx-text-fill:blue");
        // mlabel11.setStyle("-fx-text-fill:blue");
        // mlabel12.setStyle("-fx-text-fill:blue");
        Thread.sleep(2000);
        mlabel.setStyle("-fx-text-fill:green");
        // mlabel1.setStyle("-fx-text-fill:green");
        // mlabel11.setStyle("-fx-text-fill:green");
        // mlabel12.setStyle("-fx-text-fill:green");
        Thread.sleep(2000);
        mlabel.setStyle("-fx-text-fill:yellow");
        // mlabel1.setStyle("-fx-text-fill:yellow");
        // mlabel11.setStyle("-fx-text-fill:yellow");
        // mlabel12.setStyle("-fx-text-fill:yellow");
        Thread.sleep(2000);
       }
    }
    public void newbc() throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fx/Add.fxml"));
        stage = new Stage();
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("css/Add-style.css");
        scene.setFill(Color.TRANSPARENT);
        

        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();


      

    }

    public void removebc() throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fx/Remove.fxml"));
        stage = new Stage();
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("css/Remove-style.css");
        scene.setFill(Color.TRANSPARENT);
        

        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    public void exit(ActionEvent event)
    {
       System.exit(0);
    }

    public void minimize(ActionEvent e){
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    public void panepressed(MouseEvent me)

    {

     stage = (Stage)((Node)me.getSource()).getScene().getWindow();

     delta.x= stage.getX()- me.getScreenX();

     delta.y= stage.getY()- me.getScreenY();





    }

    public void panedraged(MouseEvent me)

    {

        stage = (Stage)((Node)me.getSource()).getScene().getWindow();

      stage.setX(delta.x+me.getScreenX());

        stage.setY(delta.y+me.getScreenY());
        
    }

   


}

