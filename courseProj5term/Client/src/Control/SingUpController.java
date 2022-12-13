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

public class SingUpController {

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
    private TextField lastNameTextField;

    @FXML
    private TextField loginTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Button returnButton;

    @FXML
    private ChoiceBox<String> roleChoiceBox;

    private final String[] role={"Администратор", "Заказчик", "Снабженец"};

    @FXML
    void initialize() {
        roleChoiceBox.getItems().addAll(role);
        addButton.setOnAction(event -> {
            addButton.getScene().getWindow().hide();
            String name = nameTextField.getText().trim();
            Phone.writeLine("добавление");
            System.out.println("singUp добавление");
            Phone.writeLine(name);
            String lastname = lastNameTextField.getText().trim();
            Phone.writeLine(lastname);
            String login = loginTextField.getText().trim();
            Phone.writeLine(login);
            String password = passwordTextField.getText().trim();
            Phone.writeLine(password);
            String role=roleChoiceBox.getValue();
            Phone.writeLine(role);
            String res=Phone.readLine();
            int result=Integer.parseInt(res);
            if(result==1) {openNewScene("/fx/addUser.fxml");
                System.out.println("добавлено");}
            else {openNewScene("/fx/warningSingUp.fxml");
                System.out.println("ошибка ввода");}
        });

        returnButton.setOnAction(event -> {
            returnButton.getScene().getWindow().hide();
            Phone.writeLine("возврат");
           // System.out.println("singUp возврат");
            openNewScene("/fx/userManage.fxml");
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
