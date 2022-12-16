package Control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import BuildClasses.User;
import between.Phone;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ShowUserController {

    private final ObservableList<User> users = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label applicationMainText;

    @FXML
    private TableColumn<User, Integer> idTable;

    @FXML
    private Label label;

    @FXML
    private TableColumn<User, String> lastnameTable;

    @FXML
    private TableColumn<User, String> loginTable;

    @FXML
    private TableColumn<User, String> nameTable;

    @FXML
    private TableColumn<User, String> passwordTable;

    @FXML
    private Button returnButton;

    @FXML
    private TableColumn<User, String> roleTable;

    @FXML
    private TableView<User> table;

    int flag1 = -1, id;

    @FXML
    void initialize() {
        Phone.writeLine("вывод");
        String res = Phone.readLine();
        int count = Integer.parseInt(res);
        for (int i = 0; i < count; i++) {
            String id = Phone.readLine();
            int idUser = Integer.parseInt(id);
            String name = Phone.readLine();
            String lastname = Phone.readLine();
            String login = Phone.readLine();
            String password = Phone.readLine();
            String rl = Phone.readLine();
            int role = Integer.parseInt(rl);
            User user = new User(idUser, name, lastname, login, password, role);
            users.add(user);
        }
        idTable.setCellValueFactory(new PropertyValueFactory<User, Integer>("idUser"));
        nameTable.setCellValueFactory(new PropertyValueFactory<User, String>("firstName"));
        lastnameTable.setCellValueFactory(new PropertyValueFactory<User, String>("lastName"));
        loginTable.setCellValueFactory(new PropertyValueFactory<User, String>("userName"));
        passwordTable.setCellValueFactory(new PropertyValueFactory<User, String>("password"));
        roleTable.setCellValueFactory(new PropertyValueFactory<User, String>("rl"));
        table.setItems(users);

        returnButton.setOnAction(event -> {
            returnButton.getScene().getWindow().hide();
            Phone.writeLine("возврат");
            // System.out.println("singUp возврат");
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
