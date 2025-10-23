package lessons.lesson12;

import java.util.*;

public class ForSolutions {

    public static void main(String[] args) {

        record Product(String name, String category, double price) {}

        // 1) Оставить только чётные и вывести их квадраты
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> evensSquared = new ArrayList<>();
        for (int n : numbers) {
            if (n % 2 == 0) {
                evensSquared.add(n * n);
            }
        }
        System.out.println("1) EvensSquared  = "  + evensSquared);

        // 2) Подсчитать строки длиннее 5 символов
        List<String> words = List.of("apple", "banana", "pear", "pineapple");
        long cnt = 0;
        for (String word : words) {
            if (word.length() > 5) cnt++;
        }
        System.out.println("2) count length > 5 = " + cnt);

        // 3) Найти максимальное и минимальное число
        List<Integer> nums = List.of(10, 2, 33, 4, 25);
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int n : nums) {
            if (n < min) min = n;
            if (n > max) max = n;
        }
        System.out.println("3) min = " + min + ", max = " + max);

        // 4) Средняя длина строк
        List<String> names1 = List.of("Alice", "Bob", "Charlie", "David");
        int sumLen = 0;
        for (String s : names1) sumLen += s.length();
        double avgLen = (double) sumLen / names1.size();
        System.out.println("4) AvgLen = " + avgLen);

        // 5) Удалить дубликаты и отсортировать строки по длине
        List<String> input = List.of("apple", "pear", "apple", "banana", "pear");
        Set<String> seen = new HashSet<>();
        List<String> unique =  new ArrayList<>();
        for (String s : input) {
            if (seen.add(s)) unique.add(s);
        }
        unique.sort(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));
        System.out.println("5) unique = " + unique);

        // 6) Преобразовать список строк в Map: ключ -- строка, значение -- длина
        List<String> fruits = List.of("apple", "banana", "kiwi");
        Map<String, Integer> map = new HashMap<>();
        for (String s : fruits) {
            map.put(s, s.length());
        }
        System.out.println("6) map = " + map);

        // 7) Сгруппировать имена по первой букве
        List<String> names2 = List.of("Alice", "Andrew", "Bob", "Charlie", "Catherine");
        Map<Character, List<String>> grouped = new HashMap<>();
        for (String n : names2) {
            char key = n.charAt(0);
            grouped.computeIfAbsent(key, k -> new ArrayList<>()).add(n);
        }
        System.out.println("7) grouped = " + grouped);

        // 8) Собрать список имен в одну строку через запятую
        List<String> names3 = List.of("Tom", "Jerry", "Spike");
        StringJoiner sj = new StringJoiner(", ");
        for (String n : names3) sj.add(n);
        String joined = sj.toString();
        System.out.println("8) joined = " + joined);

        // 9) Из списка предложений получить список всех слов
        List<String> sentences = List.of("Java is cool", "Streams are powerful");
        List<String> allWords = new ArrayList<>();
        for (String sentence : sentences) {
            String[] parts =  sentence.split("\\s+");
            for (String w : parts) {
                if (!w.isEmpty()) allWords.add(w);
            }
        }
        System.out.println("9) AllWords = " + allWords);

        // 10) Самый дорогой продукт в каждой категории
        List<Product> products = List.of(
            new Product("Phone", "Electronics", 1200),
            new Product("TV", "Electronics", 1800),
            new Product("Apple", "Fruits", 2.5),
            new Product("Mango", "Fruits", 4.0)
        );

        Map<String, Product> mostExpensive = new HashMap<>();
        for (Product p : products) {
            Product cur = mostExpensive.get(p.category());
            if (cur == null || p.price() > cur.price()) {
                mostExpensive.put(p.category(), p);
            }
        }
        System.out.println("10) MostExpensive = " + mostExpensive);

    }
}