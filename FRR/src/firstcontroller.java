import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class firstcontroller {

    @FXML
    private Button bone;

    @FXML
    private Label lableone;

    @FXML
    private TextField tfone;

    public void click(ActionEvent e){
        System.out.println("clicked");
    }

    
}
