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
//            System.out.println("Подключение с сервером установлено");
//            Scanner in = new Scanner(System.in);
            int choice=0;
            String request = "Клиееееент";
            Phone.writeLine(request);
            launch();
            //подумать над кнопкой выхода
           // while (true) {
                //здесь должна быть считка логина и пароля
//                phone.writeLine(loginText);
//                phone.writeLine(passwordText);
//                phone.writeLine(Integer.toString(role));
//                String choose=phone.readLine();
//                role=Integer.parseInt(choose);
          //  }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

                /*
                //можно сделать через выбор с точкой
                System.out.println("1.Администратор\n2.Заказчик\n3.Снабженец\n4.Выход");
                int choose = in.nextInt();
                phone.writeLine(String.valueOf(choose));
                switch (choose) { //большой ролевой свитч
                    case 1: {
                        String res = phone.readLine();
                        int result = Integer.parseInt(res);
                        if (result == 1) {
                            //переход в меню админа
                        } else {
                            //повторный ввод
                            System.out.println("Ошибка ввода");
                            break;
                        }
                    }
                    case 2: {
                        String res = phone.readLine();
                        int result = Integer.parseInt(res);
                        if (result == 1) {
                            //переход в меню заказчика
                        } else {
                            //повторный ввод
                            System.out.println("Ошибка ввода");
                            break;
                        }
                    }
                    case 3: {
                        String res = phone.readLine();
                        int result = Integer.parseInt(res);
                        if (result == 1) {
                            //переход в меню снабженца
                        } else {
                            //повторный ввод
                            System.out.println("Ошибка ввода");
                            break;
                        }
                    }
                    case 4: {
                        System.out.println("Хорошего дня");
                        return;
                    }
                }*/

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

    public void singIn(String log, String pas)
    {

    }

}
