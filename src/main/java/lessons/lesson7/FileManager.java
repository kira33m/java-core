package lessons.lesson7;

import java.io.*;
import java.util.List;

public class FileManager {
    private static final String FILE_NAME = "seats.txt";

    public static void save(List<Seat> seats) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(seats);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении данных: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    public static List<Seat> load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Seat>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("⚠ Не удалось загрузить сохранённые места, создаётся новый самолёт.");
            return null;
        }
    }
}