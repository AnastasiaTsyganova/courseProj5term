package Control;
import java.net.URL;
import java.util.ResourceBundle;

import between.Phone;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AdminController {

    private Phone phone;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label adminTypeText;

    @FXML
    private Label label;

    @FXML
    void initialize() {
        assert adminTypeText != null : "fx:id=\"adminTypeText\" was not injected: check your FXML file 'admMenu.fxml'.";
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'admMenu.fxml'.";

    }

    public void setPhone(Phone phone){
        this.phone=phone;
    }

    public Phone getPhone(){
        return phone;
    }
}

