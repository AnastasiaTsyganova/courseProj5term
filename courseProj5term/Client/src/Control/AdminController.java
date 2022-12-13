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

public class AdminController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label admTypeText;

    @FXML
    private Label label;

    @FXML
    private Button orderButton;

    @FXML
    private Label orderControl;

    @FXML
    private Button returnButton;

    @FXML
    private Button supplierButton;

    @FXML
    private Label supplierControl;

    @FXML
    private Label userControl;

    @FXML
    private Button usersButton;

    @FXML
    void initialize() {
        usersButton.setOnAction(event -> {
            usersButton.getScene().getWindow().hide();
            Phone.writeLine("пользователи");
            openNewScene("/fx/userManage.fxml");
        });

        supplierButton.setOnAction(event -> {
            supplierButton.getScene().getWindow().hide();
            Phone.writeLine("поставщики");
        });

        orderButton.setOnAction(event -> {
            orderButton.getScene().getWindow().hide();
            Phone.writeLine("заказы");
        });

        returnButton.setOnAction(event -> {
            returnButton.getScene().getWindow().hide();
            Phone.writeLine("возврат");
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
