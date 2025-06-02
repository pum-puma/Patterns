package ru.study.patterns.strategy;

import java.util.Comparator;
import java.util.List;

import ru.study.patterns.data.Pattern;

public class SortByName implements SortStrategy {
    public List<Pattern> sort(List<Pattern> list) {
        list.sort(Comparator.comparing(Pattern::getName));
        return list;
    }
}

