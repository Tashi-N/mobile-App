package com.example.todo_11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Button btn;
    private String[] colorArray = {"red", "pink", "purple", "deep_purple",
            "indigo", "blue", "light_blue", "cyan", "teal", "green",
            "light_green", "lime", "yellow", "amber", "orange", "deep_orange",
            "brown", "grey", "blue_grey", "black"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.textView);
        if (savedInstanceState != null) {
            tv.setTextColor(savedInstanceState.getInt("color"));
        }

    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // save the current text color
        outState.putInt("color", tv.getCurrentTextColor());
    }

    public void color(View view) {
        Random random =new Random();
        String colorName=colorArray[random.nextInt(20)];

        int colorResourceName= getResources().getIdentifier(colorName,
                "color", getApplicationContext().getPackageName());



        int colorRes = ContextCompat.getColor(this, colorResourceName);

        tv.setTextColor(colorRes);

    }
}