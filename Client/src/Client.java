import between.Phone;
import java.io.*;

public class Client {
    public static void main(String[] args) {
        try (Phone phone = new Phone("127.0.0.1", 8000))
        {
            System.out.println("Подключение с сервером установлено");
            String request = "Клиееееент";
            phone.writeLine(request);

            String response =phone.readLine();
            System.out.println(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
