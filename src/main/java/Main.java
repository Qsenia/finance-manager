import financeManager.DataProcess;
import financeManager.ServerConfig;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        DataProcess dataProcess = new DataProcess(new File("categories.tsv"));
        try (ServerSocket serverSocket = new ServerSocket(ServerConfig.PORT)) { // стартуем сервер один(!) раз
            System.out.println("Сервер запущен!");

            while (true) { // в цикле(!) принимаем подключения
                try (
                        Socket socket = serverSocket.accept();
                        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    String jsonClient = in.readLine();//считываем
                    out.println(jsonClient);//записываем

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер!");
            throw new RuntimeException(e);
        }
    }
}
