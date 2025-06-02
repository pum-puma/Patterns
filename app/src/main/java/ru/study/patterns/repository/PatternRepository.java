package ru.study.patterns.repository;

import java.util.ArrayList;
import java.util.List;

import ru.study.patterns.data.Pattern;

public class PatternRepository {
    private static PatternRepository instance;
    private final List<Pattern> patterns;

    private PatternRepository() {
        patterns = loadPatterns();
    }

    public static PatternRepository getInstance() {
        if (instance == null) {
            instance = new PatternRepository();
        }
        return instance;
    }

    public List<Pattern> getAllPatterns() {
        return patterns;
    }

    public List<Pattern> loadPatterns() {
        List<Pattern> list = new ArrayList<>();

        list.add(new Pattern(
                "Singleton",
                "Позволяет создать только один экземпляр класса. Пример — электросчетчик в доме: он один и общий",
                "public class Singleton {\n" +
                        "    private static Singleton instance;\n" +
                        "    private Singleton() {}\n" +
                        "    public static Singleton getInstance() {\n" +
                        "        if (instance == null) instance = new Singleton();\n" +
                        "        return instance;\n" +
                        "    }\n" +
                        "}"
        ));

        list.add(new Pattern(
                "Factory Method",
                "Определяет интерфейс создания объекта, позволяя подклассам решать, какой класс инстанцировать",
                "abstract class Dialog {\n" +
                        "    public void render() {\n" +
                        "        Button button = createButton();\n" +
                        "        button.render();\n" +
                        "    }\n" +
                        "    protected abstract Button createButton();\n" +
                        "}"
        ));

        list.add(new Pattern(
                "Strategy",
                "Позволяет менять алгоритм выполнения задачи на лету. Например, разные способы сортировки",
                "interface Strategy {\n" +
                        "    int execute(int a, int b);\n" +
                        "}\n\n" +
                        "class Add implements Strategy {\n" +
                        "    public int execute(int a, int b) { return a + b; }\n" +
                        "}"
        ));

        list.add(new Pattern(
                "Observer",
                "Когда объект уведомляет других о своих изменениях. Пример — YouTube уведомляет подписчиков",
                "interface Observer {\n" +
                        "    void update(String message);\n" +
                        "}\n\n" +
                        "class Channel {\n" +
                        "    private List<Observer> subs = new ArrayList<>();\n" +
                        "    public void subscribe(Observer o) { subs.add(o); }\n" +
                        "    public void notifyAll(String msg) {\n" +
                        "        for (Observer o : subs) o.update(msg);\n" +
                        "    }\n" +
                        "}"
        ));

        list.add(new Pattern(
                "Command",
                "Инкапсулирует запрос как объект. Удобно для отмены и повторов",
                "interface Command {\n" +
                        "    void execute();\n" +
                        "}\n\n" +
                        "class LightOnCommand implements Command {\n" +
                        "    public void execute() { System.out.println(\"Свет включен\"); }\n" +
                        "}"
        ));

        return list;
    }
}


