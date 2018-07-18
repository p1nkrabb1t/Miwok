package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ha3el on 12/04/2018.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    /**
     * Resource ID for the background color for this list of words
     */
    private int mColorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceID) {
        super(context, 0, words);
        mColorResourceId = colorResourceID;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        // Get the word object located at this position in the list
        Word currentWord = getItem(position);

        // Find and update the ImageView in the playlist_item.xml layout with the image ID
        ImageView iconImageView = (ImageView) listItemView.findViewById(R.id.image);


        // Check if an image is provided for this word or not
        if (currentWord.imageAvailable()) {
            // If an image is available, display the provided image based on the resource ID
            iconImageView.setImageResource(currentWord.getImageResourceId());
            // Make sure the view is visible
            iconImageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            iconImageView.setVisibility(View.GONE);
        }

        // Find the TextView in the list_item.xml layout with the miwok word ID
        TextView miwokTranslationTextView = (TextView) listItemView.findViewById(R.id.word_miwok);
        // Get the version name from the current Word object and
        // set this text on the Miwok translation TextView
        miwokTranslationTextView.setText(currentWord.getMiwokWord());

        // Find the TextView in the list_item.xml layout with the default word ID version_name
        TextView defaultTranslationTextView = (TextView) listItemView.findViewById(R.id.word_default);
        // Get the version name from the current Word object and
        // set this text on the default translation TextView
        defaultTranslationTextView.setText(currentWord.getDefaultWord());

        // Get the background colour ID depending on section
        View listItemBackground = (View) listItemView.findViewById(R.id.background);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        listItemBackground.setBackgroundColor(color);


        // Return the whole list item layout (containing 2 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
