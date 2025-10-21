package lessons.lesson3;

import java.util.ArrayList;
import java.util.List;

public class OnlineStore {
    private String code;
    private String name;
    private double price;
    private int count;

    private static List<OnlineStore> products = new ArrayList<>();

    public OnlineStore (String code, String name, double price, int count) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public static void addProduct(OnlineStore product) {
        products.add(product);
        System.out.println("Товар добавлен: " + product.name);
    }

    public void buyProduct(int amount) {
        if (amount <= count) {
            count -= amount;
            System.out.println("Куплено " + amount + " шт. товара " + name);
        } else {
            System.out.println("Недостаточно товара на складе!");
        }
    }
    public void getProductInfo() {
        System.out.println("Код: " + code +
            ", Название: " + name +
            ", Цена: " + price +
            ", Количество: " + count);
    }
    public static void getProducts() {
        for (OnlineStore product : products) {
            product.getProductInfo();
        }
    }
}
