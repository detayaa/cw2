import java.time.LocalDate;

public class Tasks implements LocalTime {
    String name;
    String describe;
    String type;
    private static int i = 0;
    private final int id;
    String repeatability;
    private static final String NO_TEXTS = "Не введены данные";

    public Tasks(String name, String describe, String type, String repeatability) throws WrongTextsException {
        if (name != null && name.isEmpty() && name.isBlank()) {
            throw new WrongTextsException(NO_TEXTS);
        } else {
            this.name = name;}
        if (describe != null && describe.isEmpty() && describe.isBlank()) {
            throw new WrongTextsException(NO_TEXTS);
        } else {this.describe = describe;
        }
        if (type != null && type.isEmpty() && type.isBlank()) {
            throw new WrongTextsException(NO_TEXTS);
        } else {this.type = type;
        }
        if (repeatability != null && repeatability.isEmpty() && repeatability.isBlank()) {
            throw new WrongTextsException(NO_TEXTS);
        } else {this.repeatability = repeatability;
        }
        i++;
        this.id = i;

    }

    public void tasks() {
        System.out.println("Задача - " + name + ", нужно  " + describe + ", задача " + type + ", повторяемость " + repeatability);
    }

    public String getRepeatability() {
        return repeatability;
    }

    public void setRepeatability(String repeatability) {
        this.repeatability = repeatability;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void LocalTimeNow() {
        System.out.println(LocalDate.now());
    }

    @Override
    public void LocalTimeTomorrow() {
        LocalDate date = LocalDate.now();
        date = date.plusDays(1);
        System.out.println(date);


    }

    @Override
    public void LocalTimeWeek() {
        LocalDate date = LocalDate.now();
        date = date.plusWeeks(1);
        System.out.println(date);
    }

    @Override
    public void LocalTimeMonth() {
        LocalDate date = LocalDate.now();
        date = date.plusMonths(1);
        System.out.println(date);
    }

    @Override
    public void LocalTimeYear() {
        LocalDate date = LocalDate.now();
        date = date.plusYears(1);
        System.out.println(date);
    }

    @Override
    public void Time() {
        if (getRepeatability() == "однократная") {
            LocalTimeNow();
        } else if (getRepeatability() == "ежедневная") {
            LocalTimeTomorrow();
        } else if (getRepeatability() == "еженедельная") {
            LocalTimeWeek();
        } else if (getRepeatability() == "ежемесячная") {
            LocalTimeMonth();
        } else if (getRepeatability() == "ежегодная"){
            LocalTimeYear();
        }

    }
}
