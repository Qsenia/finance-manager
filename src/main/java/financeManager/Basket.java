package financeManager;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Basket {
    //создаем корзину случайных покупок
    public static ArrayList<Categories> createBasket() {
        List<String> titles = Arrays.asList("булка", "колбаса", "сухарики", "курица", "тапки", "шапка", "мыло", "акции", "гвозди");
        List<Integer> sums = Arrays.asList(100, 200, 300, 400, 500, 600, 700, 800);
        ArrayList<Categories> categoriesList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            categoriesList.add(new Categories(
                    titles.get(new Random().nextInt(titles.size())),
                    String.valueOf(LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 5))))),
                    sums.get(new Random().nextInt(sums.size()))));
        }
        System.out.println("В вашей корзине:");
        System.out.println(categoriesList);
        return categoriesList;
    }
}