package com.example.android.miwok;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;


    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        // Create an arraylist of word objects
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word(R.drawable.number_one, R.raw.number_one, "one", "lutti"));
        words.add(new Word(R.drawable.number_two, R.raw.number_two, "two", "otiiko"));
        words.add(new Word(R.drawable.number_three, R.raw.number_three, "three", "tolookosu"));
        words.add(new Word(R.drawable.number_four, R.raw.number_four, "four", "oyyisa"));
        words.add(new Word(R.drawable.number_five, R.raw.number_five, "five", "massokka"));
        words.add(new Word(R.drawable.number_six, R.raw.number_six, "six", "temmokka"));
        words.add(new Word(R.drawable.number_seven, R.raw.number_seven, "seven", "kenekaku"));
        words.add(new Word(R.drawable.number_eight, R.raw.number_eight, "eight", "kawinta"));
        words.add(new Word(R.drawable.number_nine, R.raw.number_nine, "nine", "wo'e"));
        words.add(new Word(R.drawable.number_ten, R.raw.number_ten, "ten", "na'aacha"));

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);
        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Word word = words.get(position);
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudioResourceId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();

    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}
