import between.Phone;
import java.io.*;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8000);) {
            System.out.println("������ �������");
            while (true) {
                Phone phone = new Phone(server);
                new Thread(() -> {
                    System.out.println("������ ���������");
                    String request = phone.readLine();
                    phone.writeLine("�� ������������ � �������");
                   // System.out.println(request);
                    String log=phone.readLine();
                    String pas=phone.readLine();
                    DatabaseHandler dbHandler = new DatabaseHandler();
                    while (true) { //���� ���
                        String cho = phone.readLine();
                        int choose = Integer.parseInt(cho);
                        switch (choose) {
                            case 1: {
                                int i = dbHandler.singInUser(1, log, pas);
                                phone.writeLine(String.valueOf(i));
                                if (i == 0) {
                                    //������� � ���� ���� ������
                                } else break;
                            }
                            case 2: {
                                int i = dbHandler.singInUser(2, log, pas);
                                phone.writeLine(String.valueOf(i));
                                if (i == 0) {
                                    //������� � ���� ���� ���������
                                } else break;
                            }
                            case 3: {
                                int i = dbHandler.singInUser(3, log, pas);
                                phone.writeLine(String.valueOf(i));
                                if (i == 0) {
                                    //������� � ���� ���� ���������
                                } else break;
                            }
                            case 4: {
                                System.out.println("���������� �������");
                            }
                        }
                    }
                }).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void singUp()
    {
        /*String name = phone.readLine();
                            String surname = phone.readLine();
                            String login = phone.readLine();
                            String pass = phone.readLine();
                            System.out.println(name +", "+surname+", "+login+", "+pass);
                           // DatabaseHandler dbHandler = new DatabaseHandler();
                            dbHandler.singUpUser(name, surname, login, pass);*/
    }
}
