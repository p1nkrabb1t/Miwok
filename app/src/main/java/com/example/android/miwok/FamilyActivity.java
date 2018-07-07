package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
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
        words.add(new Word(R.drawable.family_father, R.raw.family_father, "father", "әpә"));
        words.add(new Word(R.drawable.family_mother, R.raw.family_mother, "mother", "әṭa"));
        words.add(new Word(R.drawable.family_son, R.raw.family_son, "son", "angsi"));
        words.add(new Word(R.drawable.family_daughter, R.raw.family_daughter, "daughter", "tune"));
        words.add(new Word(R.drawable.family_older_brother, R.raw.family_older_brother, "older brother", "taachi"));
        words.add(new Word(R.drawable.family_younger_brother, R.raw.family_younger_brother, "younger brother", "chalitti"));
        words.add(new Word(R.drawable.family_older_sister, R.raw.family_older_sister, "older sister", "teṭe"));
        words.add(new Word(R.drawable.family_younger_sister, R.raw.family_younger_sister, "younger sister", "kolliti"));
        words.add(new Word(R.drawable.family_grandmother, R.raw.family_grandmother, "grandmother", "ama"));
        words.add(new Word(R.drawable.family_grandfather, R.raw.family_grandfather, "grandfather", "paapa"));


        WordAdapter adapter = new WordAdapter(this, words, R.color.category_family);
        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Word word = words.get(position);
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getAudioResourceId());
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
