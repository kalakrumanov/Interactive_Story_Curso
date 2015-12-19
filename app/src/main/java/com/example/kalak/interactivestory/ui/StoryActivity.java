package com.example.kalak.interactivestory.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kalak.interactivestory.R;
import com.example.kalak.interactivestory.model.Page;
import com.example.kalak.interactivestory.model.Story;

public class StoryActivity extends AppCompatActivity {

    public static final String TAG = StoryActivity.class.getSimpleName();

    private Story mStory = new Story();
    private ImageView mImageView;
    private TextView mTextView;
    private Button mChoice1;
    private Button mChoice2;
    private String mName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        mName = intent.getStringExtra(getString(R.string.key_name));

        if (mName == null) {
            mName = "nombre";
        }

        Log.d(TAG, mName);

        mImageView = (ImageView) findViewById(R.id.storyImageView);
        mTextView = (TextView) findViewById(R.id.storyTextView);
        mChoice1 = (Button) findViewById(R.id.choiceButton1);
        mChoice2 = (Button) findViewById(R.id.choiceButton2);

        loadPage();
    }


    private void loadPage() {
        Page page = mStory.getPage(1);


        //Drawable drawable = ResourcesCompat.getDrawable(getResources(), page.getmImageId(), null);
        //Drawable drawable = ContextCompat.getDrawable(this, page.getmImageId());
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.page1);
        mImageView.setImageDrawable(drawable);


        String pageText = page.getmText();

        // Añade si tenemos un placeholder "%1", y si no, nada
        pageText = String.format(pageText,mName);

        mTextView.setText(pageText);

        mChoice1.setText(page.getmChoice1().getmText());
        mChoice2.setText(page.getmChoice2().getmText());

    }

}
