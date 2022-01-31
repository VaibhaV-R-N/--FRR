import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class removecontroller {
    Stage stage = new Stage();
    Delta delta = new Delta();

    @FXML private TextField rtx1,rtx2;

    Food food;
    SQLConnector sc = new SQLConnector("jdbc:mariadb://localhost:3306/food","root","S@S@K!");
    





    public void remove() throws Exception{
      sc.Connect();

      if(rtx1.getText()!="" && rtx2.getText()==""){

        sc.DeleteFood(rtx1.getText());
        rtx1.clear();
      }
      else if(rtx1.getText()!="" && rtx2.getText()!=""){
        sc.DeleteFoodColumn(rtx1.getText(), rtx2.getText());
        rtx2.clear();
      }
      else{

      }

    }
    public void close(ActionEvent e){
      stage = (Stage)((Node)e.getSource()).getScene().getWindow();
      stage.close();
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
