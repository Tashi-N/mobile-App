package com.example.activity1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity{
    public static final String extra_reply="com.example.activity1.reply";
    private TextView textview;
    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent =getIntent();
        String msg=intent.getStringExtra(MainActivity.Extra_Message);
        textview = findViewById(R.id.editTextreceived);
        textview.setText(msg);
        editText= findViewById(R.id.editTextreply2);
    }


    public void reply(View view) {
        String message =editText.getText().toString();

        Intent obj= new Intent();
        obj.putExtra(extra_reply,message);
        setResult(RESULT_OK,obj);
        finish();

    }
}