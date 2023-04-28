package financeManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class FinancesManager {

        public static void main(String[] args) {
            try (Socket socket = new Socket("localhost", 8989);
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in= new BufferedReader(new InputStreamReader(socket.getInputStream()))) {


            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }