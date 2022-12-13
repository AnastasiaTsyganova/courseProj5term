package Control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import between.Phone;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddUserController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label Text1;

    @FXML
    private Label label;

    @FXML
    private Button returnButton;

    @FXML
    void initialize() {
        returnButton.setOnAction(event -> {
            returnButton.getScene().getWindow().hide();
           // Phone.writeLine("возврат");
            openNewScene("/fx/admMenu.fxml");
        });
    }

    public void openNewScene(String window)
    {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

}
