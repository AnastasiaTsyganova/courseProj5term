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

public class SupplierManage {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addButton;

    @FXML
    private Label addText;

    @FXML
    private Button changeButton;

    @FXML
    private Label changeText;

    @FXML
    private Button deleteButton;

    @FXML
    private Label deleteText;

    @FXML
    private Label label;

    @FXML
    private Button returnButton;

    @FXML
    private Button showButton;

    @FXML
    private Label showText;

    @FXML
    private Label supplierTypeText;

    @FXML
    void initialize() {
        addButton.setOnAction(event -> {
            addButton.getScene().getWindow().hide();
            Phone.writeLine("регистрация");
            // System.out.println("регистрация");
            openNewScene("/fx/SingUp.fxml");
        });

        deleteButton.setOnAction(event -> {
            deleteButton.getScene().getWindow().hide();
            Phone.writeLine("удаление");
            openNewScene("/fx/SingUp.fxml");
        });

        changeButton.setOnAction(event -> {
            changeButton.getScene().getWindow().hide();
            Phone.writeLine("изменение");
            openNewScene("/fx/SingUp.fxml");
        });

        showButton.setOnAction(event -> {
            showButton.getScene().getWindow().hide();
            Phone.writeLine("просмотр");
            openNewScene("/fx/SingUp.fxml");
        });
        returnButton.setOnAction(event -> {
            returnButton.getScene().getWindow().hide();
            Phone.writeLine("возврат");
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
