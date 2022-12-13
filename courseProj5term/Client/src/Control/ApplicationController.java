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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ApplicationController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addButton;

    @FXML
    private Label applicationMainText;

    @FXML
    private Label label;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField numberTextField;

    @FXML
    private ChoiceBox<String> repeatChoiceBox;
    @FXML
    private ChoiceBox<String> SIChoiceBox;

    private final String[] repeat={"Не повторять", "Каждый месяц", "Каждый год"};

    private final String[] SI={"Штука", "Килограмм", "Литр", "Метр"};

    @FXML
    private Button returnButton;

    @FXML
    void initialize() {
        SIChoiceBox.getItems().addAll(SI);
        repeatChoiceBox.getItems().addAll(repeat);
        addButton.setOnAction(event -> {
            addButton.getScene().getWindow().hide();
        String name = nameTextField.getText().trim();
            Phone.writeLine(name);
        String number = numberTextField.getText().trim();
            Phone.writeLine(number);
        String SIChoice=SIChoiceBox.getValue();
            Phone.writeLine(SIChoice);
        String repeatChoice = repeatChoiceBox.getValue();
            Phone.writeLine(repeatChoice);
            Phone.writeLine("добавить2");
            openNewScene("/fx/add.fxml");
        });

        returnButton.setOnAction(event -> {
            returnButton.getScene().getWindow().hide();
            Phone.writeLine("возврат");
            openNewScene("/fx/usMenu.fxml");
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

