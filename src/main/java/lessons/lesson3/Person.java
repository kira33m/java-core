package lessons.lesson3;

import lombok.Data;
@Data

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void introduce() {
        System.out.println("Привет, меня зовут " + name + ".Мне " + age + " лет.");
    }
}