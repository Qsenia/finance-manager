import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import financeManager.Categories;
import financeManager.ServerConfig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Main {
    public static void main(String[] args) {

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
