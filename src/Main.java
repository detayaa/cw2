import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws WrongTextsException {



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
                            TaskType type = readTaskType(scanner);
                            LocalDateTime time = dayTime(scanner);
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

    public static void inputTask(Scanner scanner) {
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
                return LocalDateTime.parse(dateTimeToken, DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
            } catch (DateTimeParseException e) {
                System.out.println("Попробуйте ввести в формате - dd.MM.yyyy hh:mm");
            }
        }
    }
}
