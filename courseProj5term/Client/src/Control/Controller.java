package Control;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import between.Phone;
import com.mysql.cj.xdevapi.Client;
import com.mysql.cj.xdevapi.Session;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Controller {
    private int role = 0;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private RadioButton admType;

    @FXML
    private Button authSignButton;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField pass_field;

    @FXML
    private RadioButton usType;

    @FXML
    private RadioButton workType;

        ToggleGroup group = new ToggleGroup();
    @FXML
    void initialize() {
        admType.setToggleGroup(group);
        usType.setToggleGroup(group);
        workType.setToggleGroup(group);
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle){
                // получаем выбранный элемент RadioButton
                RadioButton selection = admType;
                selection = (RadioButton) group.getSelectedToggle();
                // RadioButton selection = (RadioButton) group.getSelectedToggle();
                if(selection!=null) {
                    String selectedLbl = selection.getText();
                    if (Objects.equals(selectedLbl, "Администратор")) {
                        role = 1;
                        System.out.println(selectedLbl + ", " + role);
                    } else if (Objects.equals(selectedLbl, "Заказчик")) {
                        role = 2;
                        System.out.println(selectedLbl + ", " + role);
                    } else if (Objects.equals(selectedLbl, "Снабженец")) {
                        role = 3;
                        System.out.println(selectedLbl + ", " + role);
                    }
                }
            };
        });
        authSignButton.setOnAction(event -> {
            authSignButton.getScene().getWindow().hide();
            int flag = 0;
            while (flag != 1) {
                String loginText = login_field.getText().trim();
                String passwordText = pass_field.getText().trim();
               // group();
                if (!loginText.equals("") && !passwordText.equals("")) {
                    flag = 1;
                    Phone.writeLine(loginText);
                    Phone.writeLine(passwordText);
                    Phone.writeLine(Integer.toString(role));
                    String rez=Phone.readLine();
                    int res=Integer.parseInt(rez);
                    if(res==0)
                    {
                        Phone.writeLine("вход");
                        if (role == 1) {
                            openNewScene("/fx/admMenu.fxml");
                        } else if (role == 2) {
                            openNewScene("/fx/usMenu.fxml");
                        } else if (role == 3) {
                            openNewScene("/fx/workMenu.fxml");
                        }
                    }
                    else if(res==1)
                    {
                        openNewScene("/fx/warningSingIn.fxml");
                    }
                }
            }
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


    @FXML
    void group(){
     //   System.out.println("00");
//        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
//            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle){
//
//                System.out.println("11");
//                // получаем выбранный элемент RadioButton
//                RadioButton selection = admType;
//                    selection = (RadioButton) group.getSelectedToggle();
//               // RadioButton selection = (RadioButton) group.getSelectedToggle();
//                if(selection!=null) {
//                    System.out.println("22");
//                    String selectedLbl = selection.getText();
//                    if (Objects.equals(selectedLbl, "Администратор")) {
//                        role = 1;
//                        System.out.println(selectedLbl + ", " + role);
//                    } else if (Objects.equals(selectedLbl, "Заказчик")) {
//                        role = 2;
//                        System.out.println(selectedLbl + ", " + role);
//                    } else if (Objects.equals(selectedLbl, "Снабженец")) {
//                        role = 3;
//                        System.out.println(selectedLbl + ", " + role);
//                    }
//                }
//            };
//        });
    }




}
