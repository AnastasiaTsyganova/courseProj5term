package Control;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ChangeUserPasswordController {

    private final ObservableList<User> users = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button changeButton;

    @FXML
    private Label changeMainText;

    @FXML
    private TableColumn<User, Integer> idTable;

    @FXML
    private Label label;

    @FXML
    private TableColumn<User, String> lastnameTable;

    @FXML
    private TableColumn<User, String> loginTable;

    @FXML
    private TextField loginTextField;

    @FXML
    private TableColumn<User, String> nameTable;

    @FXML
    private TableColumn<User, String> passwordTable;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Button returnButton;

    @FXML
    private TableColumn<User, String> roleTable;

    @FXML
    private Button searchButton;

    @FXML
    private TableView<User> table;

    int flag1=-1, id;

    @FXML
    void initialize() {
        searchButton.setOnAction(event -> {
        Phone.writeLine("поиск");
        String login = loginTextField.getText().trim();
        Phone.writeLine(login);

        String iu=Phone.readLine();
        int idUser = Integer.parseInt(iu);
        id=idUser;
        String nameUser=Phone.readLine();
        String lastnameUser=Phone.readLine();
        String loginUser=Phone.readLine();
        String passwordUser=Phone.readLine();
        String ru=Phone.readLine();
        int roleUser= Integer.parseInt(ru);
        String flag=Phone.readLine();
        flag1=Integer.parseInt(flag);
        if(flag1==0) {
            // User user=new User(idUser,nameUser, lastnameUser, loginUser, passwordUser, roleUser);
            users.add(new User(idUser,nameUser, lastnameUser, loginUser, passwordUser, roleUser));
            System.out.println(idUser + nameUser + lastnameUser + loginUser + passwordUser + roleUser);
            idTable.setCellValueFactory(new PropertyValueFactory<User, Integer>("idUser"));
            nameTable.setCellValueFactory(new PropertyValueFactory<User, String>("firstName"));
            lastnameTable.setCellValueFactory(new PropertyValueFactory<User, String>("lastName"));
            loginTable.setCellValueFactory(new PropertyValueFactory<User, String>("userName"));
            passwordTable.setCellValueFactory(new PropertyValueFactory<User, String>("password"));
            roleTable.setCellValueFactory(new PropertyValueFactory<User, String>("rl"));
            table.setItems(users);
        }
        else{
            searchButton.getScene().getWindow().hide();
            openNewScene("/fx/warningDelete.fxml");
        }
    });

        changeButton.setOnAction(event -> {
            changeButton.getScene().getWindow().hide();
            Phone.writeLine("изменение");
            if (flag1==0){
                String password = passwordTextField.getText().trim();
                Phone.writeLine(password);
                Phone.writeLine(String.valueOf(id));
                String res=Phone.readLine();
                if(Objects.equals(res, "1")){
                    System.out.println("изменено");
                    openNewScene("/fx/userManage.fxml");}
            }
            // System.out.println("singUp возврат");
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
