package lessons.lesson12;

import java.util.function.*;
import java.util.stream.*;
import java.util.*;

public class StreamAPI {

    record Product (String name, String category, double price) {}

    public static void main (String[] args) {
        // 1) Оставить только чётные и вывести их квадраты
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> evensSquared = numbers.stream()
            .filter(n -> n % 2 == 0)
            .map(n -> n * n)
            .toList();
        System.out.println("1) " + evensSquared);

        // 2) Подсчитать строки длиннее 5 символов
        List<String> words = List.of("apple", "banana", "pear", "pineapple");
        long cnt = words.stream()
            .filter(w -> w.length() > 5)
            .count();
        System.out.println("2) count = " + cnt);

        // 3) Найти максимальное и минимальное число
        List<Integer> nums = List.of(10, 2, 33, 4, 26);
        IntSummaryStatistics stats = nums.stream().mapToInt(Integer::intValue).summaryStatistics();
        System.out.println("3) min = " + stats.getMin() + ", max = " + stats.getMax());

        // 4) Средняя длина строк
        List<String> names1 = List.of("Alice", "Bob", "Charlie", "David");
        double avgLen = names1.stream()
            .mapToInt(String::length)
            .average()
            .orElse(0.0);
        System.out.println("4) AvgLen = " + avgLen);

        // 5) Удалить дубликаты и отсортировать строки по длине
        List<String> input = List.of("apple", "pear", "apple", "banana", "pear");
        List<String> distinctSorted = input.stream()
            .distinct()
            .sorted(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()))
            .toList();
        System.out.println("5) distinct = " + distinctSorted);

        // 6) Преобразовать список строк в Map: Ключ -- строка, значение -- длина
        List<String> fruits = List.of("apple", "banana", "kiwi");
        Map<String, Integer> map = fruits.stream()
            .collect(Collectors.toMap(
                Function.identity(),
                String::length,
                (a, b) -> a,
                LinkedHashMap::new
            ));
        System.out.println("6) map = " + map);

        // 7) Сгруппировать имена по первой букве
        List<String> names2 = List.of("Alice", "Andrew", "Bob", "Charlie", "Catherine");
        Map<Character, List<String>> grouped = names2.stream()
            .collect(Collectors.groupingBy(s -> s.charAt(0)));
        System.out.println("7) grouped = " + grouped);

        // 8) Собрать список имен в одну строку через запятую
        List<String> names3 = List.of("Tom", "Jerry", "Spike");
        String joined = names3.stream().collect(Collectors.joining(", "));
        System.out.println("8) joined = " + joined);

        // 9) Из списка предложений получить список всех слов
        List<String> sentences = List.of("Java is cool", "Streams are powerful");
        List<String> allWords = sentences.stream()
            .flatMap(s -> Arrays.stream(s.split("\\s+")))
            .filter(w -> !w.isEmpty())
            .toList();
        System.out.println("9) allWords = " + allWords);

        // 10) Самый дорогой продукт в каждой категории
        List<Product> products = List.of(
            new Product("Phone", "Electronics", 1200),
            new Product("TV", "Electronics", 1800),
            new Product("Apple", "Fruits", 2.5),
            new Product("Mango", "Fruits", 4.0)
        );

        Map<String, Product> mostExpensive = products.stream()
            .collect(Collectors.toMap(
                Product::category,
                Function.identity(),
                BinaryOperator.maxBy(
                    Comparator.comparingDouble(Product::price)
                ),
                LinkedHashMap::new
            ));

        System.out.println("10) mostExpensive = " + mostExpensive);
    }
}