package Control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class WorkerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label label;

    @FXML
    private Label workerTypeText;

    @FXML
    void initialize() {
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'workMenu.fxml'.";
        assert workerTypeText != null : "fx:id=\"workerTypeText\" was not injected: check your FXML file 'workMenu.fxml'.";

    }

}