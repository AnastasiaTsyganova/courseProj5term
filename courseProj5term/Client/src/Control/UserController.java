package Control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class UserController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label label;

    @FXML
    private Label userTypeText;

    @FXML
    void initialize() {
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'usMenu.fxml'.";
        assert userTypeText != null : "fx:id=\"userTypeText\" was not injected: check your FXML file 'usMenu.fxml'.";

    }

}

