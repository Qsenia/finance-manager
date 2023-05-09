package financeManager;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class CategoriesSerializer implements JsonSerializer<Categories> {
    //Хотела пойти другим путем , создала Класс для сериализации объектов
    //  передумала, теперь жалко удалять
    @Override
    public JsonElement serialize(Categories src, Type typeOfSrc, JsonSerializationContext context) {

        JsonObject result = new JsonObject();
        //заносим в объект данные примитивных типов
        result.addProperty("Название", src.getTitle());
        //передаем в метод 2 параметра название и значение
        result.addProperty("Дата", src.getDate());
        result.addProperty("Сумма", src.getSum());
        return result;
    }
}
