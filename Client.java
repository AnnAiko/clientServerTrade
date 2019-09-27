package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        PrintStream ps = null;
        Socket socket = null;
        try {
            socket = new Socket("localhost", 8030);
            BufferedReader br
                    = new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
            ps = new PrintStream(socket.getOutputStream());
            //Отправить сообщение серверу
            ps.println("Сервер привет, ответь!!!");
            //Получить сообщение от сервера
            String msg = br.readLine();
            System.out.println("Сообщение от сервера: " + msg);
        } catch (IOException e) {
            System.err.println("Ошибка: " + e);

        } finally {

            if (socket != null) {
                // Разрыв соединения
                socket.close();
            }
        }
    }

}
