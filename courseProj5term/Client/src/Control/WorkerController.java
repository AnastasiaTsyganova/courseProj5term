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

public class WorkerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label currentText;

    @FXML
    private Label label;

    @FXML
    private Button processButton;

    @FXML
    private Label processedText;

    @FXML
    private Button ratingButton;

    @FXML
    private Label ratingText;

    @FXML
    private Button returnButton;

    @FXML
    private Button showButton;

    @FXML
    private Label userTypeText;

    @FXML
    void initialize() {
        processButton.setOnAction(event -> {
            processButton.getScene().getWindow().hide();
            Phone.writeLine("??????????");
            openNewScene("/fx/admMenu.fxml");
        });

        showButton.setOnAction(event -> {
            showButton.getScene().getWindow().hide();
            Phone.writeLine("????????????");
            openNewScene("/fx/admMenu.fxml");
        });

        ratingButton.setOnAction(event -> {
            ratingButton.getScene().getWindow().hide();
            Phone.writeLine("???????");
            openNewScene("/fx/admMenu.fxml");
        });

        returnButton.setOnAction(event -> {
            returnButton.getScene().getWindow().hide();
            Phone.writeLine("???????");
            openNewScene("/fx/Client.fxml");
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
