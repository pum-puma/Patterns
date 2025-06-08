package ru.study.patterns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import java.util.stream.Collectors;

import ru.study.patterns.R;
import ru.study.patterns.strategy.SortByName;
import ru.study.patterns.strategy.SortStrategy;
import ru.study.patterns.data.Pattern;
import ru.study.patterns.repository.PatternRepository;


public class MainActivity extends AppCompatActivity {
    private List<Pattern> patterns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.patternListView);
        patterns = PatternRepository.getInstance().getAllPatterns();

        SortStrategy strategy = new SortByName();
        patterns = strategy.sort(patterns);

        List<String> names = patterns.stream().map(Pattern::getName).collect(Collectors.toList());
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("pattern", patterns.get(position));
            startActivity(intent);
        });
    }
}

