import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try(
        ServerSocket server=new ServerSocket(8000);) {
            System.out.println("������ �������");
            while (true)
            try(  Socket socket = server.accept();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                System.out.println("������ ���������");
                String request = reader.readLine();
                System.out.println(request);
                writer.write("�� ������������ � �������");
                writer.newLine();
                writer.flush();
            }
            catch(NullPointerException e)
            {
                e.printStackTrace();
            }
        } catch(IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
