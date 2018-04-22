package com.example.android.miwok;

/**
 * Created by Ha3el on 08/04/2018.
 */

/**
 * Displays a word in the default language and miwok translation.
 */
public class Word {


    //default value if no image available
    private static final int NO_IMAGE = -1;

    // Integer value
    private int mImageResourceId = NO_IMAGE;

    // String value
    private String mDefaultWord;

    // String value
    private String mMiwokWord;


    /**
     * Constructs a new object with default and miwok versions of each word
     */
    public Word(String DefaultWord, String MiwokWord) {
        mDefaultWord = DefaultWord;
        mMiwokWord = MiwokWord;
    }


    /**
     * Constructs a new object with default and miwok versions of each word
     */
    public Word(int ImageResourceId, String DefaultWord, String MiwokWord) {
        mImageResourceId = ImageResourceId;
        mDefaultWord = DefaultWord;
        mMiwokWord = MiwokWord;
    }

    // Get the image resource ID
    public int getImageResourceId() {
        return mImageResourceId;
    }

    //get the default version of the word
    public String getDefaultWord() {
        return mDefaultWord;
    }

    //get the Miwok version of the word
    public String getMiwokWord() {
        return mMiwokWord;
    }

    public boolean imageAvailable(){
        return getImageResourceId() != NO_IMAGE;
    }


}
