package connectserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectServer {

    public static void main(String[] args) throws IOException {
        Socket s = null;
        PrintStream ps = null;
        try {
            ServerSocket server = new ServerSocket(8030);
            //Ожидания присоединения клиента
            s = server.accept();
            ps = new PrintStream(s.getOutputStream());
            //Отправить сообщение 
            ps.println("Привет!");
            BufferedReader br
                    = new BufferedReader(
                            new InputStreamReader(s.getInputStream()));
            //Получить сообщение 
            String message = br.readLine();
            System.out.println("Сообщение от клиента: " + message);
        } catch (IOException e) {
            System.err.println("Ошибка: " + e);
        } finally {

            if (s != null) {
                // Разрыв соединения
                s.close();
            }
        }
    }
}
