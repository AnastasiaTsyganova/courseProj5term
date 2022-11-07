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
                    System.out.println(request);
                }).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
