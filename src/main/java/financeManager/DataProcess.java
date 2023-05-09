package financeManager;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataProcess {
    public static Map<String, String> categoriesLoad = new HashMap<>();
    public static Map<String, List<Categories>> listMap = new HashMap<>();
    public DataProcess(File tsvFile) {
        //File file = new File("categories.tsv");
        try (BufferedReader reader = new BufferedReader(new FileReader(tsvFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                categoriesLoad.put(parts[0], parts[1]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
        //return categoriesLoad;

        public String identifyCategory(String title){
        return categoriesLoad.getOrDefault(title, "other");

    }

        public void setProduct (String product){
        Categories categories = Categories.loadFromJSON(product);
        String category = identifyCategory(categories.getTitle());
        List<Categories> categoriesList = new ArrayList<>();
        listMap.put(category, categoriesList);
    }


    }



