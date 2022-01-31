import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Detailscontroller implements Initializable{
    
@FXML
TableView<Food> table = new TableView<>();
@FXML
TableColumn<Food,String> column1;
@FXML
TableColumn<Food,Integer> column2;
@FXML
Label dlabel;

Stage stage;
Delta delta = new Delta();


SQLConnector sc= new SQLConnector("jdbc:mariadb://localhost:3306/food","root","S@S@K!");
ObservableList<Food> li= FXCollections.observableArrayList();


@Override
public void initialize(URL location, ResourceBundle resources){
    column1.setCellValueFactory(new PropertyValueFactory<Food,String>("ingre"));
    column2.setCellValueFactory(new PropertyValueFactory<Food,Integer>("quan"));
   
   
   try{


    sc.Connect();
    String[] s = sc.GetAllFood_Ingredient(Maincontroller.gen);
   
    Float[] in = sc.GetAllFood_Quantity(Maincontroller.gen);
 
    
    for(int i=0,j=0;i<s.length && j<in.length;i++,j++){
      // System.out.println(s[i]+" "+in[j]);
      li.add(new Food(s[i],in[j]));
    }
    dlabel.setText(Maincontroller.gen);
    table.setItems(li);



   }catch(Exception e){e.printStackTrace();}
    

    

    

    
} 

public void close(ActionEvent me){
  stage = (Stage)((Node)me.getSource()).getScene().getWindow();
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
