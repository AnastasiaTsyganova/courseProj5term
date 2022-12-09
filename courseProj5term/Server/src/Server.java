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
                    String request = Phone.readLine();
                    //Phone.writeLine("Вы подключились к серверу");
                   // System.out.println(request);
                    String log=Phone.readLine();
                    String pas=Phone.readLine();
                    String rl= Phone.readLine();
                   int role=Integer.parseInt(rl);
//                    System.out.println(log + "    " +"lalal");
//                    System.out.println("dddd" +  rl);
                    DatabaseHandler dbHandler = new DatabaseHandler();
                    int i = dbHandler.singInUser(role, log, pas);
                    Phone.writeLine(String.valueOf(i));
                   /* while (true) { //пока так
//                        String cho = phone.readLine();
                        int choose = Integer.parseInt(role);
                        switch (choose) {
                            case 1: {
                                if (i == 0) {
                                    //переход в меню роли админа
                                } else break;
                            }
                            case 2: {

                                if (i == 0) {
                                    //переход в меню роли заказчика
                                } else break;
                            }
                            case 3: {

                                if (i == 0) {
                                    //переход в меню роли снабженца
                                } else break;
                            }
                            case 4: {
                                System.out.println("Отключение клиента");
                            }
                        }
                    }*/
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
