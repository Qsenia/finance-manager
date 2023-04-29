package financeManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.net.Socket;

public class FinancesManager {

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8989);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in= new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            Categories categories=new Categories("булка","2022.02.08", 200);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(categories);//строковое представление объекта
            out.println(json);//записываем
            String result = in.readLine();
            System.out.println(result);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    }