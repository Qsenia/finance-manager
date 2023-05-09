package financeManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

import static financeManager.ServerConfig.HOST;
import static financeManager.ServerConfig.PORT;

public class FinancesManager {

    public static void main(String[] args) {

        try (Socket socket = new Socket(HOST, PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            //общение с клиентом в консоли
            ArrayList<Categories> list = Basket.createBasket();
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .registerTypeAdapter(Categories.class, new CategoriesSerializer())
                    .create();
            var json = gson.toJson(list);
            out.println(json);//записываем
            String result = in.readLine();//считываем
            System.out.println(result);

        } catch (UnknownHostException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}