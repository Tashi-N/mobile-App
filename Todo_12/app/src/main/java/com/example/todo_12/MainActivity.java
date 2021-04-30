package com.example.todo_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void donuts(View view) {
        Toast toast=Toast. makeText(getApplicationContext(),"you ordered a donut",Toast. LENGTH_SHORT);
        toast. show();
    }

    public void ice(View view) {
        Toast toast=Toast. makeText(getApplicationContext(),"you ordered an ice cream",Toast. LENGTH_SHORT);
        toast. show();

    }

    public void froyo(View view) {
        Toast toast=Toast. makeText(getApplicationContext(),"you ordered a Froyo",Toast. LENGTH_SHORT);
        toast. show();
    }

    public void go(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:+97517532020"));
        startActivity(intent);
    }
}