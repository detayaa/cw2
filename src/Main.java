import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws WrongTextsException {

        HashMap<String, Integer> tasks = new HashMap();

        Tasks hair = new Tasks("Стрижка", "сходить в парикмахерскую", "личная", "ежемесячная");
        hair.tasks();
        hair.Time();
        tasks.put(hair.getName(), hair.getId());
        Tasks petShop = new Tasks("Зоомагазин", "купить корм собаке", "личная", "еженедельная");
        petShop.tasks();
        petShop.Time();
        tasks.put(petShop.getName(), petShop.getId());
        Tasks meetings = new Tasks("Встреча", "созвониться с коллегами", "рабочая", "однократная");
        meetings.tasks();
        meetings.Time();
        tasks.put(meetings.getName(), hair.getId());
        System.out.println(tasks);
    }
}
