import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class newcontroller {
  @FXML private TextField ntx1,ntx2,ntx3;

    Stage stage ;
    SQLConnector sc = new SQLConnector("jdbc:mariadb://localhost:3306/food","root","S@S@K!");
    Food food;

    Delta delta = new Delta();
    
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

    public void next(ActionEvent e)throws Exception
    {
      sc.Connect();
      food = new Food(ntx1.getText(),ntx2.getText(),Float.valueOf(ntx3.getText()));
      sc.AddFoodToDatabase(food);
      ntx2.clear();
      ntx3.clear();
      
    }

    public void close(ActionEvent e){
      stage = (Stage)((Node)e.getSource()).getScene().getWindow();
      stage.close();
    }
}
