package lessons.lesson12;

import java.util.*;
import java.util.function.*;

public class FunctionalInterfaces {

    public static void main(String[] args) {
        // 1) Predicate<String>: строка не пуста и длиннее 3 символов
        Predicate<String> notEmptyAndLonger3 = s -> s != null && !s.isEmpty() && s.length() > 3;
        System.out.println("1) test1 = " + notEmptyAndLonger3.test("yes"));

        // 2) Function<String, Integer>: длина строки
        Function<String, Integer> lengthFn = String::length;
        System.out.println("2) test2 = " + lengthFn.apply("banana"));

        // 3) Supplier<UUID>: новый UUID
        Supplier<UUID> uuidSupplier = UUID::randomUUID;
        System.out.println("3) uuid = " + uuidSupplier.get());

        // 4) Consumer<String>: печатает строку в upper case
        Consumer<String> printUpper = s -> System.out.println(s.toUpperCase());
        System.out.print("4) upper: ");
        printUpper.accept("hello world");

        // 5) BiFunction<Integer, Integer, Integer>: сумма двух чисел
        BiFunction<Integer, Integer, Integer> sum = Integer::sum;
        System.out.println("5) sum of 2 and 3 = " + sum.apply(2, 3));

        // 6) trim andThen toUpperCase
        Function<String, String> trim = String::trim;
        Function<String, String> toUpperCase = String::toUpperCase;

        System.out.println("6) result = " + trim.andThen(toUpperCase).apply("  aBc  "));

        // 7) Consumer andThen: печатает строку, затем её длину
        Consumer<String> printStr = System.out::println;
        Consumer<String> printLen = s -> System.out.println(s.length());

        System.out.println("7) bothConsumers:");
        printStr.andThen(printLen).accept("hello");

        // 8) Predicate<Integer> isEven и isPositive -> "нечётное или отрицательное"
        Predicate<Integer> isEven = x -> x % 2 == 0;
        Predicate<Integer> isPositive = x -> x > 0;
        Predicate<Integer> oddOrNegative = isEven.negate().or(isPositive.negate());
        System.out.println("8) oddOrNegative on [-2,-1,0,1,2]:");
        for (int x : List.of(-2, -1, 0, 1, 2)) {
            System.out.println(x + " -> " + oddOrNegative.test(x));
        }

        // 9) BiFunction andThen Function
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        Function<Integer, String> toStr = x -> "Result: " + x;
        BiFunction<Integer, Integer, String> multipliedThenStr = multiply.andThen(toStr);
        System.out.println("9) multipliedThenStr(6, 7) = " + multipliedThenStr.apply(6, 7));

        // 10) UnaryOperator<String>: добавить "!!!"
        UnaryOperator<String> addBang = s -> s + "!!!";
        System.out.println("10) addBang(\"hey\") = " + addBang.apply("hey"));
    }
}