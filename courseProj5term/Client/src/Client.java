//вход
//админ-пользователь - регистрация, удаление, вывод, изменение фамилии+пароля     DONE
//админ-поставщик - (регистрация, удаление, вывод, изменение)
//админ-заказы - (по статусу, по поставщику)

//пользователь - добавить(проверка на ввод числа), просмотр, (оценка)
//снабженец - (актуальные, обработанные, оценка)

import Control.Controller;
import between.Phone;
import java.io.*;
import java.net.URL;
import java.util.Scanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Client extends Application {
    private static Scene scene;
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("/fx/Client"));
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Client.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) throws IOException {
        try (Phone phone = new Phone("127.0.0.1", 8000))
        {
            int choice=0;
//            String request = "Клиееееент";
//            Phone.writeLine(request);
            launch();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void singUp(int choose)
    {
       /* System.out.println("Для регистрации необходимо заполнить форму");
        System.out.println("Имя: ");
        String name = in.nextLine();
        System.out.println("Фамилия: ");
        String surname = in.nextLine();
        System.out.println("Логин: ");
        String login = in.nextLine();
        System.out.println("Пароль: ");
        String pass = in.nextLine();
        phone.writeLine(name);
        phone.writeLine(surname);
        phone.writeLine(login);
        phone.writeLine(pass);*/
    }

}
