import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws WrongTextsException {

//        HashMap<String, Integer> tasks = new HashMap();
//
//        Tasks hair = new Tasks("Стрижка", "сходить в парикмахерскую", "личная", "ежемесячная");
//        hair.tasks();
//        hair.Time();
//        tasks.put(hair.getName(), hair.getId());
//        Tasks petShop = new Tasks("Зоомагазин", "купить корм собаке", "личная", "еженедельная");
//        petShop.tasks();
//        petShop.Time();
//        tasks.put(petShop.getName(), petShop.getId());
//        Tasks meetings = new Tasks("Встреча", "созвониться с коллегами", "рабочая", "однократная");
//        meetings.tasks();
//        meetings.Time();
//        tasks.put(meetings.getName(), hair.getId());
//        System.out.println(tasks);


        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner);
                            describe(scanner);
                            readTaskType(scanner);
                            dayTime(scanner);
                            break;
                        case 2:
                            removeTask(scanner);
                            break;
                        case 3:
                            dayTask(scanner);
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }

    private static void inputTask(Scanner scanner) {
        System.out.println("Введите название задачи:");
        String name = scanner.next();

    }

    public static void describe(Scanner scanner) {
        System.out.println("Введите описание задачи:");
        String name = scanner.next();
    }

    private static void removeTask(Scanner scanner) {
        System.out.print("Введите название задачи: ");
        String taskName = scanner.next();
        // todo
    }

    private static void dayTask(Scanner scanner) {
        System.out.print("Введите указанный день: ");
        String taskName = scanner.next();
        // todo
    }

    private static void printMenu() {
        System.out.println(
                "1. Добавить задачу \n2. Удалить задачу \n3. Получить задачу на указанный день \n0. Выход "
        );
    }

    public static TaskType readTaskType(Scanner scanner) {
        System.out.println("Выберете тип задачи \n1. Персональная, \n2. Рабочая");
        while (true) {
            try {
                System.out.println("Введите тип задачи: ");
                int taskType = scanner.nextInt();
                switch (taskType) {
                    case 1:
                        return TaskType.PERSONAL;
                    case 2:
                        return TaskType.WORK;
                    default:
                        System.out.println("Введён неправильный тип задачи");
                }
            } catch (Exception e) {
                System.out.println("Введён неправильный тип задачи");
                scanner.reset();
            }
        }

    }

    public static LocalDateTime dayTime(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Введите дату выполнения задачи: ");
                String dateTimeToken = scanner.nextLine();
                return LocalDateTime.parse(dateTimeToken, DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm"));
            } catch (DateTimeParseException e) {
                System.out.println("Неправильно введена дата, попробуйте ввести в формате - dd.MM.yyyy hh:mm");
            }
        }
    }
}
