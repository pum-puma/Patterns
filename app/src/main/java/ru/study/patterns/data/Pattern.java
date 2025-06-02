package ru.study.patterns.data;

import java.io.Serializable;

public class Pattern implements Serializable {
    private final String name;
    private final String description;
    private final String example;

    public Pattern(String name, String description, String example) {
        this.name = name;
        this.description = description;
        this.example = example;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getExample() { return example; }
}



