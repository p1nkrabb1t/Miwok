package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word(R.drawable.color_red,"red","weṭeṭṭi"));
        words.add(new Word(R.drawable.color_green,"green", "chokokki"));
        words.add(new Word(R.drawable.color_brown,"brown", "ṭakaakki"));
        words.add(new Word(R.drawable.color_gray,"grey", "ṭopoppi"));
        words.add(new Word(R.drawable.color_black,"black", "kululli"));
        words.add(new Word(R.drawable.color_white,"white", "kelelli"));
        words.add(new Word(R.drawable.color_dusty_yellow,"dusty yellow", "ṭopiisә"));
        words.add(new Word(R.drawable.color_mustard_yellow,"mustard yellow", "chiwiiṭә"));


        WordAdapter adapter = new WordAdapter(this, words, R.color.category_colors);
        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);



    }
}
