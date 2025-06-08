package ru.study.patterns.ui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ru.study.patterns.R;
import ru.study.patterns.data.Pattern;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Pattern pattern = (Pattern) getIntent().getSerializableExtra("pattern");

        assert pattern != null;

        ((TextView) findViewById(R.id.patternName)).setText(pattern.getName());
        ((TextView) findViewById(R.id.patternDescription)).setText(pattern.getDescription());
        ((TextView) findViewById(R.id.patternExample)).setText(pattern.getExample());
    }
}

