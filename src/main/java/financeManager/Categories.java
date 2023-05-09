package financeManager;

import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Categories {

    public static Categories loadFromJSON(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Categories.class);
    }

    protected String title;
    protected String date;
    protected int sum;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
    Calendar calendar = Calendar.getInstance();


    public Categories(String title, LocalDate date, int sum) {
        this.title = title;
        this.sum = sum;
        this.date = dateFormat.format(calendar.getTime());

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public int getSum() {
        return sum;
    }


    @Override
    public String toString() {
        return "Categories{" +
                "title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", sum=" + sum +
                '}';
    }

}

