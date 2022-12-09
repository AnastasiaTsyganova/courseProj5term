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
//            System.out.println("����������� � �������� �����������");
//            Scanner in = new Scanner(System.in);
            int choice=0;
            String request = "����������";
            Phone.writeLine(request);
            launch();
            //�������� ��� ������� ������
           // while (true) {
                //����� ������ ���� ������ ������ � ������
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
                //����� ������� ����� ����� � ������
                System.out.println("1.�������������\n2.��������\n3.���������\n4.�����");
                int choose = in.nextInt();
                phone.writeLine(String.valueOf(choose));
                switch (choose) { //������� ������� �����
                    case 1: {
                        String res = phone.readLine();
                        int result = Integer.parseInt(res);
                        if (result == 1) {
                            //������� � ���� ������
                        } else {
                            //��������� ����
                            System.out.println("������ �����");
                            break;
                        }
                    }
                    case 2: {
                        String res = phone.readLine();
                        int result = Integer.parseInt(res);
                        if (result == 1) {
                            //������� � ���� ���������
                        } else {
                            //��������� ����
                            System.out.println("������ �����");
                            break;
                        }
                    }
                    case 3: {
                        String res = phone.readLine();
                        int result = Integer.parseInt(res);
                        if (result == 1) {
                            //������� � ���� ���������
                        } else {
                            //��������� ����
                            System.out.println("������ �����");
                            break;
                        }
                    }
                    case 4: {
                        System.out.println("�������� ���");
                        return;
                    }
                }*/

    }

    public void singUp(int choose)
    {
       /* System.out.println("��� ����������� ���������� ��������� �����");
        System.out.println("���: ");
        String name = in.nextLine();
        System.out.println("�������: ");
        String surname = in.nextLine();
        System.out.println("�����: ");
        String login = in.nextLine();
        System.out.println("������: ");
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
