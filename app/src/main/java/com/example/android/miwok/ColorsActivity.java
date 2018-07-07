package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
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


        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word(R.drawable.color_red, R.raw.color_red, "red", "weṭeṭṭi"));
        words.add(new Word(R.drawable.color_green, R.raw.color_green, "green", "chokokki"));
        words.add(new Word(R.drawable.color_brown, R.raw.color_brown, "brown", "ṭakaakki"));
        words.add(new Word(R.drawable.color_gray, R.raw.color_gray, "grey", "ṭopoppi"));
        words.add(new Word(R.drawable.color_black, R.raw.color_black, "black", "kululli"));
        words.add(new Word(R.drawable.color_white, R.raw.color_white, "white", "kelelli"));
        words.add(new Word(R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow, "dusty yellow", "ṭopiisә"));
        words.add(new Word(R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow, "mustard yellow", "chiwiiṭә"));


        WordAdapter adapter = new WordAdapter(this, words, R.color.category_colors);
        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Word word = words.get(position);
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getAudioResourceId());
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
