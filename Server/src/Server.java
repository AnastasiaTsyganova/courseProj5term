import between.Phone;
import java.io.*;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8000);) {
            System.out.println("Запуск сервера");
            while (true) {
                Phone phone = new Phone(server);
                new Thread(() -> {
                    System.out.println("Клиент подключен");
                    String request = phone.readLine();
                    phone.writeLine("Вы подключились к серверу");
                   // System.out.println(request);
                    String log=phone.readLine();
                    String pas=phone.readLine();
                    DatabaseHandler dbHandler = new DatabaseHandler();
                    while (true) { //пока так
                        String cho = phone.readLine();
                        int choose = Integer.parseInt(cho);
                        switch (choose) {
                            case 1: {
                                int i = dbHandler.singInUser(1, log, pas);
                                phone.writeLine(String.valueOf(i));
                                if (i == 0) {
                                    //переход в меню роли админа
                                } else break;
                            }
                            case 2: {
                                int i = dbHandler.singInUser(2, log, pas);
                                phone.writeLine(String.valueOf(i));
                                if (i == 0) {
                                    //переход в меню роли заказчика
                                } else break;
                            }
                            case 3: {
                                int i = dbHandler.singInUser(3, log, pas);
                                phone.writeLine(String.valueOf(i));
                                if (i == 0) {
                                    //переход в меню роли снабженца
                                } else break;
                            }
                            case 4: {
                                System.out.println("Отключение клиента");
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
