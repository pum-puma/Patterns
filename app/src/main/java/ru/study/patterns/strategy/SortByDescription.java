package ru.study.patterns.strategy;

import java.util.Comparator;
import java.util.List;

import ru.study.patterns.data.Pattern;

public class SortByDescription implements SortStrategy {
    @Override
    public List<Pattern> sort(List<Pattern> list) {
        list.sort(Comparator.comparing(Pattern::getDescription));
        return list;
    }
}
