package com.example.kalak.interactivestory.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.kalak.interactivestory.R;

public class MainActivity extends AppCompatActivity {

    private EditText mNameFiled;
    private Button mStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameFiled = (EditText) findViewById(R.id.nameEditText);
        mStartButton = (Button) findViewById(R.id.StartButton);

        // Cundo hago click:
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mNameFiled.getText().toString();

                startStory(name);

            }
        });
    }

    private void startStory(String name) {
        Intent intent = new Intent(this, StoryActivity.class);
        intent.putExtra(getString(R.string.key_name),name);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mNameFiled.setText("");
    }
}
