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

    // Integer value
    private int mAudioResourceId;

    // String value
    private String mDefaultWord;

    // String value
    private String mMiwokWord;



    /**
     * Constructs a new object with default and miwok versions of each word
     */
    public Word(int AudioResourceId, String DefaultWord, String MiwokWord) {
        mAudioResourceId = AudioResourceId;
        mDefaultWord = DefaultWord;
        mMiwokWord = MiwokWord;
    }


    /**
     * Constructs a new object with default and miwok versions of each word
     */
    public Word(int ImageResourceId, int AudioResourceId, String DefaultWord, String MiwokWord) {
        mImageResourceId = ImageResourceId;
        mAudioResourceId = AudioResourceId;
        mDefaultWord = DefaultWord;
        mMiwokWord = MiwokWord;
    }

    // Get the image resource ID
    public int getImageResourceId() {
        return mImageResourceId;
    }

    // Get the image resource ID
    public int getAudioResourceId() {
        return mAudioResourceId;
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
