package lessons.lesson3;

public record Car(String country, String model, int yearOfManufacture) {

    public void printCarInfo() {
        System.out.println("Страна: " + country);
        System.out.println("Модель: " + model);
        System.out.println("Год выпуска: " + yearOfManufacture);
    }
}
