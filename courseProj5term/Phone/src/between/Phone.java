package between;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Phone implements Closeable{
    private final Socket socket;
    private static BufferedReader reader;
    private static BufferedWriter writer;

    public Phone(String ip, int port)
    {
        try{
            this.socket=new Socket(ip, port);
            reader=createReader();
            writer=createWriter();
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    public Phone(ServerSocket server)
    {
        try{
            this.socket=server.accept();
            reader=createReader();
            writer=createWriter();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static void writeLine(String message){
        try{
            writer.write(message);
            writer.newLine();
            writer.flush();
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    public static String readLine(){
        try{
            return reader.readLine();
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    private BufferedReader createReader() throws IOException{
        return new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    private BufferedWriter createWriter() throws IOException{
        return new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    @Override
    public void close() throws IOException {
        reader.close();
        writer.close();
        socket.close();
    }
}
