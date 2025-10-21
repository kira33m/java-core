package lessons.lesson2;

import java.util.Scanner;

public class Practice3_quest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String choice;
        String restart;

        do {
            // Сцена 1: Пробуждение
            System.out.println("Ты открываешь глаза и понимаешь — лежишь на влажном песке у берега озера.");
            System.out.println("Всё окутано густым туманом, над водой висит гнетущая тишина.");
            System.out.println("В кармане — почти разряженный телефон (1%) и спичка с обрывком бумаги:");
            System.out.println("\"Не верь голосам. Держись севера.\"");
            System.out.println();
            System.out.println("Выбор:");
            System.out.println("1 - Пойти на восток, туда, где мерцает слабый свет.");
            System.out.println("2 - Следовать на север, как советует записка.");
            System.out.println("3 - Остаться у озера и ждать.");
            System.out.print("Ввод (1/2/3): ");
            choice = in.nextLine().trim();

            switch (choice) {
                case "1" -> {
                    // Сцена 2A: Восточный свет
                    System.out.println("Ты идёшь к свету и находишь полуразрушенную электростанцию.");
                    System.out.println("Внезапно включается прожектор, режущий глаза.");
                    System.out.println("Из громкоговорителя доносится металлический голос: «Стоять. Идентификация…»");
                    System.out.println("Выбор:");
                    System.out.println("1 - Закричать: «Я человек! Помогите!»");
                    System.out.println("2 - Броситься назад в темноту.");
                    System.out.print("Ввод (1/2): ");
                    choice = in.nextLine().trim();

                    if (choice.equals("1")) {
                        System.out.println("Ты кричишь изо всех сил. Прожектор слепит, а из тумана выходит фигура в противогазе.");
                        System.out.println("Последнее, что ты чувствуешь — укол в шею. Ты теряешь сознание.");
                        System.out.println("Очнувшись, понимаешь: ты стал частью эксперимента.");
                        System.out.println("Концовка: Неудача");
                    } else if (choice.equals("2")) {
                        System.out.println("Ты бросаешься прочь, но корни под ногами сбивают тебя с ног.");
                        System.out.println("Прожектор гаснет, а в темноте что-то быстро приближается.");
                        System.out.println("Твоё исчезновение так никто и не заметит.");
                        System.out.println("Концовка: Неудача");
                    } else {
                        System.out.println("Неверный ввод. Игра окончена.");
                    }
                }
                case "2" -> {
                    // Сцена 2B: Северный путь
                    System.out.println("Ты следуешь на север, пока не находишь брошенную деревню.");
                    System.out.println("В одном доме ещё тлеют угли костра. На столе лежит дневник:");
                    System.out.println("\"Озеро пробуждается в полнолуние. Не верь голосам. Прячься до рассвета.\"");
                    System.out.println("Выбор:");
                    System.out.println("1 - Остаться в доме и переждать ночь.");
                    System.out.println("2 - Продолжить путь в туман.");
                    System.out.print("Ввод (1/2): ");
                    choice = in.nextLine().trim();

                    if (choice.equals("1")) {
                        System.out.println("Ты остаёшься у костра. Время тянется мучительно медленно.");
                        System.out.println("Но на рассвете из тумана выходят люди — выжившие. Они забирают тебя с собой.");
                        System.out.println("Концовка: Победа");
                    } else if (choice.equals("2")) {
                        System.out.println("Ты идёшь сквозь густой туман и неожиданно выходишь к старому маяку.");
                        System.out.println("На верхнем этаже работает рация. Связь удаётся установить.");
                        System.out.println("На следующий день приходит помощь.");
                        System.out.println("Концовка: Победа");
                    } else {
                        System.out.println("Неверный ввод. Игра окончена.");
                    }
                }
                case "3" -> {
                    // Сцена 2C: Ожидание у озера
                    System.out.println("Ты остаёшься на месте. Вдруг из тумана доносится тихий детский голос:");
                    System.out.println("«Помоги мне… пожалуйста…»");
                    System.out.println("Холод пробегает по спине.");
                    System.out.println("Выбор:");
                    System.out.println("1 - Пойти на голос.");
                    System.out.println("2 - Убежать прочь в лес.");
                    System.out.print("Ввод (1/2): ");
                    choice = in.nextLine().trim();

                    if (choice.equals("1")) {
                        System.out.println("Ты идёшь на зов и видишь девочку в белом платье. Она улыбается и медленно растворяется в воде.");
                        System.out.println("Из глубины поднимаются тени. Твоё тело не слушается.");
                        System.out.println("Концовка: Проклятие озера");
                    } else if (choice.equals("2")) {
                        System.out.println("Ты бросаешься в лес и натыкаешься на металлический люк.");
                        System.out.println("Внутри — бункер, полный карт, журналов и экранов с изображением озера.");
                        System.out.println("Выбор:");
                        System.out.println("1 - Уничтожить центр управления.");
                        System.out.println("2 - Вступить в проект.");
                        System.out.print("Ввод (1/2): ");
                        choice = in.nextLine().trim();

                        if (choice.equals("1")) {
                            System.out.println("Ты активируешь механизм самоуничтожения. Земля содрогается, озеро вспыхивает ярким светом.");
                            System.out.println("Тьма уходит… но ты погибаешь вместе с ней.");
                            System.out.println("Концовка: Герой");
                        } else if (choice.equals("2")) {
                            System.out.println("Ты принимаешь их условия. Тебе дают новое имя, новую жизнь.");
                            System.out.println("Теперь ты часть того, что пугало тебя этой ночью.");
                            System.out.println("Концовка: Тайный участник");
                        } else {
                            System.out.println("Неверный ввод. Игра окончена.");
                        }

                    } else {
                        System.out.println("Неверный ввод. Игра окончена.");
                    }
                }
                default -> System.out.println("Неверный ввод. Игра окончена.");
            }

            // Предложение начать заново
            System.out.println();
            System.out.print("Хотите начать заново? (y/n): ");
            restart = in.nextLine().trim();

        } while (restart.equalsIgnoreCase("y"));

        System.out.println("Спасибо за игру! До встречи...");
        in.close();
    }
}
