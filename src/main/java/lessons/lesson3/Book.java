package lessons.lesson3;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private final String isbn;
    private final String name;
    private final String author;
    private final int year;
    private String status;

    private static final List<Book> books = new ArrayList<>();

    public Book(String isbn, String name, String author, int year) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.year = year;
        this.status = "в наличии"; // по умолчанию
    }

    public void getBookInfo() {
        System.out.println("ISBN: " + isbn +
            ", Название: " + name +
            ", Автор: " + author +
            ", Год: " + year +
            ", Статус: " + status);
    }

    public static void getBooks() {
        if (books.isEmpty()) {
            System.out.println("Книг пока нет.");
        } else {
            for (Book b : books) {
                b.getBookInfo();
            }
        }
    }

    public static void addNewBook(Book book) {
        books.add(book);
        System.out.println("Книга добавлена: " + book.name);
    }

    public void reserveBook() {
        if (status.equals("в наличии")) {
            status = "зарезервирована";
            System.out.println("Книга \"" + name + "\" успешно зарезервирована!");
        } else {
            System.out.println("Книга \"" + name + "\" уже зарезервирована.");
        }
    }
}

