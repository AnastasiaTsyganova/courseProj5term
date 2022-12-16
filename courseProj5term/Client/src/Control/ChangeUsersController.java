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

public class ChangeUsersController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button changeLastnameButton;

    @FXML
    private Label changeLastnameText;

    @FXML
    private Button changePasswordButton;

    @FXML
    private Label changePasswordText;

    @FXML
    private Label changeUserTypeText;

    @FXML
    private Label label;

    @FXML
    private Button returnButton;

    @FXML
    void initialize() {

        changeLastnameButton.setOnAction(event -> {
            changeLastnameButton.getScene().getWindow().hide();
            Phone.writeLine("фамилия");
            openNewScene("/fx/changeUserLastname.fxml");
        });

        changePasswordButton.setOnAction(event -> {
            changePasswordButton.getScene().getWindow().hide();
            Phone.writeLine("пароль");
            openNewScene("/fx/changeUserPassword.fxml");
        });

        returnButton.setOnAction(event -> {
            returnButton.getScene().getWindow().hide();
            Phone.writeLine("возврат");
            openNewScene("/fx/userManage.fxml");
        });
    }


    public void openNewScene(String window) {

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
