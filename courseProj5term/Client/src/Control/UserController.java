package Control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

import between.Phone;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;


    public class UserController {

        public static int count;

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private Button addButton;

        @FXML
        private Label addText;

        @FXML
        private Label label;

        @FXML
        private Button ratingButton;

        @FXML
        private Button returnButton;

        @FXML
        private Button showButton;

        @FXML
        private Label showText;

        @FXML
        private Label ratingText;

        @FXML
        private Label userTypeText;

//        @FXML
//        public Label notice;
//
//        @FXML
//        private Button check;


    @FXML
    void initialize() {
//        check.setOnAction(event -> {
//            check.getScene().getWindow().hide();
//            Phone.writeLine("проверить");
//            String cnt=Phone.readLine();
//            count = Integer.parseInt(cnt);
//            if(count==0){
//                notice.setText("У вас нет новых обработанных заявок");
//            }
//            if(count==1||count==21||count==31)
//            {
//                notice.setText("У вас 1 обработанная заявка");
//            }
//            if(count==2||count==3||count==4)
//            {
//                notice.setText("У вас "+count+" обработанные заявки");
//            }
//            if(count>=5&&count<=20||count>21&&count<=30||count>31&&count<=40)
//            {
//                notice.setText("У вас "+count+" обработанных заявок");
//            }
//        });

        AtomicReference<String> next = null;
        addButton.setOnAction(event -> {
            addButton.getScene().getWindow().hide();
            Phone.writeLine("добавить");
            openNewScene("/fx/application.fxml");
        });

        showButton.setOnAction(event -> {
            showButton.getScene().getWindow().hide();
            Phone.writeLine("показать");
            openNewScene("/fx/admMenu.fxml");
        });

        ratingButton.setOnAction(event -> {
            showButton.getScene().getWindow().hide();
            Phone.writeLine("оценить");
            openNewScene("/fx/admMenu.fxml");
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
