package Control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import BuildClasses.Application;
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

public class ShowApplicationUserController {

    private final ObservableList<Application> apps = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Application, String> SITable;

    @FXML
    private TableColumn<Application, Integer> countTable;

    @FXML
    private TableColumn<Application, Integer> idTable;

    @FXML
    private Label label;

    @FXML
    private TableColumn<Application, String> nameTable;

    @FXML
    private TableColumn<Application, String> repeatTable;

    @FXML
    private Button returnButton;

    @FXML
    private Label showMainText;

    @FXML
    private TableColumn<Application, String> statusTable;

    @FXML
    private TableView<Application> table;

    @FXML
    void initialize() {
        Phone.writeLine("вывод");
        String res = Phone.readLine();
        int count = Integer.parseInt(res);
        for (int i = 0; i < count; i++) {
            String id = Phone.readLine();
            int idApp = Integer.parseInt(id);
            String name = Phone.readLine();
            String num = Phone.readLine();
            int number=Integer.parseInt(num);
            String SI = Phone.readLine();
            String replay = Phone.readLine();
            String stat = Phone.readLine();
            int status = Integer.parseInt(stat);
            String idU = Phone.readLine();
            int idUser = Integer.parseInt(idU);
            String idW = Phone.readLine();
            int idWorker = Integer.parseInt(idW);
            String idS = Phone.readLine();
            int idSupplier = Integer.parseInt(idS);
            Application app=new Application(idApp, name, number, SI, replay, status, idUser, idWorker, idSupplier);
            apps.add(app);
        }
        idTable.setCellValueFactory(new PropertyValueFactory<Application, Integer>("idApp"));
        nameTable.setCellValueFactory(new PropertyValueFactory<Application, String>("name"));
        countTable.setCellValueFactory(new PropertyValueFactory<Application, Integer>("number"));
        SITable.setCellValueFactory(new PropertyValueFactory<Application, String>("SI"));
        repeatTable.setCellValueFactory(new PropertyValueFactory<Application, String>("replay"));
        statusTable.setCellValueFactory(new PropertyValueFactory<Application, String>("st"));
        table.setItems(apps);

        returnButton.setOnAction(event -> {
            returnButton.getScene().getWindow().hide();
            Phone.writeLine("возврат");
            // System.out.println("singUp возврат");
            openNewScene("/fx/usMenu.fxml");
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
