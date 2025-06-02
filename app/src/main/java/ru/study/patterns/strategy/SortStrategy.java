package ru.study.patterns.strategy;

import java.util.List;

import ru.study.patterns.data.Pattern;

public interface SortStrategy {
    List<Pattern> sort(List<Pattern> list);
}

