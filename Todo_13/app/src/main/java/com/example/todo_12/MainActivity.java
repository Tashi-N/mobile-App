package com.example.todo_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//    public static final String EXTRA_MESSAGE ="com.example.todo_12.extra.MESSAGE";
    String list;
    private static  final String LOG=MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void donuts(View view) {
        String donut="you ordered donut";
        list =donut;
        Toast toast=Toast. makeText(getApplicationContext(),"you ordered a donut",Toast. LENGTH_SHORT);
        toast. show();
    }

    public void ice(View view) {
        String donut="you ordered ice cream";
        list =donut;
        Toast toast=Toast. makeText(getApplicationContext(),"you ordered an ice cream",Toast. LENGTH_SHORT);
        toast. show();

    }

    public void froyo(View view) {
        String donut="you ordered froyo";
        list =donut;
        Toast toast=Toast. makeText(getApplicationContext(),"you ordered a Froyo",Toast. LENGTH_SHORT);
        toast. show();
    }


    public void go(View view) {
      Intent intent =new Intent(this,focus.class);
      intent.putExtra("list",list);
      startActivity(intent);
    }
    public void displayToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }
}