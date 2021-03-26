package com.example.counterhomework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int count;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.textView);
        if(savedInstanceState != null){
            count = savedInstanceState.getInt("mCount");
            mTextView.setText(String.valueOf(count));
        }
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("mCount",count);
    }

    public void count(View view) {
        count++;
        mTextView.setText(String.valueOf(count));
    }
}